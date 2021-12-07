#DNS messages

#sources to find format and values:
    #http://www-inf.int-evry.fr/~hennequi/CoursDNS/NOTES-COURS_eng/msg.html
    #https://www.iana.org/assignments/dns-parameters/dns-parameters.xhtml#dns-parameters-2
    #https://spathis.medium.com/comprendre-internet-et-son-fonctionnement-9b2f63a07430
    #https://en.wikipedia.org/wiki/Domain_Name_System#DNS_message_format

#only use if DNS = True
type_rr_dict = {1: 'A', 28: 'AAAA', 5: 'CNAME', 2: 'NS', 15: 'MX'}
octets = ['fb','93','01','00','00','01','00','00','00','00','00','00','03','73','73','6c','07','67','73','74','61','74','69','63','03','63','6f','6d','00','00','01','00','01']


def Identification(octets):
    #Identification
    I = hex(int(octets[0]+octets[1],16))
    return f"Transaction ID: {I}"
    
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
Control:
    Message: {QR}
    Opcode: {opcode} (0b{C[1:5]})
    Authoritative: {AA}
    Truncated: {TC}
    Recursion Desired: {RD}
    Recursion Avaliable: {RA}
    Z: {Z}
`   Authenticated Data: {Z_AD}
    Checking Disabled: {Z_CD}
    Reply Code: {rcode}
"""
         
def QuestionC(octets):   
    #Question count
    QC = int(octets[4] + octets[5],16)
    return f"Number of Questions: {QC}"

def AnswerC(octets):
    #Answer count
    AC = int(octets[6]+octets[7],16)
    return f"Number of Answers: {AC}"
    
def AuthorityC(octets):
    #Authority count
    AUC = int(octets[8]+octets[9],16)
    return f"Number of Authority Resource Records: {AUC}"
    
def AdditionalC(octets):
    #Additional count
    ADC = int(octets[10]+octets[11],16)
    return f"Number of Additional RRs: {ADC}"
    
    #DNS contains Resouce Records: RR
    #(NAME, VALUE, TYPE, TTL)
    
    
def Questions(octets):
    octets = octets[12:]
    idx = octets.index("00")
    q_name_octets = octets[:idx]
    
    q_type_val = int("".join(octets[idx+1:idx+3]), 16)
    q_class_val = int("".join(octets[idx+3:]), 16)
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
    #name, type, class
    #length of name is unknown, name is made of labels whose length is indicated by the first octect
    #label end of name is 00
    q_type = type_rr_dict.get(q_type_val, 'Unknown')
    q_class = hex(q_class_val)
    # octets=octets[i+34:]
    return f"Questions: \n\t Name: {q_name} \n\t Type: {q_type} \n\t Class: {q_class}", octets
    #it has to returned the chopped list without the questions as well so its easy to implement again the loop
    #for the name :)
    
def Answers(octets): 
    #name, type, class, ttl, rdata_length, rdata
    #length of name is unknown, name is made of labels whose length is indicated by the first octect
    #label end of name is 00
    i = 0
    Q = ''
    while octets[i] != '00': 
        Q += octets[i]
        i = i + 1
    Q = hex(int(Q,16))
    T = octets[i:i+2]
    T = TypeRR.get(T, 'Unknown')
    C = int(octets[i+2:i+4],16)
    C = hex(C)
    TTL = int(octets[i+4:i+8],16)
    Rdata_length = int(octets[i+8,i+10],16)
    Rdata = hex(int(octets[i+10:i+10+Rdata_length],16))
    octets = octets[i+10+Rdata_length:]
    return f"Answers: \n\t Nom de domaine: {Q} \n\t Type d'enregistrement: {T} \n\t Class: {C} \n\t TTL: {TTL} \
            \n\t Length Data: {Rdata_length} \n\t Data: {Rdata}", octets
    
def Authority(octets):
    #name, type, class, ttl, rdata_length, rdata
    #length of name is unknown, name is made of labels whose length is indicated by the first octect
    #label end of name is 00
    i = 0
    Q = ''
    while octets[i] != '00': 
        Q += octets[i]
        i = i + 1
    Q = hex(int(Q,16))
    T = octets[i:i+2]
    T = TypeRR.get(T, 'Unknown')
    C = int(octets[i+2:i+4],16)
    C = hex(C)
    TTL = int(octets[i+4:i+8],16)
    Rdata_length = int(octets[i+8,i+10],16)
    Rdata = hex(int(octets[i+10:i+10+Rdata_length],16))
    octets = octets[i+10+Rdata_length:]
    return f"Authority: \n\t Nom de domaine: {Q} \n\t Type d'enregistrement: {T} \n\t Class: {C} \n\t TTL: {TTL} \
            \n\t Length Data: {Rdata_length} \n\t Data: {Rdata}", octets
    
    
def Additional(octets):
    #name, type, class, ttl, rdata_length, rdata
    #length of name is unknown, name is made of labels whose length is indicated by the first octect
    #label end of name is 00
    i = 0
    Q = ''
    while octets[i] != '00': 
        Q += octets[i]
        i = i + 1
    Q = hex(int(Q,16))
    T = octets[i:i+2]
    T = TypeRR.get(T, 'Unknown')
    C = int(octets[i+2:i+4],16)
    C = hex(C)
    TTL = int(octets[i+4:i+8],16)
    Rdata_length = int(octets[i+8,i+10],16)
    Rdata = hex(int(octets[i+10:i+10+Rdata_length],16))
    octets = octets[i+10+Rdata_length:]
    return f"Additional: \n\t Nom de domaine: {Q} \n\t Type d'enregistrement: {T} \n\t Class: {C} \n\t TTL: {TTL} \
            \n\t Length Data: {Rdata_length} \n\t Data: {Rdata}", octets
    
    
    
def DNS(octets):
    #Identification
    print(Identification(octets))
    
    #Control
    print(Control(octets))
    
    #Question count
    print(QuestionC(octets))
    
    #Answer count
    print(AnswerC(octets))
    
    #Authority Count
    print(AuthorityC(octets))
    
    #Additional Count
    print(AdditionalC(octets))
    
    #Questions
    print(Questions(octets))
    
    #Answers
    print(Answers(octets))
    
    #Authority
    print(Authority(octets))
    
    #Additional
    print(Additional(octets))
    
    return 



DNS(octets)
    
    
    
    
    
    

