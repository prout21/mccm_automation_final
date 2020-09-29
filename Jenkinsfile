#!groovy

def buildMode = "default"
def doBuild = false
def doTest = false

// Artifactory parameter
pkg_repos = "DXC-VF"

pipeline {
    agent {dockerfile true}
    
    environment {
        // Here define the environment variables
        MCCM_AUTOMATION_REPO_URL = "github.dxc.com/DXC-VF/mccm_automation.git"
        REPO = "mccm_automation"
    }// environment
    
    options {
        // set Build delete information for Jenkins
        buildDiscarder(logRotator(daysToKeepStr: '10', numToKeepStr: '20', artifactNumToKeepStr: '20'))
        timestamps()
        disableConcurrentBuilds()
    }//options
    
    stages {
        //Later use some code quality check tool
        stage('codequalitycheck') {
            steps {
                echo "Do Static Code Checking, Spell Checking, Syntax Checking, etc."
            }
        } // codequalitycheck
    
        stage('Build') {
            steps {
                    echo "Building...."
                    sh '''
                        cd ${WORKSPACE}
                        mvn compile
                    '''
            }
            
        } //stage (Build)
        stage('Test')
        {
            steps {
                    echo "Testing...."
                    sh '''
                        cd ${WORKSPACE}
                        # Not testing anything. will be added later
                    '''
            }
        } // (End of Test)
        
        stage('Store to Jenkins') {
            // Here we store the results of test.
            steps {
                    echo "Saving Test results."
                    // Will be added later.
            } // (End of Store to Jenkins)	
    } // Stages
    
    post {
        always {
            echo 'One way or another, I have finished'
            sh 'cd ${WORKSPACE}'
            deleteDir() /* clean up our workspace */
        }

        success {
            echo 'I succeeded!!!!!!!!!!!!!!'
            script{
                // if(nightlyBuild){
                //     echo "Nightly build succeded!!!!!!!!!!!!!"
                //     office365ConnectorSend message: "Log Url: (<${env.BUILD_URL}/console>)<br>Results Url: (<${env.BUILD_URL}/artifact/>)<br>Test Results Url: (<${env.BUILD_URL}/artifact/>)", status: "Nightly build Success", webhookUrl: 'https://outlook.office.com/webhook/d668f7b9-56dc-4dae-8078-e7f0d768b41f@93f33571-550f-43cf-b09f-cd331338d086/JenkinsCI/fbd826977b0e48f7a7c8e25e5c3e5af7/19011347-d504-4b65-9a0a-abcdef'                    
                // }
                // if(normalBuild) {
                //     emailext body: 'Log Url: (<${env.BUILD_URL}|Open>)', subject: 'Build Success', to: 'someone@dxc.com'
                // }
            }
        }

        unstable {
            echo 'I am unstable :/'
        }

        failure {
            echo 'I failed :('
            // script {
            //     if(nightlyBuild){
            //         echo "Nightly build succeded!!!!!!!!!!!!!"
            //         office365ConnectorSend message: "Log Url: (<${env.BUILD_URL}/console>)<br>Results Url: (<${env.BUILD_URL}/location>)", status: "Nightly build Failed", webhookUrl: 'https://outlook.office.com/webhook/d668f7b9-56dc-4dae-8078-e7f0d768b41f@93f33571-550f-43cf-b09f-cd331338d086/JenkinsCI/fbd826977b0e48f7a7c8e25e5c3e5af7/19011347-d504-4b65-9a0a-abcdef'
            //     }
            //     if(normalBuildBuild) {
            //         emailext body: '"Log Url: (<${env.BUILD_URL}|Open>)"', subject: 'Build Failed', to: 'someemail@dxc.com'
            //     }            
            // }
            
        }

        changed {
            echo 'Things were different before...'
        }
    } // Post
        
}// pipeline
