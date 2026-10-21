import static qupath.lib.gui.scripting.QPEx.*

//I do not recommend running this except on an EXTREMELY small Stroma area
resolveHierarchy()
getCellObjects().each{
	if(it.getParent().getPathClass() == getPathClass("Stroma")){
		removeObject(it, true)
	}
}

