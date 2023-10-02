import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//Search for Tokens, delimited
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = null;
        //Create a List of Clients. Create all needed classes.
        ContactProfile con1 = new ContactProfile("Ronnie", "ronnie@emailserver.com", 67098902);
        ContactProfile con2 = new ContactProfile("Mary", "mary@emailserver.com", 23904599);
        ContactProfile con3 = new ContactProfile("Sam", "sam@emailserver.com", 45673423);
        ContactProfile con4 = new ContactProfile("Bonnie", "bonnie@emailserver.com", 99081267);
        //Token per Token
        try {
            //Read file clients_info.txt, in every line there is a client information.
            input = new Scanner(new BufferedReader(new FileReader("src/clients_info.txt")));

            while (input.hasNext()){
                System.out.println("Name: "+ input.next() + " Email: "+ input.next() + " Phone Number: "+ input.next());
                System.out.println();
            }
            //Each client has name, email and phone. Separated with spaces.

            //Create a Client object and add it to the clients list.

        } finally {
            if (input != null){
                input.close();
            }
        }

        //Serializable
        ObjectOutputStream savecontacts = null;
        try {
            savecontacts = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("src/clients_info_backup.txt")));
            savecontacts.writeObject(con1);
            savecontacts.writeObject(con2);
            savecontacts.writeObject(con3);
            savecontacts.writeObject(con4);

            //Save the contacts list object on a file named client_info_backup.txt
        } finally {
            if (savecontacts != null){
                savecontacts.close();
            }
        }



        //Deserialize
        ObjectInputStream restoring = null;
        ContactProfile restoreContact;
        try {
            restoring = new ObjectInputStream(new BufferedInputStream(new FileInputStream("src/clients_info_backup.txt")));
            while (restoring!=null){
                restoreContact = (ContactProfile) restoring.readObject();
                System.out.println(restoreContact +"\n");
            }
            //Restore the Contact List.
            //Print all the contacts.
        } catch (EOFException e){
            System.out.println();
            System.out.println("-----End of file reached------");

        } finally {
            if (restoring != null){
                restoring.close();
            }
        }
    }
}

