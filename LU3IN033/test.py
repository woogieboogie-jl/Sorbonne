from iohandler import fileinput, fileoutput
from hexdecoder import ParsedtoDeclist, parser, listToStringDec


file = fileinput()
parsed = parser(file)
dec_list = ParsedtoDeclist(parsed)
dec_list_string = listToStringDec(dec_list)
fileoutput(dec_list_string)


