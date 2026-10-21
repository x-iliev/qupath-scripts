//Adds a small amount of objects to CMU-1.svs for use in the Loops scripts
//In this demo I switched to Stroma since that color contrasts slightly better with the H&E staining and the default red objects.
clearAllObjects()
objects = buildFilePath(PROJECT_BASE_DIR, "objectsForScripts", "Loops1.geojson")
importObjectsFromFile(objects)
resolveHierarchy()
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
