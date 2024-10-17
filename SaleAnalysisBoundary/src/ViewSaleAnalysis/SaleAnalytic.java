package ViewSaleAnalysis;

public class SaleAnalytic {
    private float dailySum, weeklySum, monthlySum, dailyOrderNum, weeklyOrderNum, monthlyOrderNum;
    public SaleAnalytic(float dailySum, float weeklySum, float monthlySum, float dailyOrderNum, float weeklyOrderNum, float monthlyOrderNum) {
        this.dailySum = dailySum;
        this.weeklySum = weeklySum;
        this.monthlySum = monthlySum;
        this.dailyOrderNum = dailyOrderNum;
        this.weeklyOrderNum = weeklyOrderNum;
        this.monthlyOrderNum = monthlyOrderNum;
    }
    public SaleAnalytic() {
        this.dailySum = 0;
        this.weeklySum = 0;
        this.monthlySum = 0;
        this.dailyOrderNum = 0;
        this.weeklyOrderNum = 0;
        this.monthlyOrderNum = 0;
    }
    public float getDailySum() {
        return dailySum;
    }

    public void setDailySum(float dailySum) {
        this.dailySum = dailySum;
    }

    public float getWeeklySum() {
        return weeklySum;
    }

    public void setWeeklySum(float weeklySum) {
        this.weeklySum = weeklySum;
    }

    public float getMonthlySum() {
        return monthlySum;
    }

    public void setMonthlySum(float monthlySum) {
        this.monthlySum = monthlySum;
    }

    public float getDailyOrderNum() {
        return dailyOrderNum;
    }

    public void setDailyOrderNum(float dailyOrderNum) {
        this.dailyOrderNum = dailyOrderNum;
    }

    public float getWeeklyOrderNum() {
        return weeklyOrderNum;
    }

    public void setWeeklyOrderNum(float weeklyOrderNum) {
        this.weeklyOrderNum = weeklyOrderNum;
    }

    public float getMonthlyOrderNum() {
        return monthlyOrderNum;
    }

    public void setMonthlyOrderNum(float monthlyOrderNum) {
        this.monthlyOrderNum = monthlyOrderNum;
    }
}
