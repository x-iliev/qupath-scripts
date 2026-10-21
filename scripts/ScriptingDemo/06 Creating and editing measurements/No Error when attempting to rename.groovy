listOfStrings = ["This", "is", "a", "strange", "script", 1]

getCellObjects().eachWithIndex{cell, x ->
	position = x%6
	cell.setName(listOfStrings[position].toString())
}
//Double click on some of your cells to see the names.