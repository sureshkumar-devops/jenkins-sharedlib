 def cleanoldbuilds() {
  properties([
    buildDiscarder(logRotator(numToKeepStr: '2'))
  ])
}