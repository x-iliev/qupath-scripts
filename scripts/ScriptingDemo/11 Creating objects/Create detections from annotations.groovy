rois = getAnnotationObjects().collect{it.getROI()}
newAnnotations = []
rois.each{
	newAnnotations << PathObjects.createDetectionObject(it, getPathClass("duplicateAnnotation"))
}
addObjects(newAnnotations)
