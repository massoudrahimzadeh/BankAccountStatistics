package com.company;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank("MS the big bank");
        User user = new User("Massoud");
        bank.register(user);
        Transaction payment = new Transaction(3000, "abc1234", " Grocary", 9, 2020);
        bank.withdraw(payment, user);


// write your code here
    }
}
// Bank
// User
//Statistic: / most expensive payments / biggest income /
//     total: spent, earn, payment for each type
//Payment: id, amount, type, month, year,
//     type: grocary, entertainment,.....
//