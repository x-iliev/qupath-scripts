//Any image that has objects!
all = getAllObjects().findAll{it.isAnnotation() || it.isDetection()}
removeObjects(all, true)
print "Removing objects!"
Thread.sleep(2000)
print "putting objects back!"
addObjects(all)
fireHierarchyUpdate()