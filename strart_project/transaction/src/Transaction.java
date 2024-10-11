import java.util.Date;

public class Transaction {
    private int transactionID;
    private String itemName;
    private int quantity;
    private Date transactionDate;
    
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
    
    public int getTransaction(){
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
        return "none";
    }
    public static void main(String[] args) {
        
    }
    
}
