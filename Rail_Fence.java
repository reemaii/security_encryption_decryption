import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

public class Rail_Fence {
    
    public static void Encryption(String plainText, int rows) throws Exception {
        String encryptedText = "";
        int col = plainText.length();
        int row = rows;
        boolean check = false;
        int j = 0;
        char[][] rail = new char[row][col];

        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                rail[i][k] = '*';
            }
        }
        for (int i = 0; i < col; i++) {
            if (j == 0 || j == rows - 1) {
                check = !check;
            }
            rail[j][i] = plainText.charAt(i);

            if (check) {
                j++;
            } else {
                j--;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                char ch = rail[i][k];
                if (ch != '*') {
                    encryptedText += rail[i][k];
                }
            }
        }
        try {
            write(plainText, encryptedText, "Encryption");//plain , cipher
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Decryption(String cipherText, int rows) throws Exception {
        String decryptedText = "";

        int col = cipherText.length();
        int row = rows;
        boolean check = false;
        int j = 0;
        char[][] rail = new char[row][col];

        //to fill the array:
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                rail[i][k] = '*';
            }
        }
        for (int i = 0; i < col; i++) {
            if (j == 0 || j == rows - 1) {
                check = !check;
            }
            rail[j][i] = '#';

            if (check) {
                j++;
            } else {
                j--;
            }
        }
        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                char ch = rail[i][k];
                if (ch == '#' && index < col) {
                    rail[i][k] = cipherText.charAt(index++);
                }
            }
        }
        j = 0;
        check = false;
        for (int i = 0; i < col; i++) {
            if (j == 0 || j == rows - 1) {
                check = !check;
            }
            decryptedText += rail[j][i];

            if (check) {
                j++;
            } else {
                j--;
            }
        }
        try {
            write(decryptedText, cipherText, "Decryption"); //plain , cipher
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

    public static void main(String[] args) throws Exception {
        {
            Scanner input = new Scanner(System.in);
            int rows, choice;

            String plainText, cipherText;
            System.out.println("Enter 1 for Encryption 2 for Decryption:");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter plain text:");
                    plainText = input.nextLine();
                    System.out.println("Enter number of rows for Encryption:");
                    rows = input.nextInt();
                    input.nextLine();
                    Encryption(plainText, rows);                 
                    break;

                case 2:
                    System.out.println("Enter cipher text:");
                    cipherText = input.nextLine();
                    System.out.println("Enter number of rows for Decryption:");
                    rows = input.nextInt();
                    input.nextLine();
                    Decryption(cipherText, rows);
                    break;
                default:
                    System.out.println("WRONG VALUE");
            }
        }
    }
}
