//Removing objects as a group. If you have Log script time checked, you should see a dramatic improvement.

listOfCells = []
resolveHierarchy()
getCellObjects().each{
	if(it.getParent().getPathClass() == getPathClass("Stroma")){
		listOfCells << it
	}else{/*something could be put here*/}
}
removeObjects(listOfCells, true)
