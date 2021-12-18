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
dhcp_opt_dict = {1: "Subnet Mask", 2: "Time Offset", 3: "Router", 4: "Time Server",\
                 5: "Name Server", 6: "Domain Server", 7: "Log Server", \
                 8: "Quotes Server", 54: "DHCP Server Id", 51: "Adress Time", \
                 43: "Vendor Specific", 12:"Hostname",  9: "LPR Server", \
                 10: "Impress Server", 11: "RLP Server", 13: "Boot File Size", \
                 14: "Merit Dump File", 15: "Domain Name", 16: "Swap Server", \
                 17: "Root Path", 18: "Extension File", 19: "Forward On/Off", \
                 24: "MTU Timeout", 25: "MTU Plateau", 26: "MTU Interface", \
                 27: "MTU Subnet", 28: "Broadcast Adress", 29: "Mask Discovery", \
                 30: "Mask Supplier", 31: "Router Discovery", 32: "Router Request", \
                 33: "Static Route", 34: "Trailers", 35: "ARP Timeout", \
                 36: "Ethernet", 37: "Default TCP TTL", 38: "Keepalive Time", \
                 255: "End of Options List (EOOL)", 53: "DHCP Message Type", \
                 55: "Parameter List", 56: "DHCP Message", 57: "DHCP Max Msg Size", \
                 39: "Keepalive Data", 40: "NIS Domain", 41: "NIS Servers", \
                 42: "NTP Servers", 43: "Vendor Specific", 44: "NETBIOS Name Srv", \
                 45: "NETBIOS Dist Srv", 46: "NETBIOS Node Type", 47: "NETBIOS Scope", \
                 48: "X Window Font", 49: "X Window Font", 50: "Address Request", \
                 52: "Overload", 58: "Renewal Time", 59: "Rebinding Time", \
                 60: "Class Id", 61: "Client Id", 62: "NetWare/IP Domain", \
                 63: "NetWare/IP Option", 64: "NIS-Domain-Name", 65: "NIS-Domain-Name", \
                 66: "Server-Name", 67: "Bootfile-Name", 68: "Home-Agent-Addrs", \
                 69: "SMTP-Server", 70: "POP3-Server", 71: "NNTP-Servet", \
                 72: "WWW-Server", 73: "Finger-Server", 74: "IRC-Server", \
                 75: "StreetTalk-Server", 76: "STDA-Server", 77: "User-Class", \
                 78: "Directory Agent", 79: "Service Scope", 80: "Rapid Commit", \
                 81: "Client FQDN", 82: "Relay Agent Information", 83: "iSNS", \
                 84: "REMOVED/Unassigned", 85: "NDS Servers", 86: "NDS Tree Name", \
                 20: "SrcRte On/Off", 21: "Policy Filter", 22: "Max DG Assembly", \
                 23: "Default IP TTL", 87: "NDS Context", 88: "BCMCS Controller Domain Name list", \
                 89: "BCMCS Controller IPv4 address option", 90: "Authentication", \
                 91: "client-last-transaction-time option", 92: "associated-ip option", \
                 93: "Client System", 94: "Client NDI", 95: "LDAP", 96: "REMOVED/Unassigned", \
                 97: "UUID/GUID", 98: "User-Auth", 99: "GEOCONF_CIVIC", 100: "PCode"}
    
dhcp_msg_dict = {
    1:     "DHCPDISCOVER",
    2:     "DHCPOFFER",
    3:     "DHCPREQUEST",
    4:     "DHCPDECLINE",
    5:     "DHCPACK",
    6:     "DHCPNAK",
    7:     "DHCPRELEASE",
    8:     "DHCPINFORM", 
    }

def getOPCode(octets):
    op = int(octets[0],16)
    return f"\tOperation Code: {op}({dhcp_op_dict.get(op, 'Unknown')})", op

def getHtype(octets):
    htype = int(octets[1], 16)
    return f"\tHardware Address Type: {htype}({dhcp_htype_dict.get(htype, 'Unknown')})", htype

def getHLength(octets):
    hlen = int(octets[2],16)*8
    return f"\tLength: {hlen} octets"

def getHops(octets):
    return f"\tHops: {int(octets[3],16)}"

def getCIID(octets):
    return f"\tClient ID: {int(octets[4]+octets[5]+octets[6]+octets[7],16)}"

def getSTime(octets):
    ST = int(octets[8]+octets[9],16)
    return f"\tStart Time: {ST}"

def getFlags(octets):
    flags = octets[10]+octets[11]
    return f"\tFlags: {flags}"

def getCIAddr(octets):
    ciaddr = '.'.join([str(int(octet, 16)) for octet in octets[12:16]])
    return f"\tClient Address: {ciaddr}"

def getYIAddr(octets):
    yiaddr = '.'.join([str(int(octet, 16)) for octet in octets[16:20]])
    return f"\tOffered Address: {yiaddr}"

def getSIAddr(octets):
    siaddr = '.'.join([str(int(octet, 16)) for octet in octets[20:24]])
    return f"\tServer Address: {siaddr}"

def getGIAddr(octets):
    giaddr = '.'.join([str(int(octet, 16)) for octet in octets[24:28]])
    return f"\tRelay Agent Address: {giaddr}"

def getCHAddr(octets, htype):
    if htype == 1:
        chaddr = '.'.join(octets[28:34])
        return f"\tClient Hardware Address: {chaddr}({dhcp_htype_dict.get(htype)})"
    else:
        chaddr = '-'.join(octets[28:44])
        return f"\tClient Hardware Address: {chaddr}({dhcp_htype_dict.get(htype)})"

def getOptSName(octets):
    sname_data = ''.join(octets[44:108])
    if int(sname_data,16) == 0:
        return f"\tServer Host Name: None (Not Given)"
    else:
        sname_cut = sname_data[:sname_data.index("FF")]
        sname = ''.join([chr(int(''.join(c), 16)) for c in zip(sname_cut[0::2],sname_cut[1::2])])
        sname = sname[1:]
        return f"\tServer Host Name: {sname}"

def getOptFName(octets):
    bname_data = ''.join(octets[108:236])
    if int(bname_data,16) == 0:
        return f"\tBoot File Name: None (Not Given)"
    else:
        bname_cut = bname_data[:bname_data.index("FF")]
        bname = ''.join([chr(int(''.join(c), 16)) for c in zip(bname_cut[0::2],bname_cut[1::2])])
        bname = bname[1:]
        return f"\tBoot File Name: {bname}"

def getOptions(octets):
    opts_out = ["\tOptions(Application)"]
    if octets[236:240] == ["63", "82", "53", "63"]:
        opt_list = octets[240:]
    else:
        opt_list = octets[236:]
    if len(opt_list) == 0:
        opts_out.append("No Options Avaliable")
    else:
        while len(opt_list) > 0:
            o = int(opt_list[0], 16)
            opt = dhcp_opt_dict.get(o, "Unknown Option")
            opts_out.append(f"\t\t{o}: {opt}")
            if o == 255:
                break
            else:
                opt_len = int(opt_list[1], 16)
                opts_out.append(f"\t\t\tOption Length: {opt_len} bytes")
                opt_val_hex = ''.join(opt_list[2:2+opt_len])
                opt_val_dec = int(opt_val_hex, 16)
                if o==53:
                    opts_out.append(f"\t\t\tDHCP Message: {dhcp_msg_dict[opt_val_dec]} ({opt_val_hex})")
                else:    
                    opts_out.append(f"\t\t\tOption Value: {opt_val_dec} ({opt_val_hex})")
                opt_list = opt_list[2+opt_len:]
    return "\n".join(opts_out), opt_list


def getTitleDHCP():
    return f"DHCP Protocol:-----------------------------------------------\n"


def DHCP(octets):
    OP_s, OP = getOPCode(octets)
    htype_s, htype = getHtype(octets)
    opt_s, opt_list = getOptions(octets)
    elements = [
        getTitleDHCP(),
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








# ---------------------------------------------------------------------------------------------------------------------------------------

#sources to find format and values:
    #http://www-inf.int-evry.fr/~hennequi/CoursDNS/NOTES-COURS_eng/msg.html
    #https://www.iana.org/assignments/dns-parameters/dns-parameters.xhtml#dns-parameters-2
    #https://spathis.medium.com/comprendre-internet-et-son-fonctionnement-9b2f63a07430
    #https://en.wikipedia.org/wiki/Domain_Name_System#DNS_message_format

#only use if DNS = True
type_rr_dict = {1: 'A', 28: 'AAAA', 5: 'CNAME', 2: 'NS', 15: 'MX'}


def Identification(octets):
    #Identification
    I = hex(int(octets[0]+octets[1],16))
    return f"\tTransaction ID: {I}"
    
def Control(octets):
    opcode_dic = {0: 'Query', 1: 'Inverse Query', 2:'Status', 3:'Unassigned', 4:'Notify', 5:'Update', 6:'DNS Stateful Operations'}
    rcode_dic = {0:'NOERROR', 1:'FORMERR', 2:'SERVFAIL', 3:'NXDOMAIN', 4:'NOTIMP', 5:'REFUSED', 6:'YXDOMAIN', 7:'XRRSET', 8:'NOTAUTH', 9:'NOTZONE' }
    #Control
    C = format(int(octets[2]+octets[3],16), '016b')
    QR = "Request" if C[0] == "0" else "Response"                                               # Query
    opcode = opcode_dic.get(int(C[1:5],2), "Unknown")                                           # Opcode
    AA = "Cache" if C[5] == "0" else "Authoritative"                                            # Authoritative 
    TC = "Not truncated" if C[6] == "0" else "Response too large for UDP"                       # Trancated
    RD = "Iterative" if C[7] == "0" else "Recursive"                                            # Recursion Desired
    RA = "Server does not manage recursive" if C[8] == "0" else "Server manages recursive"      # Recursion Avaliable
    Z = "Reserved for extensions" if C[9] == "0" else "Not reserved for extensions"             # Zero reserved for extensions
    Z_AD = "Not authenticated" if C[10] == "0" else "Authenticated"                             # Authenticated Data
    Z_CD = "Unacceptable" if C[11] == "0" else "Acceptable"                                     # Checking Disabled
    rcode = rcode_dic.get(int(C[12:],2), "Unknown")                                             # Reply Code
    
    return f"""
\tControl:
    \tMessage: {QR}
    \tOpcode: {opcode} (0b{C[1:5]})
    \tAuthoritative: {AA}
    \tTruncated: {TC}
    \tRecursion Desired: {RD}
    \tRecursion Avaliable: {RA}
    \tZ: {Z}
    \tAuthenticated Data: {Z_AD}
    \tChecking Disabled: {Z_CD}
    \tReply Code: {rcode}
"""
         
def QuestionC(octets):   
    #Question count
    QC = int(octets[4] + octets[5],16)
    return f"\tNumber of Questions: {QC}", QC

def AnswerC(octets):
    #Answer count
    AC = int(octets[6]+octets[7],16)
    return f"\tNumber of Answers: {AC}", AC
    
def AuthorityC(octets):
    #Authority count
    AUC = int(octets[8]+octets[9],16)
    return f"\tNumber of Authority Resource Records: {AUC}", AUC
    
def AdditionalC(octets):
    #Additional count
    ADC = int(octets[10]+octets[11],16)
    return f"\tNumber of Additional RRs: {ADC}", ADC
    
def Questions(octets, cnt):
    octets = octets[12:]
    idx = octets.index("00")
    q_name_octets = octets[:idx]
    q_type_val = int("".join(octets[idx+1:idx+3]), 16)
    q_class_val = int("".join(octets[idx+3:idx+5]), 16)
    octets_out = octets[idx+5:]

    q_name_list = []
    for octet in q_name_octets:
        if octet[0] == '0':
            if len(q_name_list) == 0:
                pass
            else:
                q_name_list.append(".")
        else:
            q_name_list.append(chr(int(octet,16)))
                
    q_name = "".join(q_name_list)
    q_type = type_rr_dict.get(q_type_val, 'Unknown')
    q_class = hex(q_class_val)
    return f"Questions:\n\n\t\tName: {q_name}\n\t\tType: {q_type}\n\t\tClass: {q_class}", octets_out

def getName(octets_dns, c, bool1, bool2):
    c_val = format(int(c,16), '016b')
    ptr = int(c_val[2:],2)
    word_list = []
    octets = octets_dns[ptr:]
    
    while True:
        if len(octets) == 0:
            break
        if octets[0] == "00":
            break
        elif octets[0][0] == "C":
            c_in = octets[0] + octets[1]
            word_list.append(getName(octets_dns,c_in,False, False))
            ptr += 2
            octets = octets[4:]
        else:
            length = int(octets[0][1],16)
            word_list.append("".join([chr(int(octet,16)) for octet in octets[1:1+length]]))
            octets = octets[1+length:]
            if bool2 is True:
                ptr += length+1


    name = ".".join(word_list)
    return (name, ptr-int(c_val[2:],2)) if bool1 is True else name


def Answers(octets, cnt, octets_dns):
    answers_list = ["Answers:"]
    idx = 0
    idx_abs = len(octets_dns) - len(octets)
    if len(octets)==0 or cnt ==0:
        pass
        return "\tAnswers Resource Records: None"
    else:
        while cnt!=0:
            if octets[0] == "00":
                return "\n\n".join(answers_list), octets
            if octets[0][0]=="C":
                type = type_rr_dict.get(int(''.join(octets[2:4]),16))
                length = int(''.join(octets[10:12]),16)
                if type == "A":
                    address = '.'.join([str(int(octet,16)) for octet in octets[12:16]])
                else:
                    if octets[12+length][0] == "C":
                        address = getName(octets_dns,octets[12+length]+octets[13+length], False, True)
                    else:
                        address = getName(octets_dns,hex(idx+idx_abs)[2:], False, True)
                answer = [
                    f" \t\tName: {getName(octets_dns, octets[0]+octets[1], False, True)}",
                    f" \t\tType: {type}",
                    f" \t\tClass: {int(''.join(octets[4:6]),16)}",
                    f" \t\tTime to live: {int(''.join(octets[6:10]),16)}",
                    f" \t\tData Length: {length}",
                    f" \t\tAddress: {address}",
                ]
                answers_list.append("\n".join(answer))
                octets = octets[12+length:]
                idx += 12+length
                cnt -= 1
                if len(octets) == 0:
                    return "\n\n".join(answers_list), octets
        return "\n\n".join(answers_list), octets

            # else:
            #     qname, n_l = getName(octets_dns, hex(idx+idx_abs)[2:], True, True)
            #     print(octets[idx:])
            #     idx += n_l
            #     print(octets[idx:])
            #     type = type_rr_dict.get(int(''.join(octets[idx:idx+2]),16))

            #     if type == "A":
            #         address = '.'.join([str(int(octet,16)) for octet in octets[idx+10:idx+14]])
            #     else:
            #         if octets[10+n_l][0] == "C":
            #             address = getName(octets_dns,octets[idx+10]+octets[idx+11], False, True)
            #             n_l = 2
            #         else:
            #             address, n_l = getName(octets_dns,hex(idx+10)[2:], True, True)
            #     answer = [
            #         f" Name: {qname}",
            #         f" Type: {type}",
            #         f" Class: {int(''.join(octets[idx+2:idx+4]),16)}",
            #         f" Time to live: {int(''.join(octets[idx+4:idx+8]),16)}",
            #         f" Data Length: {int(''.join(octets[idx+8:idx+10]),16)}",
            #         f" Address: {address}",
            #     ]
            #     print(answer)
            #     answers_list.append("\n".join(answer))
            #     idx += 10 + n_l
            #     octets = octets[idx:]
            #     if len(octets) == 0:
            #         return "\n\n".join(answers_list), octets


def Authority(octets, cnt, octets_dns):
    answers_list = ["Authorities:"]
    idx = 0
    idx_abs = len(octets_dns) - len(octets)
    if len(octets)==0 or cnt ==0:
        pass
        return "\tAuthority Resource Records: None"
    else:
        while cnt != 0:
            if octets[0] == "00":
                return "\n\n".join(answers_list), octets
            if octets[0][0]=="C":
                type = type_rr_dict.get(int(''.join(octets[2:4]),16))
                length = int(''.join(octets[10:12]),16)
                if type == "A":
                    address = '.'.join([str(int(octet,16)) for octet in octets[12:16]])
                else:
                    if octets[12+length][0] == "C":
                        address = getName(octets_dns,octets[12+length]+octets[13+length], False, True)
                    else:
                        address = getName(octets_dns,hex(idx+idx_abs)[2:], False, True)
                answer = [
                    f" \t\tName: {getName(octets_dns, octets[0]+octets[1], False, True)}",
                    f" \t\tType: {type}",
                    f" \t\tClass: {int(''.join(octets[4:6]),16)}",
                    f" \t\tTime to live: {int(''.join(octets[6:10]),16)}",
                    f" \t\tData Length: {length}",
                    f" \t\tAddress: {address}",
                ]
                answers_list.append("\n".join(answer))
                octets = octets[12+length:]
                idx += 12+length
                cnt -= 1
                if len(octets) == 0:
                    return "\n\n".join(answers_list), octets
        return "\n\n".join(answers_list), octets
    


def Additional(octets, cnt, octets_dns):
    answers_list = ["Additionals:"]
    idx = 0
    idx_abs = len(octets_dns) - len(octets)
    if len(octets)==0 or cnt ==0:
        pass
        return "\tAdditional Resource Records: None"
    else:
        while cnt != 0:
            if octets[0] == "00":
                return "\n\n".join(answers_list), octets
            if octets[0][0]=="C":
                type = type_rr_dict.get(int(''.join(octets[2:4]),16))
                length = int(''.join(octets[10:12]),16)
                if type == "A":
                    address = '.'.join([str(int(octet,16)) for octet in octets[12:16]])
                else:
                    if octets[12+length][0] == "C":
                        address = getName(octets_dns,octets[12+length]+octets[13+length], False, True)
                    else:
                        address = getName(octets_dns,hex(idx+idx_abs)[2:], False, True)
                answer = [
                    f" \t\tName: {getName(octets_dns, octets[0]+octets[1], False, True)}",
                    f" \t\tType: {type}",
                    f" \t\tClass: {int(''.join(octets[4:6]),16)}",
                    f" \t\tTime to live: {int(''.join(octets[6:10]),16)}",
                    f" \t\tData Length: {length}",
                    f" \t\tAddress: {address}",
                ]
                answers_list.append("\n".join(answer))
                octets = octets[12+length:]
                idx += 12+length
                cnt -= 1
                if len(octets) == 0:
                    return "\n\n".join(answers_list), octets
        return "\n\n".join(answers_list), octets

def getTitleDNS():
    return f"DNS Protocol:------------------------------------------------\n"          


def DNS(octets):
    octets_dns = octets
    ques_s, ques_cnt = QuestionC(octets)                # Questions Count
    answ_s, answ_cnt = AnswerC(octets)                # Answers Count
    auth_s, auth_cnt = AuthorityC(octets)               # Authority Count
    addi_s, addi_cnt = AdditionalC(octets)              # Additional Count


    elements = [
        getTitleDNS(),
        Identification(octets),             # Identification
        Control(octets) + "\n",                    # Control
        ques_s,
        answ_s,
        auth_s,
        addi_s+"\n\n",
    ]

    # Questions
    if len(octets) == 0:
        elements.append("\tQuestions: None\n\n")
    else:
        que_s, octets = Questions(octets, ques_cnt)
        elements.append("\t"+que_s+"\n\n")
    # Answers    
    if len(octets) == 0:
        elements.append("\tAnswers: None\n\n")
    else:
        ans_s, octets = Answers(octets, answ_cnt, octets_dns)
        elements.append("\t"+ans_s+"\n\n")

    # Authorities    
    if len(octets) == 0:
        elements.append("\tAuthority RRs: None\n\n")
    else:
        aut_s, octets = Authority(octets, auth_cnt, octets_dns)
        elements.append("\t"+aut_s+"\n\n")

    # Additionals    
    if len(octets) == 0:
        elements.append("\tAdditional RRs: None\n\n")
    else:
        add_s, seg_left = Additional(octets, addi_cnt, octets_dns)
        elements.append("\t"+add_s+"\n\n")

    parsed_dict = {"analysis": "\n".join(elements)}
    try:
        if len(seg_left) != 0:
            parsed_dict["left"] = seg_left
            parsed_dict["analysis"] + f"\n\n ! {len(seg_left)} BYTES OF UNPACKED DATA REMAINING"
    except UnboundLocalError:
        pass

    return parsed_dict

def Others(octets):
    parsed_dict = {"analysis": "(Application Layer) UNKNOWN PROTOCOL, NOT SUPPORTED:------------------------------------------"}
    return parsed_dict


def parserApplication(transport_dict):
    proto = transport_dict["utility"]
    octets = transport_dict["datagram"]
    if proto == "DNS":
        application_dict = DNS(octets)
    elif proto == "DHCP":
        application_dict = DHCP(octets)
    else:
        application_dict = Others(octets)
    return application_dict

