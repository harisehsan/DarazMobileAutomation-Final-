def build(String Module, String Theme,String MoreTags){
    if (isUnix()) {
        echo "${Module}"
        echo "${Theme}";
        echo "${MoreTags}";
        echo "this is output from external funtion"
        String cucumberOpt = "\"src/test/java/${Module}/${Theme}/features --tags ${Tags}+${MoreTags} --glue ${Module}.${Theme}.step_definitions --glue _base.${Theme}_steps\""
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