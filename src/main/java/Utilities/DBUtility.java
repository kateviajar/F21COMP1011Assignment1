package Utilities;

import com.example.f21comp1011assignment1.Bitcoin;
import javafx.scene.chart.XYChart;

import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class DBUtility {
    //Store SQL username, password and connectURL (I'm using MAMP, the port:8889)
    private static String user = "student";
    private static String pw="student";
    private static String connectURL = "jdbc:mysql://localhost:8889/javaProjects";

    /**
     * This method returns a list of Bitcoin objects
     * for displaying monthly average price and volume from 2014-2021
     */
    public static ArrayList<Bitcoin> getBitcoinDetails(){
        ArrayList<Bitcoin> bitcoins = new ArrayList<>();

        String sql = "Select Year(dateBTC) AS 'Year', Month(dateBTC) AS 'Month', AVG(openPrice) AS 'AVG Open', AVG(highPrice) AS 'AVG High', \n" +
                "AVG(lowPrice) AS 'AVG Low', AVG(closePrice) AS 'AVG Close', AVG(adjClosePrice) AS 'AVG Adj Close', AVG(volume)/1000000 AS 'AVG Volume(M)' From bitcoin\n" +
                "GROUP BY Year(dateBTC), Month(dateBTC)\n" +
                "ORDER BY Year(dateBTC) DESC, Month(dateBTC) DESC;";

        try(
                Connection conn = DriverManager.getConnection(connectURL, user, pw);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                ){
            while (resultSet.next()){
                // set formatter for double values
                DecimalFormat decimalFormat = new DecimalFormat("#.####");

                //int id = resultSet.getInt("id");
                int year = resultSet.getInt("Year");
                int month = resultSet.getInt("Month");
                //Date dateBTC = resultSet.getDate("dateBC");
                double openPrice = Double.parseDouble(decimalFormat.format(resultSet.getDouble("AVG Open")));
                double highPrice = Double.parseDouble(decimalFormat.format(resultSet.getDouble("AVG High")));
                double lowPrice = Double.parseDouble(decimalFormat.format(resultSet.getDouble("AVG Low")));
                double closePrice = Double.parseDouble(decimalFormat.format(resultSet.getDouble("AVG Close")));
                double adjClosePrice = resultSet.getDouble("AVG Adj Close");
                double volume = Double.parseDouble(decimalFormat.format(resultSet.getDouble("AVG Volume(M)")));

                // instantiate a bitcoin object (skip the dateBTC, the table view is going to display monthly data)
                Bitcoin bitcoin = new Bitcoin(openPrice, highPrice, lowPrice, closePrice, adjClosePrice, volume);

                bitcoin.setYear(year);
                bitcoin.setMonth(month);

                //add bitcoin object to the ArrayList
                bitcoins.add(bitcoin);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return bitcoins;
    }

    /**
     * This method collects volume data from DB and return as XYChart.Series<String, Double> type data
     * Use data to create a bar chart for displaying yearly average volume
     */
    public static XYChart.Series<String, Double> getAvgVolumeByYear(){
        XYChart.Series<String, Double> avgVolumeData = new XYChart.Series<>();

        //add SQL query
        String sql = "Select Year(dateBTC) AS 'Year', AVG(volume)/1000000 AS 'AVG Volume(M)' \n" +
                "From bitcoin\n" +
                "GROUP BY Year(dateBTC)\n" +
                "ORDER BY Year(dateBTC);";

        try(
                Connection conn = DriverManager.getConnection(connectURL, user, pw);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ){
            while (resultSet.next()){
                // set formatter for double values
                DecimalFormat decimalFormat = new DecimalFormat("#.####");

                String year = resultSet.getString("Year");
                double volume = Double.parseDouble(decimalFormat.format(resultSet.getDouble("AVG Volume(M)")));

                avgVolumeData.getData().add(new XYChart.Data<>(year, volume));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return avgVolumeData;
    }


    /**
     * This method collects average open price data from DB and return as XYChart.Series<String, Double> type data
     * Use data to create a line chart (it will dynamically change based on what "year" condition passed to query)
     * Users will use radioButton to display data of the year they chose
     */
    public static XYChart.Series<String, Double> getAvgOpenPriceByMonth(String year){
        XYChart.Series<String, Double> avgOpenPriceData = new XYChart.Series<>();

        //add SQL query
        String sql = "Select Year(dateBTC), Month(dateBTC) AS 'Month', AVG(openPrice) AS 'AVG Open', \n" +
                "AVG(closePrice) AS 'AVG Close' From bitcoin\n" +
                "WHERE Year(dateBTC) = ? \n" +
                "GROUP BY Year(dateBTC), Month(dateBTC)\n" +
                "ORDER BY Year(dateBTC), Month(dateBTC);";

        try(
                Connection conn = DriverManager.getConnection(connectURL, user, pw);
                PreparedStatement ps = conn.prepareStatement(sql);
        ){
            //set the parameter
            ps.setString(1, year);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()){
                // set formatter for double values
                DecimalFormat decimalFormat = new DecimalFormat("#.####");

                String month = resultSet.getString("Month");
                double openPrice = Double.parseDouble(decimalFormat.format(resultSet.getDouble("AVG Open")));

                avgOpenPriceData.getData().add(new XYChart.Data<>(month, openPrice));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return  avgOpenPriceData;
    }


    /**
     * This method collects average close price data from DB and return as XYChart.Series<String, Double> type data
     * Use data to create a line chart (it will dynamically change based on what "year" condition passed to query)
     * Users will use radioButton to display data of the year they chose
     */
    public static XYChart.Series<String, Double> getAvgClosePriceByMonth(String year){
        XYChart.Series<String, Double> avgClosePriceData = new XYChart.Series<>();

        //add SQL query
        String sql = "Select Year(dateBTC), Month(dateBTC) AS 'Month', AVG(openPrice) AS 'AVG Open', \n" +
                "AVG(closePrice) AS 'AVG Close' From bitcoin\n" +
                "WHERE Year(dateBTC) = ? \n" +
                "GROUP BY Year(dateBTC), Month(dateBTC)\n" +
                "ORDER BY Year(dateBTC), Month(dateBTC);";

        try(
                Connection conn = DriverManager.getConnection(connectURL, user, pw);
                PreparedStatement ps = conn.prepareStatement(sql);
        ){
            //set the parameter
            ps.setString(1, year);

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()){
                // set formatter for double values
                DecimalFormat decimalFormat = new DecimalFormat("#.####");

                String month = resultSet.getString("Month");
                double closePrice = Double.parseDouble(decimalFormat.format(resultSet.getDouble("AVG Close")));

                avgClosePriceData.getData().add(new XYChart.Data<>(month, closePrice));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return  avgClosePriceData;
    }
}
