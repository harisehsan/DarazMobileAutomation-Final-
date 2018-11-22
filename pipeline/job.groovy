def build(String Module, String Theme,String Tags,String Venture_Env){
    if (isUnix()) {
        String venture = Venture_Env.split("\\.")[0]
        String env = Venture_Env.split("\\.")[1]
        String site=""
        if(["bd","lk","pk","mm","np"].contains(venture)){
            site = "drz"
        }else if(["sg","th","ph","my","vn","id"].contains(venture)){
            site = "lzd"
        }
        String excludedTags = "--tags 'not @no_${env}' " +
                "--tags 'not @no_${venture}' " +
                "--tags 'not @no_${venture}_${env}' " +
                "--tags 'not @no_${site}' " +
                "--tags 'not @no_${site}_${env}' "
        String rerunPlugin = "rerun:target/cucumber-reports/rerun-reports/rerun.txt"

        String cucumberOpt = "\"src/test/java/${Module}/${Theme}/features --tags ${Tags} ${excludedTags} --glue ${Module}.${Theme}.step_definitions --glue _base.${Theme}_steps --glue _base.api_steps\" --plugin ${rerunPlugin}"

        try {
            sh "mvn clean test -Dcucumber.options=${cucumberOpt} -Denv=\"${Venture_Env}\" -Dtheme=\"${Theme}\""
            currentBuild.result = 'SUCCESS'
        } catch (Exception err) {
            try{
                echo err
                String cucumberOptRerun = "\"src/test/java/${Module}/${Theme}/features --tags @${rerunPlugin} --glue ${Module}.${Theme}.step_definitions --glue _base.${Theme}_steps --glue _base.api_steps\""
                sh "mvn test -Dcucumber.options=${cucumberOptRerun} -Denv=\"${Venture_Env}\" -Dtheme=\"${Theme}\""
            }catch (Exception rerunErr){
                echo rerunErr
                currentBuild.result = 'FAILURE'
            }
            currentBuild.result = 'SUCCESS'
        } finally{
            stage('reports') {
                script {
                    allure([
                            includeProperties: false,
                            jdk              : '',
                            properties       : [],
                            reportBuildPolicy: 'ALWAYS',
                            results          : [[path:'target/allure-results']]
                    ])
                }

            }
        }
    } else {
        bat(/ "${mvnHome}\bin\mvn" - Dmaven.test.failure.ignore clean package/)
    }
}

return this