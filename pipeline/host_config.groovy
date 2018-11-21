def setHost(String venture_env){
    if(venture_env.contains("staging")){
        def output=readFile(pwd()+"/host/staging_host").trim()
        sh "echo \"${output}\" >> /etc/hosts"
    }
}

return this