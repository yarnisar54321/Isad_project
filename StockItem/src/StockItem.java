



public class StockItem {

    private int stockQuantity;
    private double stockPrice;
    
    public StockItem(int stockQuantity, double stockPrice){
        this.stockQuantity = stockQuantity;
        this.stockPrice = stockPrice;
    }
    
    public int getStockQuantity(){
        return stockQuantity;
    }
    
    public void setStockQuantity(int stockQuantity){
        this.stockQuantity = stockQuantity;
    }
    
    public double getStockPrice(){
        return stockPrice;
    }
    
    public void setStockPrice() {
        this.stockPrice = stockPrice;
    }
    
}
