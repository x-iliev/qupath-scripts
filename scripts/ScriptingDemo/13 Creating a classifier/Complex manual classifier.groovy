//WARNING - if you have changed the channel names, you will also need to adjust the measurement labels used in each of these scripts.
resetDetectionClassifications()
//Starting from everything
cells = getCellObjects()

//define the classes to use
tumorCl = getPathClass("Tumor")
macrophageCl = getPathClass("Macrophage")
otherPDCl = getPathClass("OtherPD")
macrophageCl.setColor( getColorRGB(165, 0, 255) )
otherPDCl.setColor( getColorRGB(255, 0, 1) )

//measurement labels to use
//keep this near the top so it is easy to adjust in case you want to make changes during the project.
//try to create new scripts and use versioning
//I do this by creating a new Project script, naming it along with a version, and then duplicating the current script into the new file

areaThreshold = 60
area = "Cell: Area"
CD68Threshold = 1.15
CD68 = "Cell: CD68 (Opal 620) mean"
CKThreshold = 2.7
CK = "Cell: CK (Opal 690) mean"
foxP3Threshold = 1.6
foxP3 = "Nucleus: FoxP3 (Opal 570) mean"
PDThreshold = 10
PDL1 = "Cytoplasm: PDL1 (Opal 520) mean"
PD1 = "Cytoplasm: PD1 (Opal 650) mean"



//I will start by dividing the cells into Tumor or not Tumor - which I will divide up by size
cells.each{
    if (measurement(it, CK) > CKThreshold) {
        it.setPathClass(tumorCl)
    }
}
//Keep track of which cells are and are not tumor cells
tumorCells = cells.findAll{it.getPathClass() == tumorCl}
notTumorCells = cells.findAll{it.getPathClass() != tumorCl}

//Use getDerivedPathClass() to create a class that has multiple parts.
//Generally this will be the previous parts (it.getPathClass()) plus some new part

tumorCells.each{
    if (measurement(it, area) > areaThreshold) {
        it.setPathClass( getDerivedPathClass(it.getPathClass(), "Large", getColorRGB(0,150,150)) )
    } else { it.setPathClass( getDerivedPathClass(it.getPathClass(), "Small",getColorRGB(0,190,150)) ) }
}

//On to the rest

notTumorCells.each{
//Assign macrophages
    if ( measurement(it, CD68) > CD68Threshold ){
        it.setPathClass(macrophageCl)
        //check macrophages for FoxP3
        if( measurement(it, foxP3) > foxP3Threshold ){
            it.setPathClass(  getDerivedPathClass(it.getPathClass(), "FoxP3", getColorRGB(150,75,0)) )
        }
    //Assign non-macrophage PD1 or PDL1 positive cells a class    
    } else if ( measurement(it, PDL1) > PDThreshold || measurement(it, PD1) > PDThreshold ){
        it.setPathClass(otherPDCl)
        //Check if each is FoxP3 positive as well
        if( measurement(it, foxP3) > foxP3Threshold ){
            it.setPathClass(  getDerivedPathClass(it.getPathClass(), "FoxP3", getColorRGB(255,150,0)) )
        }
    //Finally, make the cell negative if no other conditions were met    
    } else {
        it.setPathClass(getPathClass("Negative"))
        //But check if the otherwise negative cells are FoxP3 positive!
        if( measurement(it, foxP3) > foxP3Threshold ){
            it.setPathClass(  getDerivedPathClass(it.getPathClass(), "FoxP3", getColorRGB(0,250,0)) )
        }

    }
}

fireHierarchyUpdate()