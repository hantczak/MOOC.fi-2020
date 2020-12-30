package application;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ProgramLayout {
    private double firstSliderValue = 25;
    private double secondSliderValue = 0;
    private LineChart<Number, Number> lineChart;
    private Savings savings = new Savings(firstSliderValue, secondSliderValue);

    public double getFirstSliderValue() {
        return firstSliderValue;
    }

    public double getSecondSliderValue() {
        return secondSliderValue;
    }

    public VBox createSliders() {
        BorderPane firstSliderLayout = new BorderPane();
        BorderPane secondSliderLayout = new BorderPane();

        Label firstSliderLabel = new Label("Monthly savings");
        Label secondSliderLabel = new Label("Yearly interest rate");

        VBox slidersLayout = new VBox();

        Slider monthlySavingsSlider = new Slider();
        monthlySavingsSlider.setShowTickLabels(true);
        monthlySavingsSlider.setShowTickMarks(true);
        monthlySavingsSlider.setMajorTickUnit(25);
        monthlySavingsSlider.setMin(25);
        monthlySavingsSlider.setMax(250);
        monthlySavingsSlider.setMinorTickCount(4);
        monthlySavingsSlider.setSnapToTicks(true);
        firstSliderLayout.setLeft(firstSliderLabel);
        firstSliderLayout.setCenter(monthlySavingsSlider);
        Label firstSliderValueLabel = new Label("25");
        monthlySavingsSlider.setOnMouseReleased(mouseEvent -> {
            firstSliderValueLabel.setText(Double.toString(monthlySavingsSlider.getValue()));
            this.firstSliderValue = monthlySavingsSlider.getValue();
            savings.setMonthlySavings(monthlySavingsSlider.getValue());
            updateGraph();
        });
        firstSliderLayout.setRight(firstSliderValueLabel);

        Slider yearlyInterestRateSlider = new Slider();
        yearlyInterestRateSlider.setShowTickLabels(true);
        yearlyInterestRateSlider.setShowTickMarks(true);
        yearlyInterestRateSlider.setMajorTickUnit(10);
        yearlyInterestRateSlider.setMin(0);
        yearlyInterestRateSlider.setMax(10);
        yearlyInterestRateSlider.setSnapToTicks(true);
        secondSliderLayout.setLeft(secondSliderLabel);
        secondSliderLayout.setCenter(yearlyInterestRateSlider);
        Label secondSliderValueLabel = new Label("0");
        yearlyInterestRateSlider.setOnMouseReleased(mouseEvent -> {
            secondSliderValueLabel.setText(Double.toString(yearlyInterestRateSlider.getValue()));
            this.secondSliderValue = yearlyInterestRateSlider.getValue();
            savings.setYearlyInterestRate(yearlyInterestRateSlider.getValue());
            updateGraph();
        });
        secondSliderLayout.setRight(secondSliderValueLabel);

        slidersLayout.getChildren().add(firstSliderLayout);
        slidersLayout.getChildren().add(secondSliderLayout);

        return slidersLayout;
    }

    public LineChart createGraph() {
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("Years");
        yAxis.setLabel("Saved money");

        lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings");

        XYChart.Series savingsGraph = new XYChart.Series();
        savingsGraph.setName("Savings");
        updateGraph();
        return lineChart;
    }

    public void updateGraph() {
        lineChart.getData().clear();
        XYChart.Series noInterestSavingsGraph = new XYChart.Series();
        noInterestSavingsGraph.setName("Savings without interest included");

        ArrayList<Double[]> savingsPoints = savings.calculateGraphValuesWithoutInterest();
        savingsPoints.forEach(row -> {
            noInterestSavingsGraph.getData().add(new XYChart.Data(row[0], row[1]));
        });
        lineChart.getData().add(noInterestSavingsGraph);


        XYChart.Series savingsWithInterestGraph = new XYChart.Series();
        savingsWithInterestGraph.setName("Savings with interest included");

        ArrayList<Double[]> savingsWithInterestPoints = savings.calculateGraphValuesWithInterest();
        savingsWithInterestPoints.forEach(row -> {
            savingsWithInterestGraph.getData().add(new XYChart.Data(row[0], row[1]));
        });
        lineChart.getData().add(savingsWithInterestGraph);
    }
}

