package com.company;

import java.util.*;

public class Bank{
    final static Scanner sc = new Scanner(System.in);
    public Bank(String name) {
        this.name = name;
    }

    final String name;
    final Set<User> users=new HashSet<>();
    final Map<User, Set<Transaction>> transactionsMap = new HashMap<>();


    public void register(User user) {
        users.add(user);
    }

    public void withdraw(Transaction payment, User user) {
        transactionsMap.get(user).add(payment);
    }
    public  void getStatistics(User user){
        System.out.println("> Enter what statistics you want to see: \n" +
                "1 - My biggest payment\n" +
                "2 - My highest income\n" +
                "3 - My total income\n" +
                "4 - My total spent\n" +
                "5 - How do I spend my money\n" +
                "0 - exit");
        int choose= sc.nextInt();
        switch (choose){
            case 1:
                highestPayment(user);
                break;
            case 2:
                highestIncome(user);
                break;
            case 3:
                totalIncome(user);
                break;
            case 4:
                totalSpent(user);
                break;
            case 5:
                paymentForEachType(user);
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid entry");
                break;
        }
    }
    public  Transaction highestPayment(User user){

        HashMap<Double, Transaction> transactionsMapWithAmountAsKey = new HashMap<>();
        for(Transaction tr:transactionsMap.get(user)){
            Double value =tr.amount;
            if(value<0){
                transactionsMapWithAmountAsKey.put(value, tr);
            }
        }
        Set<Double> valueKeys = transactionsMapWithAmountAsKey.keySet();
        Double minValue = Collections.min(valueKeys);
        return transactionsMapWithAmountAsKey.get(minValue);
    }
    public  Transaction highestIncome(User user){

        HashMap<Double, Transaction> transactionsMapWithAmountAsKey = new HashMap<>();
        for(Transaction tr:transactionsMap.get(user)){
            Double value =tr.amount;
            if(value>=0){
                transactionsMapWithAmountAsKey.put(value, tr);
            }
        }
        Set<Double> valueKeys = transactionsMapWithAmountAsKey.keySet();
        Double maxValue = Collections.max(valueKeys);
        return transactionsMapWithAmountAsKey.get(maxValue);
    }
    public  double totalIncome(User user){
        double totalEarn = 0;
        for(Transaction tr:transactionsMap.get(user)){
            if(tr.amount >=0){
                totalEarn +=tr.amount;
            }
        }
        return totalEarn;
    }
    public  double totalSpent(User user){
        double totalSpent = 0;
        for(Transaction tr:transactionsMap.get(user)){
            totalSpent +=tr.amount;
            if(tr.amount < 0){
                totalSpent +=tr.amount;
            }
        }
        return totalSpent;
    }
    public  HashMap<String, Double> paymentForEachType(User user){
        HashMap<String, Double> mapOfPaymentsOfDifferentTypes = new HashMap<>();
        double value = 0;
        for(Transaction tr1: transactionsMap.get(user)){
            value = tr1.amount;
            for (Transaction tr2:transactionsMap.get(user)){
                if(!tr2.equals(tr1) && tr1.paymentType == tr2.paymentType){
                    value+=tr2.amount;
                }
            }
            mapOfPaymentsOfDifferentTypes.put(tr1.paymentType, value);
        }
        return mapOfPaymentsOfDifferentTypes;
    }

    public  HashMap<String, Double> paymentsEachMonth(User user){
        HashMap<String, Double> mapOfPaymentsOfDifferentMonth = new HashMap<>();
        double value = 0;
        for(Transaction tr1: transactionsMap.get(user)){
            value = tr1.amount;
            for (Transaction tr2:transactionsMap.get(user)){
                if(!tr2.equals(tr1) && tr1.year == tr2.year && tr1.month == tr2.month){
                    value+=tr2.amount;
                }
            }
            mapOfPaymentsOfDifferentMonth.put(tr1.month, value);
        }
        return mapOfPaymentsOfDifferentMonth;
    }
}
