import javax.annotation.processing.Filer;
import java.io.*;
import java.util.Scanner;
public class AccountManager {


    public void registerAccount(){
        //method that will register accounts
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Create a pin for your account, 4 numbers long");
            String pin = "";
            //allows user to register a pin, forces length to be 4
            while(pin.length() != 4)
            {
                 pin = scanner.nextLine();
                 if(pin.length() != 4)
                 {
                     System.out.println("pin length must be 4!");
                 }
            }

            BufferedWriter bw = new BufferedWriter(new FileWriter("Accounts/accounts.txt",true));
            bw.write(pin+" "+"0.00\n");
            bw.close();

        }catch(Exception e)
        {
            System.out.println(e);
        }


    }

    public void login(){

    }

}
