//Print the areas of annotations in the image in square millimeters
import qupath.lib.gui.measure.ObservableMeasurementTableData
def ob = new ObservableMeasurementTableData();
ob.setImageData( getCurrentImageData(),  getAnnotationObjects() );

//Multiply by 1000000 for the unit conversion from square microns to square millimeters - easier to understand!
print "Areas of each annotation in mm^2"
getAnnotationObjects().each { print ob.getNumericValue(it, "Area µm^2")/1000000 }
