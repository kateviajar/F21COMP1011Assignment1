package Utilities;

import java.io.*;
import java.util.ArrayList;
import java.util.Formatter;

public class SQLGenerator {
    /**
     * This method will read the data from csv file, then convert each line to a String array
     * Store all String arrays in the ArrayList
     */

    public static ArrayList<String[]> readCSV(){
        ArrayList<String[]> records = new ArrayList<>();

        try (
                // use BufferedReader to read the file
                BufferedReader bufferedReader = new BufferedReader(new FileReader("BTC-USD.csv"));
        ) {
            //create a String variable called line to store each line from the file
            String line;
            while ((line = bufferedReader.readLine()) != null){
                //use split method to convert the line into a String array
                String[] values = line.split(",");
                //store all the String array into the ArrayList
                records.add(values);
            }

        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return records;
    }

    /**
     * This method will create INSERT query and write in to a sql file
     */

    public static void createSQL(ArrayList<String[]> records){

        //remove the first element, since it's column heading
        records.remove(0);

        try(
                //Use Formatter to write into a file
                Formatter formatter = new Formatter(new File("SQLInserts.sql"));
        ) {
            // loop through the records and format the insert query
            for(String[] record : records){
                formatter.format("INSERT INTO bitcoin (dateBTC, openPrice, highPrice, lowPrice, closePrice, adjClosePrice, volume) VALUES ('%s', %s, %s, %s, %s, %s, %s);%n",
                        record[0], record[1], record[2], record[3], record[4], record[5], record[6]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        createSQL(readCSV());
    }
}
