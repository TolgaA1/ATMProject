public class AtmApp {
    private String pin;
    private float balance;

    public AtmApp(String pin, float balance)
    {
        this.pin = pin;
        this.balance =balance;
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
