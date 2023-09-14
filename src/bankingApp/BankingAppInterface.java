package bankingApp;

public interface BankingAppInterface {
    public int fetchBalance(String password);
    public String addMoney(String password,int money);
    public String withdrawMoney(String password,int money);
    public double rateOfInterest(int years);
}
