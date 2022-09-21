/*
This class is responsible for managing user logins
Once the user has logged in, it passes on the pin and the balance to the app class which will be the main app
 */

import java.io.*;
import java.util.Scanner;
public class AccountManager {

    private String loggedInPin;
    private float loggedInBalance;

    public boolean checkIfPinExists(String pinToCheck)
    {
        try{
            BufferedReader br = new BufferedReader(new FileReader("Accounts/accounts.txt"));
            String readLine;

            //while loop that reads through database and checks if user exists
            while((readLine = br.readLine()) != null)
            {
                String[] currentUser = readLine.split(" ");
                String pinToCompare = currentUser[0];
                if(pinToCompare.equals(pinToCheck))
                {

                    return true;
                }
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public void registerAccount(){
        //method that will register accounts
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Create a pin for your account, 4 numbers long");
            String pin = "";
            boolean pinExist = false;

            //allows user to register a pin, forces length to be 4
            while(pin.length() != 4 || pinExist)
            {
                 pin = scanner.nextLine();
                 if(pin.length() != 4)
                 {
                     System.out.println("pin length must be 4!");
                 }
                pinExist = checkIfPinExists(pin);
                 if(pinExist)
                 {
                     System.out.println("pin already taken, enter a new one.");
                 }
            }

            scanner.close();
            File file = new File("Accounts/accounts.txt");
            BufferedWriter bw;
            //checks if file is empty, and if it is, then write in write mode or else, in append mode.
            if (file.length() == 1)
            {
                bw = new BufferedWriter(new FileWriter("Accounts/accounts.txt"));
            }
            else
            {
                bw = new BufferedWriter(new FileWriter("Accounts/accounts.txt", true));
            }
            bw.write(pin+" "+"0.00\n");
            bw.close();
            System.out.println("Account created!");


        }catch(Exception e)
        {
            e.printStackTrace();
        }


    }

    public void loginProcess(){
        //method that will allow user to login
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your pin, 4 digits long");
            String pin = "";
            boolean pinExist = false;
            //validation checks for pin
            while(!pinExist)
            {
                pin = scanner.nextLine();
                //error checking here, validates whether pin exists
                pinExist = checkIfPinExists(pin);
                if(!pinExist)
                {
                    System.out.println("pin entered doesn't exist.");
                }
            }
            System.out.println("Success! logged in.");

        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public float getLoggedInFloat() {
        return loggedInBalance;
    }

    public String getLoggedInPin() {
        return loggedInPin;
    }
}
