def buildImage(APPNAME, DOCKER_REPO, dockerDir) {
    script {
        docker.build("$DOCKER_REPO/"+"$APPNAME", "$dockerDir")
    }

}

return this