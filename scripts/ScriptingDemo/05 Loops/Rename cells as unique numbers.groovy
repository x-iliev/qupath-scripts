//Index starts with 0 so this will cycle through each cell and give it a number, after converting that number into a String

getCellObjects().eachWithIndex{cell, index ->
	cell.setName(index.toString())
}
