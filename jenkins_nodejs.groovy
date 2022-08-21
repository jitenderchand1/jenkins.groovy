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
            registryCredentials('06d425d3-4519-4458-8cd3-20d1769e6e4d')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
    
}
