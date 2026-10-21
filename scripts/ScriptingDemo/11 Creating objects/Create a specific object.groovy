// Size in pixels at the base resolution
// note that the actual size will be one pixel larger in each dimension
int size = 255

// Get center pixel
def viewer = getCurrentViewer()
int cx = viewer.getCenterPixelX()
int cy = viewer.getCenterPixelY()

// Create & add annotation
def roi = ROIs.createRectangleROI(cx-size/2, cy-size/2, size, size, getCurrentViewer().getImagePlane())
rgb = getColorRGB(150, 150, 150)
pathClass = getPathClass('New Class', rgb)

//Use the line below to change the color after running the script once. You cannot "construct over" an already created class to change the color.
//pathClass.setColor(rgb)

def annotation = PathObjects.createAnnotationObject(roi, pathClass2)
addObject(annotation)
fireHierarchyUpdate()
