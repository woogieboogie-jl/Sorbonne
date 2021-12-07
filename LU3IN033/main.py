import os
import datalink
import network
import transport
import application
import hexdecoder
import iohandler

def initiate():
    while True:
        path_input = input("input working directory, press enter if you wish to analyze in current directory...")
        try:
            if path_input:
                os.chdir(path_input)
            text_list = list(filter(lambda x: ".txt" in x, os.listdir()))
            print("----------AVALIABLE TEXT FILES-----------")
            for file in text_list:
                print(file)
            
            while True:
                file_input =input("input filename...")
                path = os.path.abspath(os.getcwd()) + "/" + file_input
                try:
                    file = iohandler.fileinput(path)
                    return file
                except FileNotFoundError:
                    print("FILE NOT FOUND! PLEASE TYPE THE RIGHT FILENAME!...")  
                except IsADirectoryError:
                    print("INPUT FILENAME, NOT DIRECTORY!...")
    
            
        except FileNotFoundError:
            print("WRONG DIRECTORY! PLEASE TYPE THE RIGHT DIRECTORY!...")
            continue



def parser(hex_list):
    hex_list_filtered = hexdecoder.filterData(hex_list)
    hex_list_seperated = hexdecoder.splitTrace(hex_list_filtered)
    hex_list_parsed = hexdecoder.offsetSeq(hex_list_seperated)
    return hex_list_parsed



def main():
    frames = parser(initiate())
    output_multiple = [f"===============RESULTS================\n* {len(frames)} Frames in total"]
    for octets in frames:
        output_single = []
        datalink_dict = datalink.parserDatalink(octets)
        network_dict = network.parserNetwork(datalink_dict)
        transport_dict = transport.parserTransport(network_dict)
        application_dict = application.parserApplication(transport_dict)

        output_single.append(datalink_dict["analysis"])
        output_single.append(network_dict["analysis"])
        output_single.append(transport_dict["analysis"])
        output_single.append(application_dict["analysis"])
        text_single = "\n\n".join(output_single)
        output_multiple.append(text_single)

    text_out = "\n\n----------------------------------\n\n".join(output_multiple)
    print(text_out)
    iohandler.fileoutput(output=text_out)

if __name__ == "__main__":
    main()