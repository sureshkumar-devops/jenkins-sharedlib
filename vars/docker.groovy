def build(String projectName,String imageTag, String dockerHubUser, String dockerfilepath, String sourcepath)
{
   sh "docker build -t ${dockerHubUser}/${projectName}:${imageTag} -f ${dockerfilepath} ${sourcepath}"  
}

def push(String projectName,String imageTag, String dockerHubUser)
{
   withCredentials([usernamePassword(credentialsId: 'docker-credentials', 
                                      usernameVariable: 'dockerHubUser', 
                                      passwordVariable: 'dockerHubPass')]) 
   {
        sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
        sh "docker push ${dockerHubUser}/${projectName}:${imageTag}"
   }
}

  
