package com.example.f21comp1011assignment1;

import Utilities.DBUtility;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class BitcoinTableViewController implements Initializable {

    @FXML
    private TableView<Bitcoin> tableView;

    @FXML
    private TableColumn<Bitcoin, Integer> yearColumn;

    @FXML
    private TableColumn<Bitcoin, Integer> monthColumn;

    @FXML
    private TableColumn<Bitcoin, Double> avgOpenColumn;

    @FXML
    private TableColumn<Bitcoin, Double> avgHighColumn;

    @FXML
    private TableColumn<Bitcoin, Double> avgLowColumn;

    @FXML
    private TableColumn<Bitcoin, Double> avgCloseColumn;

    @FXML
    private TableColumn<Bitcoin, Double> avgVolumeColumn;

    @FXML
    private Button priceChartButton;

    @FXML
    private Button volumeChartButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //configure the table columns to get the correct information from the Model
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        monthColumn.setCellValueFactory(new PropertyValueFactory<>("month"));
        avgOpenColumn.setCellValueFactory(new PropertyValueFactory<>("openPrice"));
        avgHighColumn.setCellValueFactory(new PropertyValueFactory<>("highPrice"));
        avgLowColumn.setCellValueFactory(new PropertyValueFactory<>("lowPrice"));
        avgCloseColumn.setCellValueFactory(new PropertyValueFactory<>("closePrice"));
        avgVolumeColumn.setCellValueFactory(new PropertyValueFactory<>("volume"));

        //populate columns to table view
        tableView.getItems().addAll(DBUtility.getBitcoinDetails());
    }
}

