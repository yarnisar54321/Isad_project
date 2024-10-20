package ViewSaleAnalysis;

import java.util.*;

class SalesSummary {
    private double revenue;  //Daily/Weekly/Monthly revenue
    private int orders;  //Daily/Weekly/Monthly orders
    private Map<String, Integer> bestSellers;  //products with quantities sold

    public SalesSummary(double revenue, int orders, Map<String, Integer> bestSellers) {
        this.revenue = revenue;
        this.orders = orders;
        this.bestSellers = bestSellers;
    }

    public double getRevenue() {
        return revenue;
    }

    public int getOrders() {
        return orders;
    }

    public Map<String, Integer> getBestSellers() {
        return bestSellers;
    }
}