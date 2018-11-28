node("jenkins_slave")
        {
            script {
                currentBuild.displayName = "${Tags}_${Venture}_${BUILD_NUMBER}"
                currentBuild.description = "Running on Branch ${BRANCH} on ${Venture} env with tags ${Tags} theme ${Theme}"
            }
            stage('Preparation') { // for display purposes
                git branch: "${BRANCH}",
                        credentialsId: '1c2e3307-4c7b-47c2-aa19-51e6cfa0036c',
                        url: 'git@gitlab.alibaba-inc.com:chison.ton/UI_Automation.git'
            }
            stage('Set Host File') { // this is to bind the neccessary host
                def host_config = load pwd() + "/pipeline/host_config.groovy"
                host_config.setHost(Venture)
            }
            stage('Build') {
                def jenkins_job = load pwd() + "/pipeline/test_job.groovy"
                if (Module == null || Module.toString() == "") {
                    jenkins_job.run(Theme, Tags, Venture)
                } else {
                    jenkins_job.run(Module, Theme, Tags, Venture)
                }
            }
        }