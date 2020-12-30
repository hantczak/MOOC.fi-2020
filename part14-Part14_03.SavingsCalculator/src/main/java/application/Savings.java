package application;

import java.util.ArrayList;

public class Savings {
    private double monthlySavings;
    private double yearlyInterestRate;

    public Savings(double monthlySavings, double yearlyInterestRate) {
        this.monthlySavings = monthlySavings;
        this.yearlyInterestRate = yearlyInterestRate / 100;
    }

    public ArrayList<Double[]> calculateGraphValuesWithoutInterest() {
        ArrayList<Double[]> pointList = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            Double[] point = {i * 1.0, i * 12 * monthlySavings};
            pointList.add(point);
        }
        return pointList;
    }

    public ArrayList<Double[]> calculateGraphValuesWithInterest() {
        ArrayList<Double[]> pointList = new ArrayList<>();
        double lastYearTotalSavings = 0;
        double endOfNextYearTotalSavings;
        double flatYearSavings = 12 * monthlySavings;
        for (int i = 1; i <= 30; i++) {
            endOfNextYearTotalSavings = flatYearSavings + (lastYearTotalSavings + flatYearSavings) * yearlyInterestRate + lastYearTotalSavings;
            Double[] point = {i * 1.0, endOfNextYearTotalSavings};
            pointList.add(point);
            lastYearTotalSavings = endOfNextYearTotalSavings;
        }
        return pointList;
    }

    public void setMonthlySavings(double value) {
        this.monthlySavings = value;
    }

    public void setYearlyInterestRate(double value) {
        this.yearlyInterestRate = value/100;
    }
}
