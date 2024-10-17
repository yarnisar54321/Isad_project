public class ControlStock{
    public abstract boolean verifyLogin(String username, String password);
    public abstract boolean adjustStock(StockItem stockItem);
    public abstract boolean addStock(StockItem stockItem);
    public abstract boolean recordStockTransaction(Transaction transaction);
    
    public abstract boolean handleLogin(String username, String password);
    public  abstract void handleAddProduct(Product product);
    public abstract void handleUpdateProduct(int productID, Product newProductData);
    public abstract void handleDeleteProduct(int productID);
    public abstract Product handleProductListRequest();
}