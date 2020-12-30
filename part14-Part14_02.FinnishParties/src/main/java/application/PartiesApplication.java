package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PartiesApplication extends Application {
    public void start(Stage window) {
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis();

        xAxis.setLabel("Years");
        yAxis.setLabel("Relative support");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");

        List<String> rows = new ArrayList<>();

        try {
            Files.lines(Paths.get("partiesdata.tsv")).forEach(row -> rows.add(row));
        } catch (Exception e) {
            System.out.println("Error while reading a file.");
        }
        String[] graphInfo = rows.get(0).split("\t");
        rows.remove(0);


        rows.forEach(row -> {
            XYChart.Series data = new XYChart.Series();
            String[] parts = row.split("\t");
            data.setName(parts[0]);
            for (int i = 1; i < graphInfo.length; i++) {
                if (!parts[i].equals("-")) {
                    data.getData().add(new XYChart.Data(Integer.valueOf(graphInfo[i]), Double.valueOf(parts[i])));
                }
            }
            lineChart.getData().add(data);
        });

        Scene view = new Scene(lineChart, 640, 480);
        window.setScene(view);
        window.show();


        for (String row : rows) {
            System.out.println(row);
        }
        System.out.println(rows.size());
    }

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }
}
