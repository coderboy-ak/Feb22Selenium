pipeline{

    agent any

        stages{

            stage("Build"){
                steps{
                    echo("Build")
                }
            }

             stage("Run UTs"){
                steps{
                    echo("Run UTs")
                }
            }

             stage("Deploy  to QA env"){
                steps{
                    echo("deploy to qa environment")
                }
            }

             stage("Run my Automation Test"){
                steps{
                    echo("running automation test case")
                }
            }

             stage("Deploy to stage"){
                steps{
                    echo("deploy to stage")
                }
            }

             stage("sanity test"){
                steps{
                    echo("sanity test on stage env")
                }
            }

             stage("Deploy to PROD"){
                steps{
                    echo("deploy to prod environment")
                }
            }

        }
}