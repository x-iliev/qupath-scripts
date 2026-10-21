import static qupath.lib.gui.scripting.QPEx.*

def project = getProject()

for (entry in project.getImageList()) {

    def imageData = entry.readImageData()
    def hierarchy = imageData.getHierarchy()
    def annotation = hierarchy.getAnnotationObjects()
    print annotation.toArray()
}