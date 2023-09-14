package bankingApp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("First entered your informations :-");
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter your name :-");
        String name=sc.next();

        System.out.println("Enter your account number :-");
        String accountno=sc.next();

        System.out.println("Enter your password :-");
        String password=sc.next();

        System.out.println("Enter your first balance do you want to add your account :-");
        int firstamount= sc.nextInt();

        BankingAppInterface banckingobj;
        System.out.println("Please enter which account you open Kotak or BOI :-");

        String accountName=sc.next();
        if(accountName.equals("Kotak")){
            banckingobj=new KotakBank(name,accountno,password,firstamount);
        }
        else if(accountName.equals("BOI")){
            banckingobj=new BOIBank(name,accountno,password,firstamount);
        }
        else{
            return;
        }
        System.out.println("after getting your account balance first enter your password:-");
        String pin=sc.next();
        if(!pin.equals(password)){
            System.out.println("Your password is wrong!!");
            return;
        }
        int currentbalance=banckingobj.fetchBalance(pin);
        System.out.println(currentbalance);

        if(!accountName.equals("Kotak") && currentbalance<1000){
            return;
        }

        System.out.println("how much money do you want to add in your account :-");
        int money=sc.nextInt();
        System.out.println(banckingobj.addMoney(pin,money));

        System.out.println("How much money do you want to widthdraw :-");
        int withdrawMoney= sc.nextInt();

        System.out.println(banckingobj.withdrawMoney(pin,withdrawMoney));

        System.out.println("Enter years :- ");
        int years=sc.nextInt();

        System.out.println(banckingobj.rateOfInterest(years));
    }
}