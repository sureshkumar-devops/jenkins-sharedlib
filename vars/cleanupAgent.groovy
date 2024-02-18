import hudson.model.*;
import hudson.util.*;
import jenkins.model.*;
import hudson.FilePath.FileCallable;
import hudson.slaves.OfflineCause;
import hudson.node_monitors.*;
def performCleanup(def node, def items) 
{
  for (item in items) {
    jobName = item.getFullDisplayName()
    println("Cleaning " + jobName)
    if(item instanceof com.cloudbees.hudson.plugins.folder.AbstractFolder) {
        performCleanup(node, item.items)
        continue
    }
    println("Wiping out workspaces of job " + jobName)
    workspacePath = node.getWorkspaceFor(item)
    if (workspacePath == null) {
      println("Could not get workspace path")
      continue
    }
    println("Workspace = " + workspacePath)
    pathAsString = workspacePath.getRemote()
    if (workspacePath.exists()) {
      workspacePath.deleteRecursive()
      println("Deleted from location " + pathAsString)
    } else {
      println("Nothing to delete at " + pathAsString)
    }
  }  
}