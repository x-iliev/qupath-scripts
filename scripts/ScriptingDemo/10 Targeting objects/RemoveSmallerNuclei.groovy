notLargeNuclei = getCellObjects().findAll{ !(measurement(it, "Nucleus: Area") > 60) }
removeObjects(notLargeNuclei, true)
