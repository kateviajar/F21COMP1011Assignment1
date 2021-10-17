package com.example.f21comp1011assignment1;

import Utilities.DBUtility;
import Utilities.SceneChanger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
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

    @FXML
    private RadioButton radioButton14;

    @FXML
    private RadioButton radioButton15;

    @FXML
    private RadioButton radioButton16;

    @FXML
    private RadioButton radioButton17;

    @FXML
    private RadioButton radioButton18;

    @FXML
    private RadioButton radioButton19;

    @FXML
    private RadioButton radioButton20;

    @FXML
    private RadioButton radioButton21;

    @FXML
    private ToggleGroup toggleGroup;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //pre-select the year 2021 radioButton
        radioButton21.setSelected(true);

        //set categories of categoryAxis (axis auto-range issue - tick marks are not placed well)
        ArrayList<String> monthCategories = new ArrayList<>();
        for (int i = 1; i <= 12 ; i++) {
            monthCategories.add(Integer.toString(i));
        }
        monthAxis.setCategories(FXCollections.observableArrayList(monthCategories));

        //get closePrice data from DB
        XYChart.Series avgClosePrice = DBUtility.getAvgClosePriceByMonth(radioButton21.getText());
        XYChart.Series avgOpenPrice = DBUtility.getAvgOpenPriceByMonth(radioButton21.getText());

        //set the series data name, it will show on the legend
        avgClosePrice.setName("Avg Close Price");
        avgOpenPrice.setName("Avg Open Price");

        lineChart.getData().addAll(avgOpenPrice, avgClosePrice);

        monthAxis.setLabel("Month of 2021");
        priceAxis.setLabel("Average BTC-USD Price");
    }

    /**
     * This method checks which radioButton is selected and displayed the chart based on the selected radioButton
     */
    @FXML
    private void changePriceChartByYear(){
        lineChart.getData().clear(); // clear the line chart first

        String year = new String();
        ArrayList<RadioButton> radioButtons = new ArrayList<>();
        radioButtons.addAll(Arrays.asList(radioButton14, radioButton15, radioButton16, radioButton17,
                radioButton18, radioButton19, radioButton20, radioButton21));

        //check which radioButton is selected
        for (RadioButton radioButton : radioButtons){
            if (radioButton.isSelected()){
                year = radioButton.getText();
            }
        }

        monthAxis.setLabel("Month of "+year);

        //get closePrice data from DB
        XYChart.Series avgClosePrice = DBUtility.getAvgClosePriceByMonth(year);
        XYChart.Series avgOpenPrice = DBUtility.getAvgOpenPriceByMonth(year);

        //set the series data name, it will show on the legend
        avgClosePrice.setName("Avg Close Price");
        avgOpenPrice.setName("Avg Open Price");

        lineChart.getData().addAll(avgOpenPrice, avgClosePrice);
    }


    /**
     * Use SceneChanger.changeScenes() method to switch view to table view
     */
    @FXML
    private void switchToTableView(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event, "bitcoin_Table_view.fxml", "Bitcoin");
    }
}
