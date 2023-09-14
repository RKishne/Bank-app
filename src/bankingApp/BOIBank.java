package bankingApp;

public class BOIBank implements BankingAppInterface{
    private String username;
    private String accountNo;
    private String password;
    private int balance;
    public static final double ROI =6.5;

    public BOIBank(String username, String accountNo, String password, int balance) {
        this.username = username;
        this.accountNo = accountNo;
        this.password = password;
        this.balance = balance;
    }

    @Override
    public int fetchBalance(String password) {
        if(password.equals(this.password)){
            return balance;
        }
        return -1;
    }

    @Override
    public String addMoney(String password, int money) {
        if(password.equals(this.password)){
            balance=balance+money;
            return "Your updated balance is :"+balance;
        }
        return "Invalid password";
    }

    @Override
    public String withdrawMoney(String password, int money) {
        //Boi 0 bank account ;
        if(password.equals(this.password)){
            return "Invalid password";
        }
        if(balance<money){
            return "Insufficient money";
        }
        balance=balance-money;
        return "After withdrawing your balance is :"+balance;
    }

    @Override
    public double rateOfInterest(int years) {
        return (ROI*balance*years)/100;
    }
}
