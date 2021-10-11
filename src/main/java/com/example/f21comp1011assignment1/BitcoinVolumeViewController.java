package com.example.f21comp1011assignment1;

import Utilities.DBUtility;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class BitcoinVolumeViewController implements Initializable {

    @FXML
    private Button backButton;

    @FXML
    private BarChart<String, Double> barChart;

    @FXML
    private CategoryAxis yearAxis;

    @FXML
    private NumberAxis volumeAxis;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //get data from DB
        barChart.getData().addAll(DBUtility.getAvgVolumeByYear());
        barChart.setLegendVisible(false);

        yearAxis.setLabel("Year");
        volumeAxis.setLabel("Average Volume");

    }
}

