//Recolor the cells in an image while cycling through RGB colorspace

cells = getCellObjects()
cells.eachWithIndex{cell, i->
        //The mod is divide by and keep the remainder - this keeps j within 0 to 255
        j = i.mod(255)
        //modulus used to keep the RGB values in the 0-255 range
        cell.setColorRGB(getColorRGB(255-j,120-j, j))
}
fireHierarchyUpdate()
print "done"