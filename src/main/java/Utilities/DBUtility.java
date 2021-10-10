package Utilities;

import com.example.f21comp1011assignment1.Bitcoin;

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
}
