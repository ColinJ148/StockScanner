package sample;

import javafx.fxml.FXML;
import javafx.scene.text.Text;


public class Controller {
  @FXML
  private Text appleP;
  @FXML
  private Text applePC;
  @FXML
  private Text googleP;
  @FXML
  private Text googlePC;
  @FXML
  private Text facebookP;
  @FXML
  private Text facebookPC;
  @FXML
  private Text microsoftP;
  @FXML
  private Text microsoftPC;
  @FXML
  private Text visaP;
  @FXML
  private Text visaPC;
  @FXML
  private Text pepsiP;
  @FXML
  private Text pepsiPC;
  @FXML
  private Text atntP;
  @FXML
  private Text atntPC;
  @FXML
  private Text verzionP;
  @FXML
  private Text verzionPC;
  @FXML
  private Text netflixP;
  @FXML
  private Text netflixPC;
  @FXML
  private Text eaP;
  @FXML
  private Text eaPC;


  private double sma13;
  private double sma26;
  StockQuote apple = new StockQuote("AAPL");

  StockQuote google = new StockQuote("GOOGL");
  StockQuote facebook = new StockQuote("FB");
  StockQuote microsoft = new StockQuote("MSFT");
  StockQuote visa = new StockQuote("V");
  StockQuote pepsiCo = new StockQuote("PEP");
  StockQuote atnt = new StockQuote("T");
  StockQuote verzion = new StockQuote("VZ");
  StockQuote netflix = new StockQuote("NFLX");
  StockQuote electronicArts = new StockQuote("EA");








  public Controller(){







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



@FXML
  private void onUpdatePressed(){
  appleP.setText(apple.getPrice());
  applePC.setText(apple.getPriceChange());
  googleP.setText(google.getPrice());
  googlePC.setText(google.getPriceChange());
  facebookP.setText(facebook.getPrice());
  facebookPC.setText(facebook.getPriceChange());
  microsoftP.setText(facebook.getPrice());
  microsoftPC.setText(microsoft.getPriceChange());
  visaP.setText(visa.getPrice());
  visaPC.setText(visa.getPriceChange());
  pepsiP.setText(pepsiCo.getPrice());
  pepsiP.setText(pepsiCo.getPriceChange());
  atntP.setText(atnt.getPrice());
  atntPC.setText(atnt.getPriceChange());
  verzionP.setText(verzion.getPrice());
  verzionPC.setText(verzion.getPriceChange());
  netflixP.setText(netflix.getPrice());
  netflixPC.setText(netflix.getPriceChange());
  eaP.setText(electronicArts.getPrice());
  eaPC.setText(electronicArts.getPriceChange());

  }



  public static void main(String[] args) {
    Controller controller = new Controller();
  }

}
