def getSourceMAC(octets):
    return f"\tSource MAC: {'.'.join(octets[0:6])}"


def getDestinMAC(octets):
    return f"\tDestination MAC: {'.'.join(octets[6:12])}"


def getType(octets):
    type_dict = {
    "0800"	: "Internet Protocol version 4 (IPv4)",
    "0806"	: "Address Resolution Protocol (ARP)",
    "0842"	: "Wake-on-LAN[9]",
    "22F0"	: "Audio Video Transport Protocol (AVTP)",
    "22F3"	: "IETF TRILL Protocol",
    "22EA"	: "Stream Reservation Protocol",
    "6002"	: "DEC MOP RC",
    "6003"	: "DECnet Phase IV, DNA Routing",
    "6004"	: "DEC LAT",
    "8035"	: "Reverse Address Resolution Protocol (RARP)",
    "809B"	: "AppleTalk (Ethertalk)",
    "80F3"	: "AppleTalk Address Resolution Protocol (AARP)",
    "8100"	: "VLAN-tagged frame (IEEE 802.1Q) and Shortest Path Bridging IEEE 802.1aq with NNI compatibility[10]",
    "8102"	: "Simple Loop Prevention Protocol (SLPP)",
    "8103"	: "Virtual Link Aggregation Control Protocol (VLACP)",
    "8137"	: "IPX",
    "8204"	: "QNX Qnet",
    "86DD"	: "Internet Protocol Version 6 (IPv6)",
    "8808"	: "Ethernet flow control",
    "8809"	: "Ethernet Slow Protocols[11] such as the Link Aggregation Control Protocol (LACP)",
    "8819"	: "CobraNet",
    "8847"	: "MPLS unicast",
    "8848"	: "MPLS multicast",
    "8863"	: "PPPoE Discovery Stage",
    "8864"	: "PPPoE Session Stage",
    "887B"	: "HomePlug 1.0 MME",
    "888E"	: "EAP over LAN (IEEE 802.1X)",
    "8892"	: "PROFINET Protocol",
    "889A"	: "HyperSCSI (SCSI over Ethernet)",
    "88A2"	: "ATA over Ethernet",
    "88A4"	: "EtherCAT Protocol",
    "88A8"	: "Service VLAN tag identifier (S-Tag) on Q-in-Q tunnel.",
    "88AB"	: "Ethernet Powerlink[citation needed]",
    "88B8"	: "GOOSE (Generic Object Oriented Substation event)",
    "88B9"	: "GSE (Generic Substation Events) Management Services",
    "88BA"	: "SV (Sampled Value Transmission)",
    "88BF"	: "MikroTik RoMON (unofficial)",
    "88CC"	: "Link Layer Discovery Protocol (LLDP)",
    "88CD"	: "SERCOS III",
    "88E1"	: "HomePlug Green PHY",
    "88E3"	: "Media Redundancy Protocol (IEC62439-2)",
    "88E5"	: "IEEE 802.1AE MAC security (MACsec)",
    "88E7"	: "Provider Backbone Bridges (PBB) (IEEE 802.1ah)",
    "88F7"	: "Precision Time Protocol (PTP) over IEEE 802.3 Ethernet",
    "88F8"	: "NC-SI",
    "88FB"	: "Parallel Redundancy Protocol (PRP)",
    "8902"	: "IEEE 802.1ag Connectivity Fault Management (CFM) Protocol / ITU-T Recommendation Y.1731 (OAM)",
    "8906"	: "Fibre Channel over Ethernet (FCoE)",
    "8914"	: "FCoE Initialization Protocol",
    "8915"	: "RDMA over Converged Ethernet (RoCE)",
    "891D"	: "TTEthernet Protocol Control Frame (TTE)",
    "893a"	: "1905.1 IEEE Protocol",
    "892F"	: "High-availability Seamless Redundancy (HSR)",
    "9000"	: "Ethernet Configuration Testing Protocol[12]",
    "F1C1"	: "Redundancy Tag (IEEE 802.1CB Frame Replication and Elimination for Reliability)",
    }
    type = ''.join(octets[12:14])
    return f"\tType: {type_dict.get(type, f'Unknown({type})')}", type


def typeARP(octets):
    pass


def getTitleEth():
    return f"Ethernet Protocol:------------------------------------------\n"




    # returns a dictionary with string of data regarding Network Layer + boolean that checks if UDP value is true or not
def parserDatalink(octets):
    type_s, type = getType(octets)

    elements = [
        getTitleEth(),
        getSourceMAC(octets), 
        getDestinMAC(octets), 
        type_s,
    ]
    
    parsed_dict = {"packet": octets[14:], "type": type, "analysis": "\n".join(elements)}
    return parsed_dict



