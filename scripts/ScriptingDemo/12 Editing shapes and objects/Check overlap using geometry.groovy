//Start here with our baseline "Tissue" class object, all other annotations will be compared to it.
tissueAnnotation = getAnnotationObjects().find{it.getPathClass() == getPathClass("Tissue")}
tissueGeom = tissueAnnotation.getROI().getGeometry()

//Cycle through ALL OTHER annotations to check for intersection
//We do want a list to put all of these into so we are not removing them one at a time (slow!)
toRemove = []

getAnnotationObjects().findAll{it.getPathClass() != getPathClass("Tissue")}.each{anno->
	currentGeom = anno.getROI().getGeometry()
	//Note the ! which means we are looking for NOT intersects
	if ( !currentGeom.intersects(tissueGeom) ){
    	//What we need to remove is the annotation, NOT the geometry, which is only the shape of the object
    	toRemove << anno
	}
}
//remove the objects that were collected
removeObjects(toRemove,true)
fireHierarchyUpdate()
