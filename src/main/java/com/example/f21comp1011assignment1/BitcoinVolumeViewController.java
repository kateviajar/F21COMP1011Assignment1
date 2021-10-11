package com.example.f21comp1011assignment1;

import Utilities.DBUtility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
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

    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //get data from DB
        barChart.getData().addAll(DBUtility.getAvgVolumeByYear());
        barChart.setLegendVisible(false);

        yearAxis.setLabel("Year");
        volumeAxis.setLabel("Average Volume");

    }

    /**
     * Create method to switch view to table view
     */
    public void switchToTableView(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("bitcoin_Table_view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Bitcoin");
        stage.show();
    }
}

