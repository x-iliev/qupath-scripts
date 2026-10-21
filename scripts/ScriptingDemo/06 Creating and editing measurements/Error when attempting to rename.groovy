//Rename your cells by cycling through this list of strings (and a number)
listOfStrings = ["This", "is", "a", "strange", "script", 1]

getCellObjects().eachWithIndex{cell, x ->
	position = x%6
	cell.setName(listOfStrings[position])
}
//ERROR!