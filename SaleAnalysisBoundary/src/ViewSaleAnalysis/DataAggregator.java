package ViewSaleAnalysis;

import java.util.*;

class DataAggregator {
    private List<SalesTransaction> rawSalesData;

    public DataAggregator() {
        rawSalesData = new ArrayList<>();
        //
        // Example
        rawSalesData.add(new SalesTransaction("Product A", 3, 300.0, new Date()));  // Today
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        rawSalesData.add(new SalesTransaction("Product B", 1, 150.0, cal.getTime()));  // Yesterday
        cal.add(Calendar.DATE, -6);
        rawSalesData.add(new SalesTransaction("Product A", 2, 200.0, cal.getTime()));  // A week ago
        cal.add(Calendar.MONTH, -1);
        rawSalesData.add(new SalesTransaction("Product C", 5, 500.0, cal.getTime()));  // A month ago
    }

    public SalesSummary fetchDailySalesSummary(Date date) {
        return aggregateSalesData(new DateRange(getStartOfDay(date), getEndOfDay(date)));
    }

    public SalesSummary fetchWeeklySalesSummary(Date date) {
        return aggregateSalesData(new DateRange(getStartOfWeek(date), getEndOfWeek(date)));
    }

    public SalesSummary fetchMonthlySalesSummary(Date date) {
        return aggregateSalesData(new DateRange(getStartOfMonth(date), getEndOfMonth(date)));
    }

    private SalesSummary aggregateSalesData(DateRange range) {
        double totalRevenue = 0.0;
        int totalOrders = 0;
        Map<String, Integer> bestSellers = new HashMap<>();

        for (SalesTransaction transaction : rawSalesData) {
            if (range.isWithinRange(transaction.getTransactionDate())) {
                totalRevenue += transaction.getPrice();
                totalOrders += 1;

                bestSellers.put(transaction.getProductName(),
                        bestSellers.getOrDefault(transaction.getProductName(), 0) + transaction.getQuantity());
            }
        }

        bestSellers = sortBestSellers(bestSellers);

        return new SalesSummary(totalRevenue, totalOrders, bestSellers);
    }

    private Date getStartOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    private Date getEndOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    private Date getStartOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        return getStartOfDay(cal.getTime());
    }

    private Date getEndOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        cal.add(Calendar.DAY_OF_WEEK, 6);
        return getEndOfDay(cal.getTime());
    }

    private Date getStartOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return getStartOfDay(cal.getTime());
    }

    private Date getEndOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return getEndOfDay(cal.getTime());
    }

    private void handleDataRetrievalError() {
        System.err.println("Error retrieving sales data.");
    }

    private Map<String, Integer> sortBestSellers(Map<String, Integer> bestSellers) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(bestSellers.entrySet());
        list.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        Map<String, Integer> sortedBestSellers = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedBestSellers.put(entry.getKey(), entry.getValue());
        }
        return sortedBestSellers;
    }
}
