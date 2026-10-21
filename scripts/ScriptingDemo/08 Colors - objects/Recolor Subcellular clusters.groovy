//Recolor only the subcellular CLUSTERS
//Notice that the color changes in the annotation menu

getDerivedPathClass(getPathClass('Subcellular cluster'), 'Eosin object').setColor(qupath.lib.common.ColorTools.makeRGB(50, 20, 160))
fireHierarchyUpdate()