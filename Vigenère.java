import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Vigenère {
	
	public static void write(String plaintxt, String ciphertxt, String fileName) throws IOException {
        // Prepare data format to be wrote in file
        String Ptxt = "Plain text: " + plaintxt + " \n";
        String Ctxt = "Cipher text: " + ciphertxt + " \n";

        // Defining the file name of the file
        FileWriter myWriter = new FileWriter(fileName);
        // Writing into the file
        myWriter.write(Ptxt);
        myWriter.write(Ctxt);

        myWriter.close();

        System.out.println("Plain text and Cipher text were successfully stored in Output.txt file!!");

    }
	
	 public static String encrypt(String plaintext, String key)
	    {
	        String enc = "";
	        plaintext = plaintext.toUpperCase();
	        for (int i = 0, j = 0; i < plaintext.length(); i++)
	        {
	            char c = plaintext.charAt(i);
	            if (c < 'A' || c > 'Z')
	                continue;
	            enc += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
	            
	            j = ++j % key.length();
	        }
	        
	        try {
	    		write(plaintext,enc,"Encryption");//plain , cipher
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	} 
	        
	        return enc;
	    }
	 
	    public static String decrypt(String cipherText, String key)
	    {
	        String dec = "";
	        cipherText = cipherText.toUpperCase();
	        for (int i = 0, j = 0; i < cipherText.length(); i++)
	        {
	            char c = cipherText.charAt(i);
	            if (c < 'A' || c > 'Z')
	                continue;
	            dec += (char) ((c - key.charAt(j) + 26) % 26 + 'A');
	            j = ++j % key.length();
	        }
	        
	        try {
	    		write(dec,cipherText,"Decryption");//plain , cipher
	    	} catch (IOException e) {
	    		e.printStackTrace();
	    	} 
	        
	        return dec;
	    }
	 
	    public static void main(String[] args)
	    {
	    	Scanner read = new Scanner(System.in);
	    	int choice;
	    	System.out.println("Enter 1 for Encryption 2 for Decryption:");
            choice = read.nextInt();
            read.nextLine();
            String plainText="";
            String key="";
            String cipherText="";
          
	        
	        switch (choice) {
            case 1:
                System.out.println("Enter plain text:");
             plainText = read.nextLine();
                System.out.println("Enter key for Encryption:");
                key = read.nextLine();
                key = key.toUpperCase();
               cipherText = encrypt(plainText, key);
               //System.out.println("Encrypted text is:" + cipherText);
                
               
                
                
                break;

            case 2:
                System.out.println("Enter cipher text:");
                cipherText = read.nextLine();
                System.out.println("Enter key for Encryption:");
                key = read.nextLine();
                key = key.toUpperCase();
                plainText =  decrypt(cipherText, key);
               // System.out.println("Decrypted text is:" + plainText);
              
               
                
             break;
                
                
                
                
            default:
                System.out.println("WRONG VALUE");
        }
	        
	       
    }

}
