clearDetections()
def cellCount = 0
functionCellCount = []
cellCountSum = 0

getAnnotationObjects().eachWithIndex{annotation,x->
    if (x == 0 ){ functionCellCount << runCellDetection(annotation, getPathClass("Tumor")) }
    if (x == 1 ){ functionCellCount << runCellDetection(annotation, getPathClass("Stroma")) }
}

print "Cell Count outside function: " + cellCount
print "Cell Count returned from Function: " + functionCellCount
print "Cell Count Sum: " + cellCountSum
resetSelection()

//A function that accepts an annotation and a class
def runCellDetection(annotation, pathClass){
    resetSelection()
    //Make sure only the passed annotation is selected
    getCurrentHierarchy().getSelectionModel().setSelectedObject(annotation, true);
    //And run cell detection
    runPlugin('qupath.imagej.detect.cells.WatershedCellDetection', '{"detectionImageBrightfield": "Hematoxylin OD",  "requestedPixelSizeMicrons": 0.5,  "backgroundRadiusMicrons": 8.0,  "medianRadiusMicrons": 0.0,  "sigmaMicrons": 1.5,  "minAreaMicrons": 10.0,  "maxAreaMicrons": 400.0,  "threshold": 0.1,  "maxBackground": 2.0,  "watershedPostProcess": true,  "cellExpansionMicrons": 5.0,  "includeNuclei": true,  "smoothBoundaries": true,  "makeMeasurements": true}');
    //Set the annotation's class to the class that was passed to the function this time
    annotation.setPathClass(pathClass)
    //find the number of cells within the current annotation
    cellCount = annotation.getChildObjects().size()
    //Add the count to the current sum and then print and return that count
    cellCountSum = cellCountSum+cellCount
    print "Cell Count inside function: " + cellCount
    
    return cellCount
}
