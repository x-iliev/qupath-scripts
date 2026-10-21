
roundishMidSizedNuclei = getCellObjects().findAll{ !( (measurement(it, "Nucleus: Area") > 80) ||  (measurement(it, "Nucleus: Area")  < 20) ) && measurement(it, "Nucleus: Eccentricity") <0.5 }
roundishMidSizedNuclei.each{
	it.setPathClass(getPathClass("Normal"))
}
getPathClass("Normal").setColor(getColorRGB(255,255,255))
fireHierarchyUpdate()
