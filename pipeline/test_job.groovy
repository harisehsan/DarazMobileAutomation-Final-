def run(String Module, String Theme,String Tags,String Venture_Env){
    String cucumberOpt = createCucumberOpts(Module,Theme,Tags,Venture_Env)
    String shCommand =  "mvn clean test -Dcucumber.options=${cucumberOpt} -Denv=\"${Venture_Env}\" -Dtheme=\"${Theme}\""
    build(shCommand)
}

def run(String Theme,String Tags,String Venture_Env){
    String cucumberOpt = createCucumberOpts(Theme,Tags,Venture_Env)
    String shCommand =  "mvn clean test -Dcucumber.options=${cucumberOpt} -Denv=\"${Venture_Env}\" -Dtheme=\"${Theme}\""
    build(shCommand)
}

private def build(String shCommand){
    try {
        sh "${shCommand}"
        currentBuild.result = 'SUCCESS'
    } catch (Exception err) {
        currentBuild.result = 'FAILURE'
        echo err.getMessage()
    } finally{
        stage('reports') { reportByJenkinsAllurePlugin() }
    }
}


private def createCucumberOpts(String Theme,String Tags,String Venture_Env){
    String excludedTags = createExcludedTag(Venture_Env)
    String gluedSteps = "--glue checkout.${theme}.step_definitions " +
            "--glue member.${theme}.step_definitions " +
            "--glue homepage.${theme}.step_definitions " +
            "--glue pdp.${theme}.step_definitions "
    String featureFolder = "./src/test/java/regression/features"
    sh "mkdir -p '${featureFolder}' && find . -path \"*/${theme}/*.feature\" -exec cp -prv '{}' '${featureFolder}' ';'"

    String cucumberOpt = "\"${featureFolder} --tags ${Tags} ${excludedTags} ${gluedSteps} --glue _base.${Theme}_steps --glue _base.api_steps\""
    return cucumberOpt
}

private def createCucumberOpts(String Module,String Theme,String Tags,String Venture_Env){
    String excludedTags = createExcludedTag(Venture_Env)
    String gluedSteps = " --glue ${Module}.${Theme}.step_definitions "
    String featureFolder = "src/test/java/${Module}/${Theme}/features"
    String cucumberOpt = "\"${featureFolder} --tags ${Tags} ${excludedTags} ${gluedSteps} --glue _base.${Theme}_steps --glue _base.api_steps\""
    return cucumberOpt
}

private def createExcludedTag(String Venture_Env){
    String venture = Venture_Env.split("\\.")[0]
    String env = Venture_Env.split("\\.")[1]
    String site=""
    if(["bd","lk","pk","mm","np"].contains(venture)){site = "drz"}
    else if(["sg","th","ph","my","vn","id"].contains(venture)){site = "lzd"}
    String excludedTags = "--tags 'not @no_${env}' " +
            "--tags 'not @no_${venture}' " +
            "--tags 'not @no_${venture}_${env}' " +
            "--tags 'not @no_${site}' " +
            "--tags 'not @no_${site}_${env}' " +
            "--tags 'not @wip' "
    return excludedTags
}


private def reportByJenkinsAllurePlugin(){
    script {
        allure([includeProperties: false, jdk: '', properties: [], reportBuildPolicy: 'ALWAYS', results: [[path:'target/allure-results']]])
    }
}

return this
