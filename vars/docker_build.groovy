def call(String projectName,String imageTag, String dockerHubUser, String dockerfilepath, String sourcepath)
{
   sh "docker build -t ${dockerHubUser}/${projectName}:${imageTag} -f ${dockerfilepath} ${sourcepath}"  
}

