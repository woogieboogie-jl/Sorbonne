def getVersion(octets):
    return f"\tVersion: IPV{int(str(octets[0])[0],16)}"

def getIHL(octets):
    IHL = int(str(octets[0])[1],16)
    return f"\tIP Header Length: {IHL}", IHL 

def getTOS(octets):
    return f"\tType Of Service: {int(octets[1],16)}"

def getTL(octets):
    return f"\tTotal Length: {int(octets[2]+octets[3],16)} octets"

def getID(octets):
    return f"\tIdentifictaion: {int(octets[4] + octets[5], 16)}"

def getFlags(octets):
    F = "{0:04b}".format(int(octets[6][0], 16))
    R = F[0]
    DF = F[1]
    MF = F[2]
    s = f"\tFlags:\n\t\tThe first bit is reserved with a value of: {R}\n\t\tDon't Fragment: {True if int(DF) else False}\n\t\tMore Fragment: {True if int(MF) else False}"
    return s

def getFO(octets):
    F = "{0:04b}".format(int(octets[6][0], 16)) 
    FO = int(F[3] +  "{0:04b}".format(int(octets[6][1], 16)) + "{0:08b}".format(int(octets[7], 16)), 2)
    return f"\tFragment Offset: {FO*8} octets"

def getTTL(octets):
    return f"\tTime to Live: {int(octets[8], 16)}"

def getProto(octets):
    proto_dict = {1: 'ICMP', 2: 'IGMP', 6: 'TCP', 8: 'EGP', 9: 'IGP', 17: 'UDP', 36: 'XTP', 46: 'RSVP'}
    p = int(octets[9], 16)
    if p in proto_dict:
        if p == 17:
            is_UDP: True
        return f"\tProtocol: {proto_dict[p]}", proto_dict[p]
    else:
        return f"\tProtocol: Unknown ({p})", proto_dict[p]

    #possible:verifier si le checksum est correct
def getHCS(octets):
        HCS = int(octets[10] + octets[11], 16)
        HCS_bin = bin(HCS)
        return f"\tChecksum: {HCS} ({HCS_bin})"

def getSourceAddr(octets):
    SA = f"{int(octets[12],16)}.{int(octets[13],16)}.{int(octets[14],16)}.{int(octets[15],16)}"
    return f"\tSource Address: {SA}"

def getDestinAddr(octets):
    SD = f"{int(octets[16],16)}.{int(octets[17],16)}.{int(octets[18],16)}.{int(octets[19],16)}"
    return f"\tDestination Address: {SD}"

def getOpts(octets, IHL):
    opt_dict = { 0: "End of Options List (EOOL)", 1: "No Operation (NOP)", 7: "Record Route (RR)", 68: "Time Stamp (TS)", 131: "Loose Source Route (LSR)", 137: "Strict Source Route (SSR)"}
    opt_list = octets[20:]
    opts_out = ["\tOptions(Network)"]
    cnt_opt = 0
    if len(opt_list) == 0:
        opts_out.append("** POSSIBLE DATA CORRUPTION: Options impossible to locate while IHL indicates its existence!")
    else:
        while len(opt_list) > 0 and cnt_opt < (IHL*4-20):
            o = int(opt_list[0], 16)
            opt = opt_dict.get(o, "Unknown Option")
            opts_out.append(f"\t\t{o}: {opt}")
            if o == 0:
                break
            else:
                opt_len = int(opt_list[1], 16)
                opts_out.append(f"\t\t\tOption Length: {opt_len} octets.")
                opt_val_hex = ''.join(opt_list[2:opt_len])
                try:
                    opt_val_dec = int(opt_val_hex, 16)
                except ValueError:
                    opt_val_dec = "N/A"
                opts_out.append(f"\t\t\tOption Value: {opt_val_dec} ({opt_val_hex})")
                opt_list = opt_list[opt_len:]
                cnt_opt += opt_len
    opt_s = "\n".join(opts_out)
    return opt_s


def getTitleIP():
    return f"IP Protocol:------------------------------------------------\n"



def protoICMP(octets):
    segment = getOpts(octets)
    icmp_s = f"DETECTED ICMP DATA, ICMP NOT SUPPORTED:\n {''.join(segment)}"
    return 

def typeIPV4(octets):
    proto_s, proto = getProto(octets)
    IHL_s, IHL = getIHL(octets)

    elements = [
        getTitleIP(),
        getVersion(octets), 
        IHL_s,
        getTOS(octets), 
        getTL(octets), 
        getID(octets), 
        getFlags(octets), 
        getFO(octets), 
        proto_s,
        getHCS(octets),
        getSourceAddr(octets),
        getDestinAddr(octets)
    ]

    
    if int(str(octets[0])[1],16) == 5:
        elements.append("\tNo options avaliable")
    elif int(str(octets[0])[1],16) > 5:
        opts_s = getOpts(octets, IHL)
        elements.append(opts_s)
    else:
        elements.append("** POSSIBLE DATA CORRUPTION: IHL value given less than 5!")
    parsed_dict = {"segment": octets[IHL*4:], "protocol": proto, "analysis": "\n".join(elements)}

    return parsed_dict


def typeOthers(octets):
    parsed_dict = {"segment": [], "protocol": "N/A", "analysis": "(Network Layer) UNKNOWN TYPE ANALYSIS NOT SUPPORTED:------------------------------------------"}
    return parsed_dict









    # returns a dictionary with string of data regarding Network Layer + boolean that checks if UDP value is true or not
def parserNetwork(datalink_dict):
    type = datalink_dict["type"]
    packet = datalink_dict["packet"]

    if type == "0800":
        parsed_dict = typeIPV4(packet)
    else:
        parsed_dict = typeOthers(packet)
        pass
    
    return parsed_dict

    



