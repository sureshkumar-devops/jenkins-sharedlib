def call(String projectName,String imageTag, String dockerHubUser, String dockerfilepath, String sourcepath)
{
   echo "${dockerHubUser}/${projectName}:${imageTag} -f ${dockerfilepath}"
   //sh "docker build -t ${dockerHubUser}/${projectName}:${imageTag} -f ${dockerfilepath} ${sourcepath}"  
}

