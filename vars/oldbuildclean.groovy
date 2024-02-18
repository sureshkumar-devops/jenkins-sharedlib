def cleanoldbuilds() {
    properties([
buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '2', daysToKeepStr: '', numToKeepStr: '2')
  ])
}

