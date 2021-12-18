import network

port_dict = { 53: "DNS", 67: "DHCP", 68: "DHCP" }

def getSourcePort(octets):
    SP = int(octets[0] + octets[1], 16)
    return f"\tSource Port: {SP} ({port_dict.get(SP, 'Client')})", SP

def getDestinPort(octets):
    DP = int(octets[2] + octets[3], 16)
    return f"\tDestination Port: {DP} ({port_dict.get(DP, 'Client')})", DP

def getLength(octets):
    return f"\tLength: {int(octets[4] + octets[5],16)}"

def getCS(octets):
    CS = int(octets[6]+octets[7],16)
    return f"\tChecksum: {CS} ({bin(CS)})"

def getTitleT(proto):
    return f"{proto}:-----------------------------------------------------\n"



def protoUDP(octets, proto):
    SP_s, SP = getSourcePort(octets)
    DP_s, DP = getDestinPort(octets)
    server_port = SP if SP <= DP else DP
    port_appli = port_dict.get(server_port)

    elements = [
        getTitleT(proto),
        SP_s,
        DP_s,
        getLength(octets),
        getCS(octets),
    ]
    
    parsed_dict = {"datagram": octets[8:], "utility": port_appli, "analysis": "\n".join(elements)}
    return parsed_dict

def protoTCP(octets, proto):
    parsed_dict = {"datagram": [], "utility": "N/A", "analysis": "(Transport Layer) TCP PROTOCOL NOT SUPPORTED:------------------------------------------"}
    return parsed_dict

def protoOthers(octets,proto):
    parsed_dict = {"datagram": [], "utility": "N/A", "analysis": "(Transport Layer) UNKNOWN PROTOCOL, NOT SUPPORTED:------------------------------------------"}
    return parsed_dict
    






def parserTransport(network_dict):
    proto = network_dict["protocol"]
    octets = network_dict["segment"]
    if proto == "UDP":
        transport_dict = protoUDP(octets,proto)
    elif proto == "TCP":
        transport_dict = protoTCP(octets,proto)
    else:
        transport_dict = protoOthers(octets,proto)
    return transport_dict


