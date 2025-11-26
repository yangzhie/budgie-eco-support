package org.yangzhie.budgieEcoSupport.loggers;

public class TransactionRecord {
    public String buyer;
    public int amount;
    public String item;
    public double earned;
    public double tax;
    public long timestamp;

    public TransactionRecord(String buyer, int amount, String item, double earned, double tax, long timestamp) {
        this.buyer = buyer;
        this.amount = amount;
        this.item = item;
        this.earned = earned;
        this.tax = tax;
        this.timestamp = timestamp;
    }
}
