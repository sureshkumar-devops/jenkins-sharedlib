import groovy.json.JsonOutput
def call(){
  echo "Executing the Scaning method....."  
  def all = [ Jenkins.instance ]
all.addAll(Jenkins.instance.nodes.)
all.each {
    def c = it.toComputer()
    println "[$it.nodeName] - $it.numExecutors - $it.assignedLabels - $it.acceptingTasks - $it.nodeProperties - $c.offline"
}
println "----"
Jenkins.instance.queue.items.each {
    println "$it.id $it.blocked $it.buildable $it.stuck $it.assignedLabel $it.causes"
}
result = []

Jenkins.instance.queue.items.each {
    // Only consider BuildableItem
    // Other known objects are: 
   //    - BlockedItem, which lacks the runId
    if (it instanceof Queue.BuildableItem) {
        result.add([
            name: it.task.runId,
            id: it.id,
            why: it.why,
            startTime: it.inQueueSince,
        ])
    }
}

print(JsonOutput.toJson(result))
}
