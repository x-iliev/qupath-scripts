
getProject().getImageList().each{ entry ->
    if(entry.getImageName() != getProjectEntry().getImageName() && entry.getImageName().contains("CMU")){
        //Standard way of accessing the annotations in the current image
        toTransfer = getAnnotationObjects()
        //We also need to get access to the objects in the destination image, though!
        imageData = entry.readImageData()
        otherHierarchy = imageData.getHierarchy()
        otherHierarchy.addPathObjects(toTransfer)
        entry.saveImageData(imageData)
        print "Objects trasnferred to " + entry.getImageName() + ": "+toTransfer.size()
    } else {print "Not trasferring objects into " + entry.getImageName()}
}