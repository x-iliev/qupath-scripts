//Create some sort of non-rectangular annotation first!
tissue = getAnnotationObjects()[0]
roi = tissue.getROI()

def plane = getCurrentViewer().getImagePlane()
boundingROI = ROIs.createRectangleROI(
            	roi.getBoundsX(), //top left corner
            	roi.getBoundsY(), //top left corner
            	roi.getBoundsWidth(), //width
            	roi.getBoundsHeight(), //height
            	plane)
boundingAnnotation = PathObjects.createAnnotationObject(boundingROI)
addObject(boundingAnnotation)
