resolveHierarchy()
topLevel = getCurrentHierarchy().getRootObject().getChildObjects()
print "Top Level 1: "+topLevel

topLevel2 = getAllObjects().findAll{it.getLevel() == 1}
print "Top Level 2: "+topLevel2

oneLevelDown = getAllObjects().findAll{it.getLevel() == 2}
print "Second Level: "+oneLevelDown