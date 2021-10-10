# JavaFX Project - BTC-USD Price Chart View (Assignment 1)

## Project Introduction
This project uses the Bitcoin (BTC-USD) data to create two charts, line chart and bar chart.  
The application will read data from MySQL DB.

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

