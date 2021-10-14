package com.example.f21comp1011assignment1;

import Utilities.DBUtility;
import Utilities.SceneChanger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BitcoinPriceViewController implements Initializable {

    @FXML
    private Button backButton;

    @FXML
    private LineChart<String, Double> lineChart;

    @FXML
    private CategoryAxis monthAxis;

    @FXML
    private NumberAxis priceAxis;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //get closePrice data from DB
        XYChart.Series avgClosePrice = DBUtility.getAvgClosePriceByMonth();
        XYChart.Series avgOpenPrice = DBUtility.getAvgOpenPriceByMonth();

        //set the series data name, it will show on the legend
        avgClosePrice.setName("Avg Close Price");
        avgOpenPrice.setName("Avg Open Price");

        lineChart.getData().addAll(avgOpenPrice, avgClosePrice);

        monthAxis.setLabel("Month");
        priceAxis.setLabel("Average BTC-USD Price");
    }

    /**
     * Use SceneChanger.changeScenes() method to switch view to table view
     */
    public void switchToTableView(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "bitcoin_Table_view.fxml", "Bitcoin");
    }
}
