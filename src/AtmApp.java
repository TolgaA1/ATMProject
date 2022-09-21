//Where the main app functions
import java.util.Scanner;

public class AtmApp {
    private String pin;
    private float balance;
    private AccountManager accountManager;

    public AtmApp()
    {
        accountManager = new AccountManager();
    }
    public void start()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to ATM!");
        System.out.println("Please login to your account\npress 1 to login\n2 to register an account");
        int userInput = 4;

        while(userInput > 3)
        {
            userInput = scanner.nextInt();
            if(userInput > 3)
            {
                System.out.println("invalid");
            }
        }

        switch(userInput){
            case 1:
                accountManager.loginProcess();
                pin = accountManager.getLoggedInPin();
                balance = accountManager.getLoggedInBalance();
                break;
            case 2:
                accountManager.registerAccount();
                break;
        }
        System.out.println("Current Account\nPin - "+pin+"\nbalance - £"+balance);



    }
    public void setPin(String pin)
    {
        this.pin = pin;
    }
    public void setBalance(float balance)
    {
        this.balance =balance;
    }
    public String getPin()
    {
        return this.pin;
    }
    public float getBalance()
    {
        return this.balance;
    }
}
