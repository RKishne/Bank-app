package bankingApp;

public class KotakBank implements BankingAppInterface{
    private String username;
    private String accountNo;
    private String password;
    private int balance;
    public static final double ROI =7.3;

    public KotakBank(String username, String accountNo, String password, int balance) {
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
            return "After deposit your updated balance is :"+balance;
        }
        return "Invalid Password !!!";
    }

    @Override
    public String withdrawMoney(String password, int money) {
         //kotak bank account has 1000 minimum amount is necessary;
        if(!password.equals(this.password)){
            return "Enter password is wrong!!!";
        }
        if(balance-money<1000){
            return "Insufficient Balance!!!";
        }
        balance=balance-money;
        return "After withdrawing your balance is :"+balance;
    }

    @Override
    public double rateOfInterest(int years) {
        return (ROI*years*balance)/100;
    }
}
