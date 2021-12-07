dhcp_op_dict = { 1: "DNS Request Client", 2: "DHCP Reply Server"}
dhcp_htype_dict = {
    1: "Ethernet",
    6: "IEEE 802 Networks",
    7: "ARCNET",
    12: "LocalTalk",
    14: "LocalNet",
    15: "SMDS",
    16: "Frame Relay",
    17: "HDLC",
    18: "Fibre Channel",
    19: "Asynchronus Transfer Node(ATM)",
    20: "Serial Line",
}
dhcp_opt_dict = { 255: "End of Options List (EOOL)", 53: "DHCP Message"}
dhcp_msg_dict = {
    1:     "DHCPDISCOVER",
    2:     "DHCPOFFER",
    3:     "DHCPREQUEST",
    4:     "DHCPDECLINE",
    5:     "DHCPACK",
    6:     "DHCPNAK",
    7:     "DHCPRELEASE",
    }

def getOPCode(octets):
    op = int(octets[0],16)
    return f"Operation Code: {op}({dhcp_op_dict.get(op, 'Unknown')})", op

def getHtype(octets):
    htype = int(octets[1], 16)
    return f"Hardware Address Type: {htype}({dhcp_htype_dict.get(htype, 'Unknown')})", htype

def getHLength(octets):
    hlen = int(octets[2],16)*8
    return f"Length: {hlen} octets"

def getHops(octets):
    return f"Hops: {int(octets[3],16)}"

def getCIID(octets):
    return f"Client ID: {int(octets[4]+octets[5]+octets[6]+octets[7],16)}"

def getSTime(octets):
    ST = int(octets[8]+octets[9],16)
    return f"Start Time: {ST}"

def getFlags(octets):
    flags = octets[10]+octets[11]
    return f"Flags: {flags}"

def getCIAddr(octets):
    ciaddr = '.'.join([str(int(octet, 16)) for octet in octets[12:16]])
    return f"Client Address: {ciaddr}"

def getYIAddr(octets):
    yiaddr = '.'.join([str(int(octet, 16)) for octet in octets[16:20]])
    return f"Offered Address: {yiaddr}"

def getSIAddr(octets):
    siaddr = '.'.join([str(int(octet, 16)) for octet in octets[20:24]])
    return f"Server Address: {siaddr}"

def getGIAddr(octets):
    giaddr = '.'.join([str(int(octet, 16)) for octet in octets[24:28]])
    return f"Relay Agent Address: {giaddr}"

def getCHAddr(octets, htype):
    if htype == 1:
        chaddr = '.'.join(octets[28:34])
        return f"Client Hardware Address: {chaddr}({dhcp_htype_dict.get(htype)})"
    else:
        chaddr = '-'.join(octets[28:44])
        return f"Client Hardware Address: {chaddr}({dhcp_htype_dict.get(htype)})"

def getOptSName(octets):
    sname_data = ''.join(octets[44:108])
    if int(sname_data,16) == 0:
        return f"Server Host Name: None (Not Given)"
    else:
        sname = (sname_data).decode("hex")
        return f"Server Host Name: {sname}"

def getOptFName(octets):
    bname_data = ''.join(octets[108:236])
    if int(bname_data,16) == 0:
        return f"Boot File Name: None (Not Given)"
    else:
        bname = (bname_data).decode("hex")
        return f"Boot File Name: {bname}"

def getOptions(octets):
    opts_out = ["Options"]
    if octets[236:240] == ["63", "82", "53", "63"]:
        opt_list = octets[240:]
    else:
        opt_list = octets[236:]
    if len(opt_list) == 0:
        opts_out.append("No options avaliable")
    else:
        while len(opt_list) > 0:
            o = int(opt_list[0], 16)
            opt = dhcp_opt_dict.get(o, "Unknown Option")
            opts_out.append(f"\t{o}: {opt}")
            if o == 255:
                break
            else:
                print(opt_list[0])
                print(opt_list[1])
                print(opt_list[2])
                opt_len = int(opt_list[1], 16)
                opts_out.append(f"\t\tOption Length: {opt_len} bytes")
                opt_val_hex = ''.join(opt_list[2:2+opt_len])
                opt_val_dec = int(opt_val_hex, 16)
                if o==53:
                    opts_out.append(f"\t\tDHCP Message: {dhcp_msg_dict[opt_val_dec]} ({opt_val_hex})")
                else:    
                    opts_out.append(f"\t\tOption Value: {opt_val_dec} ({opt_val_hex})")
                opt_list = opt_list[2+opt_len:]
    return "\n".join(opts_out), opt_list




def DHCP(octets):
    OP_s, OP = getOPCode(octets)
    htype_s, htype = getHtype(octets)
    opt_s, opt_list = getOptions(octets)
    elements = [
        OP_s,
        htype_s,
        getHLength(octets),
        getHops(octets),
        getCIID(octets),
        getSTime(octets),
        getFlags(octets),
        getCIAddr(octets),
        getYIAddr(octets),
        getSIAddr(octets),
        getGIAddr(octets),
        getCHAddr(octets, htype),
        getOptSName(octets),
        getOptFName(octets),
        opt_s,
    ]
    parsed_dict = {"analysis": "\n".join(elements)}
    seg_left = opt_list
    if len(seg_left) != 0:
        parsed_dict["left"] = seg_left
        parsed_dict["analysis"] + f"\n\n ! {len(seg_left)} BYTES OF UNPACKED DATA REMAINING"
    
    return parsed_dict

def DNS(octets):
    print("DNS WIP")
    pass



def parserApplication(transport_dict):
    proto = transport_dict["utility"]
    octets = transport_dict["datagram"]
    if proto == "DNS":
        application_dict = DNS(octets)
    elif proto == "DHCP":
        application_dict = DHCP(octets)
    return application_dict


