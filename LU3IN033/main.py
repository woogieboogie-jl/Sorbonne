import os, sys
import datalink
import network
import transport
import application
import hexdecoder
import iohandler

config_name = 'myapp.cfg'

# determine if application is a script file or frozen exe
if getattr(sys, 'frozen', False):
    application_path = os.path.dirname(sys.executable)
elif __file__:
    application_path = os.path.dirname(__file__)

config_path = os.path.join(application_path, config_name)

def initiate():
    print("""
  _                             _                        
 |_) ._ _  o  _   _ _|_   __   |_)  _   _  _   _.        
 |   | (_) | (/_ (_  |_        | \ (/_ _> (/_ (_| |_| >< 
          _|    
                            by Jaewook Lee && Paula Mendez
    """)
    while True:
        path_input = input(f"""

1. input your working directory(absolute path) and press enter
2. if you wish to in the default directory, press enter

* your current working directory is : {os.path.abspath(os.getcwd())}
""")
        try:
            if path_input:
                os.chdir(path_input)
            text_list = list(filter(lambda x: ".txt" in x, os.listdir()))
            print("----------AVALIABLE TEXT FILES-----------")
            for file in text_list:
                print(file)
            print("\n")
            while True:
                file_input =input("input filename...")
                filepath = os.path.abspath(os.getcwd()) + "/" + file_input
                try:
                    file = iohandler.fileinput(filepath)
                    return file
                except FileNotFoundError:
                    print("! FILE NOT FOUND PLEASE TYPE THE RIGHT FILENAME!")  
                except IsADirectoryError:
                    print("! NOT FOUND: INPUT A PROPER FILENAME")

        
        except (FileNotFoundError, NotADirectoryError) as e:
            print("! WRONG DIRECTORY, PLEASE TYPE THE RIGHT DIRECTORY!")
            continue



def parser(hex_list):
    hex_list_filtered = hexdecoder.filterData(hex_list)
    hex_list_seperated = hexdecoder.splitTrace(hex_list_filtered)
    hex_list_parsed = hexdecoder.offsetSeq(hex_list_seperated)
    return hex_list_parsed



def main():
    frames = parser(initiate())
    output_multiple = [f"===============RESULTS================\n* {len(frames)} Frames in total"]
    for idx, octets in enumerate(frames):
        output_single = [f"\n* {(idx+1)} of {len(frames)} *\n"]
        datalink_dict = datalink.parserDatalink(octets)
        network_dict = network.parserNetwork(datalink_dict)
        transport_dict = transport.parserTransport(network_dict)
        application_dict = application.parserApplication(transport_dict)

        output_single.append(datalink_dict["analysis"])
        output_single.append(network_dict["analysis"])
        output_single.append(transport_dict["analysis"])
        output_single.append(application_dict["analysis"])
        text_single = "\n\n\n\n\n".join(output_single)

        
        output_multiple.append(text_single)

    text_out = "\n\n----------------------------------\n\n".join(output_multiple)
    print(text_out)
    iohandler.fileoutput(output=text_out)
    

if __name__ == "__main__":
    main()