def call(String projectName,String imageTag, String dockerHubUser, String dockerfilepath)
{
   echo "${dockerHubUser}/${projectName}:${imageTag} -f ${dockerfilepath}"
   //sh "docker build -t ${dockerHubUser}/${projectName}:${imageTag} -f ${dockerfilepath} ."  
}

