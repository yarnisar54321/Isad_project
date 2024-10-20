package ViewSaleAnalysis;
import java.util.*;
class SalesTransaction {
    private String productName;
    private int quantity;
    private double price;
    private Date transactionDate;

    public SalesTransaction(String productName, int quantity, double price, Date transactionDate) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.transactionDate = transactionDate;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }
}