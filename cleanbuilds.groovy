
def callBuildDiscarder(){
  echo "Discard Old Builds..."
  options {
  buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '2', daysToKeepStr: '', numToKeepStr: '2')
}
