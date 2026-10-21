//You will need some objects, maybe from the ADD OBJECTS FIRST Script!

getDetectionObjects().each{cell->
	//Check each cell to see if it is in a Stroma annotation
	if( cell.getParent().getPathClass() == getPathClass("Stroma") ){
		tissueSlice = cell.getParent().getParent().getName() as double
		cell.getMeasurementList().putMeasurement("Tissue slice", tissueSlice)
}else{
	//If the cell is outside the tumor annotation, we need to check ONE parent level
	tissueSlice = cell.getParent().getName() as double
	cell.getMeasurementList().putMeasurement("Tissue slice", tissueSlice)
}
}