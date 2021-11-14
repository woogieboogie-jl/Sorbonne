//Exercise 8

class Bonjour {
	public static void main(String[] args) {
		System.out.println("Bonjour");
	}	
}



/* 
8.1.1
javac Bonjour.java

8.1.2 
Bonjour.class

8.1.3 
No, it is not executed

8.2.1
Error Message is as follows:

Bonjour.java:4: error: ';' expected
	public sta tic void main(String[] args) {	              ^

1 error

8.2.2
Error Message is as follows:

Bonjour.java:5: error: unclosed string literal
		System.out.println("Bonjour);
		                   ^
1 error


8.2.3
we can compile, but we the class file sends out an error when executed, the error is as follows:

Error: Main method not found in class Bonjour, please define the main method as:
   public static void main(String[] args)
or a JavaFX application class must extend javafx.application.Application

8.2.4
Error Message is as follows:

Bonjour.java:7: error: reached end of file while parsing
}
 ^
1 error

8.2.5
It compiles, but it sends out an error message when executed, it is as follows:

Error: Main method not found in class Bonjour, please define the main method as:
   public static void main(String[] args)
or a JavaFX application class must extend javafx.application.Application

8.2.6
it compiles but it sends out an error message when executed, it is as follows:

Error: Main method is not static in class Bonjour, please define the main method as:
   public static void main(String[] args)



*/
