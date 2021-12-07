def fileinput(path = "testinput.txt"):
    line_list = [line.upper().replace("\n", "") for line in open(path, 'r').readlines()]
    filtered_list = list(filter(lambda a: a!="", line_list))
    return filtered_list


def fileoutput(output, path = "testoutput.txt"):
    with open(path,'w') as file:
        file.write(output)