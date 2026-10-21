//Load the LuCa object data before running!
resolveHierarchy() //let's make sure all of the cells are child objects of their annotations!
tumorAnnos = getAnnotationObjects().findAll{it.getPathClass() == getPathClass("Tumor")}
tumorCells = getCellObjects().findAll{it.getParent().getPathClass() == getPathClass("Tumor")}

//Remove the tumor annotations and their cells
removeObjects(tumorAnnos,false)
removeObjects(tumorCells,false)
//Analyze->Spatial analysis->Detect centroid distances 2D

detectionCentroidDistances(true)
//Add everything back, and make sure the hierarchy is resolved!
addObjects(tumorAnnos)
addObjects(tumorCells)
resolveHierarchy()
fireHierarchyUpdate()