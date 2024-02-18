def call(){
  echo "Executing the Scaning method....."  
  def all = [ Jenkins.instance ]
all.addAll(Jenkins.instance.nodes)
all.each {
    def c = it.toComputer()
    println "[$it.nodeName] - $it.numExecutors - $it.assignedLabels - $it.acceptingTasks - $it.nodeProperties - $c.offline"
}
println "----"
Jenkins.instance.queue.items.each {
    println "$it.id $it.blocked $it.buildable $it.stuck $it.assignedLabel $it.causes"
}
}
