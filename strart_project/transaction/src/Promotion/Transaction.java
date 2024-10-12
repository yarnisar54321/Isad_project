import java.util.Date;

public class Transaction {
    private int transactionID;
    private String itemName;
    private int quantity;
    private Date transactionDate;
    private String transactionDetails;
    
    public void setTransactionID(int transactionID){
        this.transactionID = transactionID;
    }
    
    public void setItemName(String itemName){
        this.itemName = itemName;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
    public void setTransactionDate(Date transactionDate){
        this.transactionDate = transactionDate;
    }
    
    public int getTransactionID(){
        return this.transactionID;
    }
    
    public String getItemName(){
        return this.itemName;
    }
    
    public int getQuantity(){
        return this.quantity;
    }
    
    public Date getTransactionDate(){
        return this.transactionDate;
    }
    
    public String getTransactionDetails(){
        transactionDetails = String.format("ID: %s, itemName: %s, quantity: %s, Date: %s", getTransactionID(), getItemName(), getQuantity(), getTransactionDate());
        return transactionDetails;
    }
    public static void main(String[] args) {
        
    }
    
}
