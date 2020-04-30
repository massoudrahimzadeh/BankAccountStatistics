package com.company;

import java.util.Objects;

public class Transaction {
    final double amount;
    final String id;
    final String paymentType;
    final String month;
    final int year;

    public Transaction(double amount, String id, String paymentType, String month, int year) {
        this.amount = amount;
        this.id = id;
        this.paymentType = paymentType;
        this.month = month;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.amount, amount) == 0 &&
                month == that.month &&
                year == that.year &&
                id.equals(that.id) &&
                paymentType.equals(that.paymentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, id, paymentType, month, year);
    }
}
