import groovy.json.JsonOutput

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