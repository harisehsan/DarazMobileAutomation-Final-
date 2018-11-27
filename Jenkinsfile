import com.google.inject.Module

node("jenkins_slave") {
            script {
                currentBuild.displayName = "${Tags}_${Venture}_${BUILD_NUMBER}"
                currentBuild.description = "Running on Branch ${BRANCH} on ${Venture} env with tags ${Tags} theme ${Theme}"
            }
            // sh "echo mvn --version"
            // sh "cat $HOME/.m2/settings.xml"
            // def mvnHome
            stage('Preparation') { // for display purposes
                // Get some code from a GitHub repository
                echo "${BRANCH}"
                git branch: "${BRANCH}",
                        credentialsId: '1c2e3307-4c7b-47c2-aa19-51e6cfa0036c',
                        url: 'git@gitlab.alibaba-inc.com:chison.ton/UI_Automation.git'
                if ("${Venture}".contains(".staging")) {
                    def output = readFile(pwd() + "/host/staging_host").trim()
                    sh "echo \"${output}\" >> /etc/hosts"
                    def old = readFile("/etc/hosts").trim()
                    echo old
                }
            }
            stage('Build') {
                def jenkins_job = load pwd() + "/pipeline/test_job.groovy"
                if(Module == null || Module.toString() == ""){
                    jenkins_job.run(Theme, Tags, Venture)
                }else{
                    jenkins_job.run(Module,Theme, Tags, Venture)
                }

            }

        }