getCellObjects().eachWithIndex{cell, index ->
	cell.getMeasurementList().putMeasurement("ID", index)
}
