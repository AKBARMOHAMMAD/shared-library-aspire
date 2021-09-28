def buildArtifact(pomDir, resolverreleaseRepo, resolversnapshotRepo, ArtifactCredentialsID, mavenGoal) {
    script {
        rtServer(
                id: "artifactory",
                url: "http://3.237.61.141:8081/artifactory",
                credentialsId: ArtifactCredentialsID
        )
        rtMavenResolver(
                id: "resolver",
                serverId: "artifactory",
                releaseRepo: "$resolverreleaseRepo",
                snapshotRepo: "$resolversnapshotRepo"
        )
    }

    script {
        //jdk = tool name: 'java8'
        //env.JAVA_HOME = "${jdk}"
        //mvnHome = tool 'maven'
        rtMavenRun(
                //tool: 'maven',
                pom: "$pomDir"+"pom.xml",
                goals: "$mavenGoal",
                resolverId: "resolver")
            }



}

return this