# JavaFX Project - BTC-USD Price Chart View (Assignment 1)

## Project Introduction
This project uses the Bitcoin (BTC-USD) data to create two charts, line chart and bar chart.    
The application will read data from MySQL DB.

### Note:
**I use MAMP to connect MySQL, the port number is 8889**.   
In **DBUtility**, the ***connectURL = "jdbc:mysql://localhost:8889/javaProjects"***;  

## Application Structures
It consists of 3 views, Bitcoin table view, Bitcoin price line chart, and Bitcoin volume bar chart.

### Bitcoin table view
It is the start view of the application to show all the data in the table.  
There are two buttons on the bottom that users can choose to see the price chart or volume chart.    
<img width="500" alt="app1" src="https://user-images.githubusercontent.com/78240130/147860160-2239a7be-1d43-4517-a65c-2d646635fdca.png">

### Bitcoin price line chart
In this view, the line chart pre-loads the 2021 bitcoin price data.  
It has two lines of monthly average open price and monthly average close price.  
Users can choose different year's data by selecting the radio button on the right side.  
The price line chart will change dynamically based on the year selected.   
<img width="500" alt="app2" src="https://user-images.githubusercontent.com/78240130/147860173-64a5c8bf-e4fe-46a3-8dcc-6a7a94bca4db.png">

### Bitcoin volume bar chart
This bar chart shows the average trading volume by year.   
<img width="500" alt="app3" src="https://user-images.githubusercontent.com/78240130/147860181-3b8007dc-b5ef-428f-9c6a-f997ac54e8a6.png">

## Data Source
This data is from [kaggle Bitcoin data](https://www.kaggle.com/varpit94/bitcoin-data-updated-till-26jun2021).  
The **BTC-USD.csv** file includes 7 columns. They are:
- **Date**: Trading day
- **Open**: Price from the first transaction of a trading day
- **High**: Maximum price in a trading day
- **Low**: Minimum price in a trading day
- **Close**: Price from the last transaction of a trading day
- **Adj Close**: Closing price adjusted to reflect the value after accounting for any corporate actions
- **Volume**: Number of units traded in a day

## Read from the csv file and write INSERT query into a file
1. Create ***SQLGenerator class*** to read the **BTC-USD.csv** file and format the insert query
2. Each line of csv file is formatted and written into **SQLInserts.sql**
3. All the SQL queries are in the **SQLBitcoin.sql** including CREATE TABLE query

