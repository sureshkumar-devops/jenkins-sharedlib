
def callBuildDiscarder(){
def daysToKeep = ''
def numToKeep = 2
def artifactDaysToKeepStr = ''
def artifactNumToKeepStr = 2

Jenkins.instance.queue.items.each { item ->
  println("=====================")
  println("JOB: " + item.name)
  println("Job type: " + item.getClass())

  if(item.buildDiscarder == null) {
    println("No BuildDiscarder")
    println("Set BuildDiscarder to LogRotator")
  } else {
    println("BuildDiscarder: " + item.buildDiscarder.getClass())
    println("Found setting: " + "days to keep=" + item.buildDiscarder.daysToKeepStr + "; num to keep=" + item.buildDiscarder.numToKeepStr + "; artifact day to keep=" + item.buildDiscarder.artifactDaysToKeepStr + "; artifact num to keep=" + item.buildDiscarder.artifactNumToKeepStr)
    println("Set new setting")
  }

  item.buildDiscarder = new hudson.tasks.LogRotator(daysToKeep,numToKeep, artifactDaysToKeep, artifactNumToKeep)
  item.save()
  println("")

}
}