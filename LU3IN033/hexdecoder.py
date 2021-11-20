def parser(dump_string):
    parsed = dump_string.split(" ")
    return parsed

def ParsedtoDeclist(parsed_list):
    return [int(byte,16) for byte in parsed_list]

def formatHex(numb):
    return format(numb,"x")

def formatDec(numb):
    return str(numb)

def listToStringHex(list):
    list = [formatHex(numb) for numb in list]
    return " ".join(list)

def listToStringDec(list):
    list = [formatDec(numb) for numb in list]
    return " ".join(list)

