def fileinput(path = "testinput.txt"):
    file = open(path, 'r').read()
    return file.lower()


def fileoutput(output, path = "testoutput.txt"):
    file = open(path, 'w')
    file.write(output)
    file.close()
    