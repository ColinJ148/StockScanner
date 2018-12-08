package sample;

import java.net.URLConnection;

import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * StockQuote class pulls HTML off of Yahoo Finance and searches though it to find Stock prices,
 * changes in price thought out the day as well as stock closing price history.
 */
class StockQuote {

  private String day;
  private String content;
  private String ticker;
  private String historyContent;
  private double[] priceHistory = new double[50];
  private String[] months = {null, "Jan", "Feb", "Mar", "Apr", "May",
      "Jun", "Jul", "Aug", "Sep", "Oct",
      "Nov", "Dec"};

  /**
   * Constructor tasks in ticker symbol as a parameter and pulls the html from yahoo finance and
   * sets it to a string (content).
   *
   * @param ticker stock ticker symbol ie "AMD SNAP EA ...."
   */
  public StockQuote(String ticker) {
    this.ticker = ticker;
    String content = null;
    URLConnection connection;
    try {
      connection = new URL("https://finance.yahoo.com/quote/" + ticker).openConnection();
      Scanner scanner = new Scanner(connection.getInputStream());
      scanner.useDelimiter("\\Z");
      content = scanner.next();
      this.content = content;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    getPriceHistory();
  }

  /**
   * getPrice searches though the html saved in content to find the current price of the stock of
   * interest.
   *
   * @return price of the stock with respect to ticker
   */
  public String getPrice() {
    String price;
    String snipit;

    int index = content.indexOf("regularMarketVolume") - 4;
    snipit = content.substring(index - 7, index);
    for (int i = 0; i < snipit.length(); i++) {             //Go though string and removes
      snipit = snipit.replaceAll("[:]", "");//but price numbers and the . between them
      snipit = snipit.replaceAll("^\"|\"$", "");
    }
    price = snipit;
    return price;
  }

  /**
   * getPriceChange searches though the html saved in content to find the current price change of
   * the stock of interest.
   *
   * @return price change of stock with respect to ticker.
   */
  public String getPriceChange() {
    String priceChange;
    String snipit;
    int index = content.indexOf("fullExchangeName") - 4;
    snipit = content.substring(index - 7, index);
    for (int i = 0; i < snipit.length(); i++) {
      snipit = snipit.replaceAll("[:]", "");
      snipit = snipit.replaceAll("^\"|\"$", "");
    }
    priceChange = snipit;
    return priceChange;
  }

  /**
   * getPriceHistory gets the html from a different page on yahoo finance which has all of the
   * closing prices of the stock of interest.
   *
   * @return array of the last 50 days of closing prices.
   */
  public double[] getPriceHistory() {
    URLConnection connection;
    try {
      connection = new URL("https://finance.yahoo.com/quote/" + ticker + "/history?p=" + ticker)
          .openConnection();
      Scanner scanner = new Scanner(connection.getInputStream());
      scanner.useDelimiter("\\Z");
      historyContent = scanner.next();
      this.historyContent = historyContent;
    } catch (Exception e) {
      System.out.println("Unable to get history");
    }
    parseHistory();
    return priceHistory;
  }

  /**
   * ParseHistory goes though the historyContent string which contains the html and parses though
   * all the closing prices using the reactIds within the html.
   */
  private void parseHistory() {
    String snipit;
    String reactId;
    String pastDate;
    Date currentDate = new Date();
    final DateFormat sdf = new SimpleDateFormat("MM dd, yyyy"); //format the date to match html

    int indexOfReactId;
    int offset;

    pastDate = sdf.format(currentDate).toString();
    /* Check what month it is */
    try {
      for (int j = 0; j < months.length; j++) {
        if (Integer.parseInt(pastDate.substring(0, 2)) == j) {
          pastDate = pastDate.replace(String.valueOf(j), months[j]);
          break;
        }
      }
    } catch (NumberFormatException e) {
      System.out.println("num format expection thrown");
    }
    StringBuilder dateOfInterest = new StringBuilder(pastDate);
    day = pastDate.substring(4, 6);
    /*Loop 50 times to fill the price histroy array*/
    for (int i = 0; i < 50; i++) {
      if (Integer.parseInt(day) < 10 && Integer.parseInt(day) >= 1) {
        day = "0" + day;
        try {
          if (day.equals("00" + day.substring(2, 3))) {
            day = day.substring(1);
          }
        } catch (Exception e) {
        }
      } else if (Integer.parseInt(day) == 0) {
        dateOfInterest.replace(0, 3, "Nov");
        day = "30";
      }
      dateOfInterest.replace(4, 6, String.valueOf(day));
      pastDate = dateOfInterest.toString();
      int index = historyContent.indexOf(pastDate) + 71;
      reactId = historyContent.substring(index, index + 5);
      reactId = reactId.replaceAll("[^0-9]", "");
      /**
       * search though historyContent to find the correct reactId and set it to the i element
       * of the price history array.
       */
      try {
        indexOfReactId = Integer.parseInt(reactId) + 7;
        index = historyContent.indexOf("reactid=" + "\"" + indexOfReactId);
        offset = String.valueOf(indexOfReactId).length();
        snipit = historyContent.substring(index + 11 + offset, index + 19);
        snipit = snipit.replaceAll("[<>]", "");
        priceHistory[i] = Double.valueOf(snipit); //set price to priceHistory[i]
      } catch (NumberFormatException e) {
      }

      int days = Integer.parseInt(day);
      day = String.valueOf(--days); //set day to previous day to get its closing price
    }

    cleanPriceHistoryArray();
  }

  /**
   * cleanPriceHistoryArray is used to remove the 0s from the array due to the stock market not
   * being open on weekends as well as federal holidays. This is achieved by just checking if a
   * element is 0 and if it is move the element to the right of it in its index.
   */
  private void cleanPriceHistoryArray() {
    double temp[] = new double[50];
    try {
      for (int i = 0; i <= priceHistory.length - 1; i++) {
        if (priceHistory[i] != 0) {
          temp[i] = priceHistory[i];
        } else {
          temp[i] = priceHistory[i + 2];
        }
      }
    } catch (ArrayIndexOutOfBoundsException e) {
    }

    for (int i = 0; i <= priceHistory.length - 1; i++) {
      priceHistory[i] = temp[i];
    }
  }

  /**
   * pricePriceArray is used for testing purposes and prints in the console the price history of the
   * stock of interest.
   */
  public void printPriceArray() {
    for (int i = 0; i < priceHistory.length; i++) {
      System.out.println(priceHistory[i]);
    }
  }

  public static void main(String[] args) {
    StockQuote test = new StockQuote("AAPL");
    double prices[] = test.getPriceHistory();
    System.out.println("Current Price: " + test.getPrice());
    System.out.println("Price change on the trading day: " + test.getPriceChange());
    System.out.println("price history stored in a array");
    System.out.println("-------------------------------------");
    for (int i = 0; i < prices.length - 1; i++) {
      System.out.println(prices[i]);
    }

  }
}

