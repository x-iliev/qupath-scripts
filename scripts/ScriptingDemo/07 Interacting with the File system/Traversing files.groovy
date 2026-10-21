directory = buildFilePath(PROJECT_BASE_DIR, "filedemo")
folder = new File(directory)
files =[]
folder.traverse(maxDepth:0){files.add(it)}
files.each{print it}