node("jenkins_slave") {
    stage('Preparation') {
        echo "${BRANCH}"
        git branch: "${BRANCH}",
                credentialsId: '1c2e3307-4c7b-47c2-aa19-51e6cfa0036c',
                url: 'git@gitlab.alibaba-inc.com:chison.ton/UI_Automation.git'
    }
}

def build(String Site) {
    def parameters = [
            string(name: 'Module', value: "${Module}"),
            string(name: 'Theme', value: "${Theme}"),
            string(name: 'BRANCH', value: "${BRANCH}"),
            string(name: 'Tags', value: "${Tags}"),
            string(name: 'Venture_Env', value: "${}"),

    ]

    if (Site.equalsIgnoreCase("lazada")) {
        parallel ID: {
                stage('ID')
                    {
                        build job: 'ID', parameters: parameters
                    }
                },
                MY: {
                    stage('MY')
                            {
                                build jobma: 'MY', parameters: parameters
                            }
                },
                PH: {
                    stage('PH')
                            {
                                build job: 'PH', parameters: parameters
                            }
                },
                SG: {
                    stage('SG')
                            {
                                build job: 'SG', parameters: parameters
                            }
                },
                VN: {
                    stage('VN')
                            {
                                build job: 'DRZ_NP', parameters: parameters
                            }
                },
                TH: {
                    stage('TH')
                            {
                                build job: 'TH', parameters: parameters
                            }
                }
        }else if(Site.equalsIgnoreCase("daraz")){
            parallel BD: {
            stage ('BD')
                    {
                        build job: 'DRZ_BD', parameters: parameters
                    }
            },
                LK: {
                    stage ('LK')
                            {
                                build job: 'DRZ_LK', parameters: parameters
                            }
                },
                PK: {
                    stage ('PK')
                            {
                                build job: 'DRZ_PK', parameters: parameters
                            }
                },
                MM: {
                    stage ('MM')
                            {
                                build job: 'DRZ_MM', parameters: parameters
                            }
                },
                NP: {
                    stage ('NP')
                            {
                                build job: 'DRZ_NP', parameters: parameters
                            }
                }


        }

    }

return this





