def uploadImage(APPNAME, DOCKER_URL, DOCKER_REPO, REGISTRY_CREDS) {
        script {
            docker.withRegistry("$DOCKER_URL", REGISTRY_CREDS) {
                docker.image("$DOCKER_REPO").push("${env.BUILD_NUMBER}")
                //docker.image("$DOCKER_REPO/" + "$APPNAME").push("'${env.BUILD_NUMBER}'-'${tagVersion}'")
                //updating "latest" is currently disabled due to MSO team now allowing service account to have overwrite permissions
                docker.image("$DOCKER_REPO").push("latest")
            }

    }
}

return this