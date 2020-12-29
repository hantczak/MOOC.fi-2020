package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application {
    public void start(Stage window){
        NumberAxis xAxis = new NumberAxis(2006,2018,2);
        NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");

        LineChart<Number,Number> lineChart = new LineChart<>(xAxis,yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai ranking");

        XYChart.Series helsinkiRanking = new XYChart.Series();
        helsinkiRanking.setName("Helsinki");

        helsinkiRanking.getData().add(new XYChart.Data(2007,73));
        helsinkiRanking.getData().add(new XYChart.Data(2008,68));
        helsinkiRanking.getData().add(new XYChart.Data(2009,72));
        helsinkiRanking.getData().add(new XYChart.Data(2010,72));
        helsinkiRanking.getData().add(new XYChart.Data(2011,74));
        helsinkiRanking.getData().add(new XYChart.Data(2012,73));
        helsinkiRanking.getData().add(new XYChart.Data(2013,76));
        helsinkiRanking.getData().add(new XYChart.Data(2014,73));
        helsinkiRanking.getData().add(new XYChart.Data(2015,67));
        helsinkiRanking.getData().add(new XYChart.Data(2016,56));
        helsinkiRanking.getData().add(new XYChart.Data(2017,56));

        lineChart.getData().add(helsinkiRanking);
        Scene view = new Scene(lineChart,640,480);
        window.setScene(view);
        window.show();
        }


    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
    }

}
