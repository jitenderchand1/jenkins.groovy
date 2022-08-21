job("Any name") {
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

    step {
        shell("npm install")
    }
    
}