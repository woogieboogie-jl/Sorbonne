# check if given String / Hex data is hexadecimal or not, else return False
def isHex(hex_string):
    try:
        test_byte = [int(halfbyte, 16) for halfbyte in hex_string] 
        for halfbyte in test_byte:
            if halfbyte not in range(0,16):
                return False
        return True
    except ValueError:
        return False

# checks if hex_String is either 1.length more than 2 / 2.each letter is hexadecimal.
def isOffset(hex_String):
    if len(hex_String) >= 3:
        return False if isHex(hex_String) is False else True
    else:
        return False 

# checks each line from hex_list if each line starts with an offset, if not it discards.
def filterData(hex_list):
    filtered_list = []
    for line in hex_list:
        if isOffset(line.split(" ")[0]):
            filtered_list.append(line)
    return filtered_list
    
# splits traces to multiple nested lists from a single hex_list
def splitTrace(hex_list):
    trace_list = []
    trace = []
    found_offset = False
        
    for line in hex_list:
        offset_line = line.split(" ")[0]
        if found_offset and int(offset_line,16) ==0:
            trace_list.append(trace)
            trace = []
        if int(offset_line,16) == 0:
            found_offset = True
        if found_offset:
            trace.append(line)
    trace_list.append(trace) 
    return trace_list

# compares offsets and ignores lines with unmatching offsets + integrates lines into a single list
def offsetSeq(trace_list):
    trace_list_hex = [] 
    for trace in trace_list:
        list_hex = []
        for line in trace:
            line_hex = list(filter(lambda x: x!="" ,line.split(" ")))
            if len(list_hex) == 0:
                for s in line_hex[1:]:
                    if isHex(s):
                        list_hex.append(s)
            else:
                if len(list_hex) == int(line_hex[0],16):
                    for s in line_hex[1:]:
                        if isHex(s):
                            list_hex.append(s)
        trace_list_hex.append(list_hex)
    return trace_list_hex


# returns list of decimal numbers from list of hexadecimal Strings
def ParsedtoDeclist(parsed_list):
    return [int(byte,16) for byte in parsed_list]

# number -> hex String
def formatHex(numb):
    return format(numb,"x")

# number -> dec String
def formatDec(numb):
    return str(numb)

# converts list of hexadecimal numbers to String (Hex)
def listToStringHex(list):
    list = [formatHex(numb) for numb in list]
    return " ".join(list)

# converts list of decimal numbers to String (Dec) 
def listToStringDec(list):
    list = [formatDec(numb) for numb in list]
    return " ".join(list)

