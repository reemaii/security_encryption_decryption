package ceaser;

//Importing required classes
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class ceasar   
{   
	
	
	
 // ALPHABET string denotes alphabet from a-z   
 public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";   
   
 //  encryptData() method for encrypting user input string with given shift key   
 public static void encryptData()     
 {   
     Scanner sc = new Scanner(System.in); 

	 System.out.println("Enter a string for encryption using Caesar Cipher: ");   
     String inputStr = sc.nextLine(); 
     
       
     // encryptStr to store encrypted data   
     String encryptStr = "";   
     System.out.println("Enter the Key value by which each character in the plaintext message gets shifted: ");   
     int shiftKey = Integer.valueOf(sc.nextLine());
     
     // convert inputStr into lower case 
     inputStr = inputStr.toLowerCase();
     
     // loop -> traversing each character of the input string   
     for (int i = 0; i < inputStr.length(); i++)   
     {   
         // get position of each character of inputStr in ALPHABET
    	 if(inputStr.charAt(i) != ' ')
    	 { int pos = ALPHABET.indexOf(inputStr.charAt(i));   
           
         // get encrypted char for each char of inputStr   
         int encryptPos = (shiftKey + pos) % 26;   
         char encryptChar = ALPHABET.charAt(encryptPos);   
           
         // add encrypted char to encrypted string   
         encryptStr += encryptChar;  }
    	 else 
    		 encryptStr += ' '; 
     }   
     encryptStr=encryptStr.toUpperCase();
     try {
		write(inputStr.toUpperCase(),encryptStr,"Encryption");//plain , cipher
	} catch (IOException e) {
		e.printStackTrace();
	} 

//     System.out.println("Encrypted Data ===> "+ encryptStr);   
 }   
   
 // decryptData() method for decrypting user input string with given shift key   
 public static void decryptData()   
 {   
     Scanner sc = new Scanner(System.in); 
     System.out.println("Enter a string for decryption using Caesar Cipher: ");   
     String inputStr = sc.nextLine(); 

      System.out.println("Enter the Key value by which each character in the plaintext message gets shifted: ");   
      int shiftKey = Integer.valueOf(sc.nextLine());
      
      // convert inputStr into lower case   
     inputStr = inputStr.toLowerCase();   
       
     // decryptStr to store decrypted data   
     String decryptStr = "";   
       
     //loop -> traversing each character of the input string   
     for (int i = 0; i < inputStr.length(); i++)   
     {   
    	 if(inputStr.charAt(i) != ' ') {
         // get position of each character of inputStr in ALPHABET   
         int pos = ALPHABET.indexOf(inputStr.charAt(i));   
           
         // get decrypted char for each char of inputStr   
         int decryptPos = (pos - shiftKey) % 26;   
           
         // if decryptPos is negative   
         if (decryptPos < 0){   
             decryptPos = ALPHABET.length() + decryptPos;   
         }   
         char decryptChar = ALPHABET.charAt(decryptPos);   
           
         // add decrypted char to decrypted string   
         decryptStr += decryptChar; }
    	 else
    		 decryptStr += ' '; 
     }
     decryptStr=decryptStr.toUpperCase();
    
     try {
		write(decryptStr,inputStr.toUpperCase(),"Decryption"); //plain , cipher
	} catch (IOException e) {
		e.printStackTrace();
	}

//     System.out.println("Decrypted Data ===> "+ decryptStr);   
 }
 
 
 public static void write(String plaintxt,String ciphertxt,String fileName)
	        throws IOException
	    {
	      // Prepare data format to be wrote in file
	       String Ptxt="Plain text: "+plaintxt+" \n";
	       String Ctxt="Cipher text: "+ciphertxt+" \n";
	 
	        // Defining the file name of the file
	       FileWriter myWriter = new FileWriter(fileName);
	       // Writing into the file
	       myWriter.write(Ptxt);
	       myWriter.write(Ctxt);

	       myWriter.close();
	       
	       System.out.println("Plain text and Cipher text were successfully stored in Output.txt file!! \n");
	       
	 
	    }
   
 // main  
 public static void main(String[] args) throws IOException   
 {   
     Scanner sc = new Scanner(System.in); 
     int choice;
      do {
    	  System.out.println("Please Choose from the following:\n 1 for Encryption:\n 2 for Decryption:\n 0 for Exit:\n ");   
    	  choice=sc.nextInt();
    	  
    	  switch(choice) {
    	  
    	  case 1: 
    		  encryptData();
    	     break;
    	  case 2:
    		  decryptData();
     	    break;
    	  
    	  }
      
      }while(choice!=0);
 
     // close Scanner class object   
     sc.close();   
 }   
}   