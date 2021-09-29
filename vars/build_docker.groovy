def buildImage(APPNAME, DOCKER_REPO, dockerDir) {
    script {
        docker.build("$DOCKER_REPO", "$dockerDir")
    }

}

return this