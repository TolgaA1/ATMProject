import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("hello!");
        System.out.println("Welcome to ATM!");
        AtmApp atmApp;
        AccountManager acc = new AccountManager();

        acc.loginProcess();
        atmApp = new AtmApp(acc.getLoggedInPin(),acc.getLoggedInFloat());
        System.out.println(atmApp.getPin()+" "+atmApp.getBalance());

    }
}
