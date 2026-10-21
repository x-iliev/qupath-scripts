CKcells = getCellObjects().findAll{ measurement(it, "Cell: CK (Opal 690) mean") > 3}
CKcells.each{ 
    if(measurement(it, "Cell: Area")>60) {
        it.setPathClass(getPathClass("CK Large"))
    } else { it.setPathClass(getPathClass("CK Small")) }
}

fireHierarchyUpdate()
