//Comment out this bit if you want to set up your own objects - otherwise it will set the stage for the script
clearAllObjects()
objects = buildFilePath(PROJECT_BASE_DIR, "objectsForScripts", "selectingThings.geojson")
importObjectsFromFile(objects)
resolveHierarchy()
///////////////////////////////////////////////////////////////////////////////////////////////////////////////

tumorAnnotations = getAnnotationObjects().findAll{it.getPathClass() == getPathClass("Tumor")}
tumorAnnotations.each{anno->
tumorCells = getCurrentHierarchy().getObjectsForROI(qupath.lib.objects.PathDetectionObject, anno.getROI())
}
tumorCells.each{cell->
getCurrentHierarchy().getSelectionModel().setSelectedObject(cell, true);
}
