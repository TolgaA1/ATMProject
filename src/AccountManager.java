/*
This class is responsible for managing user logins
Once the user has logged in, it passes on the pin and the balance to the app class which will be the main app
 */
import java.io.*;
import java.util.Scanner;
public class AccountManager {

    private String loggedInPin;
    private float loggedInBalance;

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

    public boolean loginProcess(){
        //method that will allow user to login
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your pin, 4 digits long");
            String pin = "";

            //validation checks for pin
            while(pin.length() != 4)
            {
                pin = scanner.nextLine();
                if(pin.length() != 4)
                {
                    System.out.println("pin length must be 4!");
                }
            }

            BufferedReader br = new BufferedReader(new FileReader("Accounts/accounts.txt"));
            String readLine;

            //while loop that reads through database and checks if user exists
            while((readLine = br.readLine()) != null)
            {
                String[] currentUser = readLine.split(" ");
                loggedInPin = currentUser[0];
                loggedInBalance = Float.parseFloat(currentUser[1]);
                if(loggedInPin.equals(pin))
                {
                    System.out.println("User found! success!");
                    return true;
                }
            }



        }catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }

    public float getLoggedInFloat() {
        return loggedInBalance;
    }

    public String getLoggedInPin() {
        return loggedInPin;
    }
}
