#README

#WHAT IS IT FOR 

This program is a network protocol analyser tool, being similar to Wireshark. It takes as input a text file that contains the captured octets of one or several 
Ethernet frames. The tool is able to analyse in depth the following protocols:
	-Data Link Layer: Ethernet
	-Network Layer: IP
	-Transport Layer: UDP
	-Application Layer: DNS and DHCP
The output of the tool is another text file with the protocols contained in each frame as well as all the information that can be extracted from these protocols. 
The language used was Python due to various tools available fro indexing and parsing. The program can be executed directly using the main.py file or by using an 
.exe file that will open the program in your terminal.



#STRUCTURE

The program is organized similarly to the different layers that the network protocol is made of. 
The main program can be found in 'main.py'. This code retrieves the input from the user, as well as combines all the elements of the tool.
It generates the parsing function from the imported 'hexdecoder.py' and imports the functions that analyse the different layers.
The parsing function takes care of rearranging the information from the input file in order to generate strings of octects that can be 
analysed by the protocol functions. 
The analysis of the different layers is carried out by:
	-'datalink.py': Ethernet 
	-'network.py': IP
	-'transport.py': UDP
	-'application.py': DNS and DHCP
The output of this functions are directories which contains the octects to be used in the next layer as well as a string with all the information that will be 
printed out by the main. In the main file also an output text file is created. 



#LIMITATIONS	
	
The tool is able to filter out the useful octets from the text files, ignoring lines of octets that are defined by the wrong offset octets or random 
characters. It is also able to analyse files with several Ethernet frames. This is all done by the use of a parsing function.

The tool is also able to demand the choice of a valid text file until the file chosen exists. However, if you accidentaly type a wrong existing directory it 
does not ask for another directory and you have to quit the program and restart it once again. 

The tool is not able to verify whether the checksum of the IP and UDP protocols is verified. Furthermore, it can detect the existence of other protocols 
in the frame such as ICMP or TCP but it is not able to further analyse its champs and options. 
