def cleanoldbuilds1() {
    properties([
buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '2', daysToKeepStr: '', numToKeepStr: '2')
  ])
}

 def cleanoldbuilds() {
  properties([
    buildDiscarder(logRotator(numToKeepStr: '2'))
  ])
}