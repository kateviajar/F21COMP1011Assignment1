# JavaFX Project - BTC-USD Price Chart View (Assignment 1)

## Project Introduction
This project uses the Bitcoin (BTC-USD) data to create two charts, line chart and bar chart.  
The application will read data from MySQL DB.

## Application Structures
It consists of 3 views, Bitcoin table view, Bitcoin price line chart, and Bitcoin volume bar chart.

### Bitcoin table view
It is the start view of the application to show all the data in the table.  
There are two buttons on the bottom that users can choose to see the price chart or volume chart.

### Bitcoin price line chart
In this view, the line chart pre-loads the 2021 bitcoin price data.  
It has two lines of monthly average open price and monthly average close price.  
Users can choose different year's data by selecting the radio button on the right side.  
The price line chart will change dynamically based on the year selected.

### Bitcoin volume bar chart
This bar chart shows the average trading volume by year.

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

