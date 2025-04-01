def docbuild(String projectName,String imageTag, String dockerHubUser, String dockerfilepath, String sourcepath)
{
   echo "docker build -t ${dockerHubUser}/${projectName}:${imageTag} -f ${dockerfilepath} ${sourcepath}"  
}

