def build(String Module, String Theme,String Tags,String Venture_Env){
    if (isUnix()) {
        String venture = Venture_Env.split("\\.")[0]
        String env = Venture_Env.split("\\.")[1]
        String excludedTags = "--tags 'not @no_${env}' --tags 'not @no_${venture}' --tags 'not @no_${venture}_${env}' "
        String resultTags = excludedTags +"--tags "+Tags
        String cucumberOpt = "\"src/test/java/${Module}/${Theme}/features ${resultTags} --glue ${Module}.${Theme}.step_definitions --glue _base.${Theme}_steps --glue _base.api_steps\""
        try {
            sh "mvn clean test -Dcucumber.options=${cucumberOpt} -Denv=\"${Venture}\" -Dtheme=\"${Theme}\""
            currentBuild.result = 'SUCCESS'
        } catch (Exception err) {
            currentBuild.result = 'FAILURE'
            echo err.getMessage()
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