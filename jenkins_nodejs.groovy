job("Any_name") {
    scm {
        git('git://github.com/jitenderchand1/docker-demo.git') { node ->
            node / gitConfigName("jitender")
            node / gitConfigEmail("jitender.chand1@tothenew.com")
        }
    }
    
    triggers {
        scm('* * * * *')
    }

    wrappers {
        nodejs('nodejs')
    }

    steps {
        shell("npm install")
        dockerBuildAndPublish {
            repositoryName('jchand3/jenkins-demo')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('jchand3')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
    
}
