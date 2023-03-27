def name = "jenkins-test"
def imagesName = "g1cloud/${name}"
def url = "192.168.21.125:20015"
def appName = "jenkins1-test"
def skywalkingUrl="192.168.21.125:11800"
def pom
def img_name
def imagesVersion
def dockerName
def gitBranch

class MyChange {
   String author;
   String msg;
}

pipeline {

   agent any

   options {
        skipDefaultCheckout(true)
    }

    stages {

        stage('Clone') {
            steps {
                checkout scm

                script {
                    pom = readMavenPom file: 'pom.xml'
                    img_name = "${pom.groupId}-${pom.artifactId}"
                    imagesVersion = "${pom.version}"
                    dockerName= "${url}/${imagesName}:${imagesVersion}"
                    echo "group: ${pom.groupId}, artifactId: ${pom.artifactId}, version: ${pom.version}"

                    def change = getChanges()
                    if(change!=null){
                        echo change.author + ' ' + change.msg
                    }
                }
            }
        }

        stage('编译') {
            steps {
                sh "mvn -U clean package"
            }
        }

        stage('发布') {
            steps {
                
            }
        }

        stage('上传镜像') {
            steps {
                sh "java -jar app.jar"
            }
        }

    }
}

@NonCPS
def getChanges()
{
    def changeLogSets = currentBuild.changeSets
    for (int i = 0; i < changeLogSets.size(); i++)
    {
        def entries = changeLogSets[0].items
        for (int j = 0; j < entries.length; j++)
        {
            def entry = entries[0]
            def change = new MyChange()
            change.author = entry.author
            change.msg = entry.msg
            return change
        }
    }

}

def getGitBranchName() {
    return scm.branches[0].name
}
