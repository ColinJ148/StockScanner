package sample;

public class StockProcessor {
  private double sma13;
  private double sma26;
  private double[] stockHistory = new double[26];

  public StockProcessor(){
    //createStockObjects();
  }

  public double getSma13() {

    return sma13;
  }

  public double getSma26() {
    return sma26;
  }

  public double SMA(int period, double[] vals, int skipdays) {
    double value = 0.0;
    for (int i = skipdays; i < (period + skipdays); i++) {
      value += vals[i];
    }
    value /= (double) period;
    return value;
  }

  public double MACD() {
    return sma26 - sma13;
  }

//  private void createStockObject(){
//    StockQuote apple = new StockQuote("AAPL");
//    StockQuote googl = new StockQuote("GOOGL");
//    StockQuote facebook = new StockQuote("FB");
//    StockQuote microsoft = new StockQuote("MSFT");
//    StockQuote visa = new StockQuote("V");
//    StockQuote pepsiCo = new StockQuote("PEP");
//    StockQuote atnt = new StockQuote("T");
//    StockQuote verzion = new StockQuote("VZ");
//    StockQuote netflix = new StockQuote("NFLX");
//    StockQuote electronicArts = new StockQuote("EA");
//  }
}
