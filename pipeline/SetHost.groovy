def setHost(String venture_env){
    if(venture_env.equalsIgnoreCase("staging")){
        def output=readFile(pwd()+"/host/staging_host").trim()
        sh "echo \"${output}\" >> /etc/hosts"
    }
}