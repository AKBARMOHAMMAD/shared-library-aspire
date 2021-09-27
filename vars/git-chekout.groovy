
def checkOut(Map stageParams) {
    script {
        echo "checking out repo to $workspace"
        echo "Branch is set to $BRANCH"
        checkout([$class: 'GitSCM', 
        branches: [[name: stageParams.branch]], 
        doGenerateSubmoduleConfigurations: false, 
        extensions: [], 
        submoduleCfg: [], 
        userRemoteConfigs: [[credentialsId: stageParams.credentialsId, url: stageParams.url]]])
    }
}

#return this