package sample;

import java.text.DecimalFormat;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


@SuppressWarnings("Duplicates")
public class Controller {

  @FXML
  private Text appleP;
  @FXML
  private Text applePC;
  @FXML
  private Text appleE13;
  @FXML
  private Text appleE26;
  @FXML
  private Text appleMACD;
  @FXML
  private Text snapP;
  @FXML
  private Text snapPC;
  @FXML
  private Text snapE13;
  @FXML
  private Text snapE26;
  @FXML
  private Text snapMACD;
  @FXML
  private Text facebookP;
  @FXML
  private Text facebookPC;
  @FXML
  private Text facebookE13;
  @FXML
  private Text facebookE26;
  @FXML
  private Text facebookMACD;
  @FXML
  private Text microsoftP;
  @FXML
  private Text microsoftPC;
  @FXML
  private Text microsoftE13;
  @FXML
  private Text microsoftE26;
  @FXML
  private Text microsoftMACD;
  @FXML
  private Text visaP;
  @FXML
  private Text visaPC;
  @FXML
  private Text visaE13;
  @FXML
  private Text visaE26;
  @FXML
  private Text visaMACD;
  @FXML
  private Text pepsiP;
  @FXML
  private Text pepsiPC;
  @FXML
  private Text pepsiE13;
  @FXML
  private Text pepsiE26;
  @FXML
  private Text pepsiMACD;
  @FXML
  private Text atntP;
  @FXML
  private Text atntPC;
  @FXML
  private Text atntE13;
  @FXML
  private Text atntE26;
  @FXML
  private Text atntMACD;
  @FXML
  private Text verizonP;
  @FXML
  private Text verizonPC;
  @FXML
  private Text verizonE13;
  @FXML
  private Text verizonE26;
  @FXML
  private Text verizonMACD;
  @FXML
  private Text netflixP;
  @FXML
  private Text netflixPC;
  @FXML
  private Text netflixE13;
  @FXML
  private Text netflixE26;
  @FXML
  private Text netflixMACD;
  @FXML
  private Text eaP;
  @FXML
  private Text eaPC;
  @FXML
  private Text eaE26;
  @FXML
  private Text eaE13;
  @FXML
  private Text eaMACD;


  StockQuote apple = new StockQuote("AAPL");
  StockQuote snap = new StockQuote("SNAP");
  StockQuote facebook = new StockQuote("FB");
  StockQuote microsoft = new StockQuote("MSFT");
  StockQuote visa = new StockQuote("V");
  StockQuote pepsi = new StockQuote("PEP");
  StockQuote atnt = new StockQuote("T");
  StockQuote verizon = new StockQuote("VZ");
  StockQuote netflix = new StockQuote("NFLX");
  StockQuote electronicArts = new StockQuote("EA");


  public Controller() {

  }

  public String SMA(int period, double[] vals, int skipdays) {
    double value = 0.0;
    String output = "";
    for (int i = skipdays; i < (period + skipdays); i++) {
      value += vals[i];
    }
    DecimalFormat df = new DecimalFormat("#.00");

    value /= (double) period;

    output = df.format(value);

    return output;
  }


  private void setIndicators() {
    appleE13.setText(SMA(13, apple.getPriceHistory(), 0));
    appleE26.setText(SMA(26, apple.getPriceHistory(), 0));
    appleMACD.setText(MACD(apple));
    //noinspection Duplicates
    if (Double.parseDouble(MACD(apple)) < 0) {
      appleP.setFill(Color.GREEN);
      applePC.setFill(Color.GREEN);
      appleE13.setFill(Color.GREEN);
      appleE26.setFill(Color.GREEN);
      appleMACD.setFill(Color.GREEN);
    } else {
      appleP.setFill(Color.RED);
      applePC.setFill(Color.RED);
      appleE13.setFill(Color.RED);
      appleE26.setFill(Color.RED);
      appleMACD.setFill(Color.RED);
    }
    snapE13.setText(SMA(13, snap.getPriceHistory(), 0));
    snapE26.setText(SMA(26, snap.getPriceHistory(), 0));
    snapMACD.setText(MACD(snap));
    if (Double.parseDouble(MACD(snap)) < 0) {
      snapP.setFill(Color.GREEN);
      snapPC.setFill(Color.GREEN);
      snapE13.setFill(Color.GREEN);
      snapE26.setFill(Color.GREEN);
      snapMACD.setFill(Color.GREEN);
    } else {
      snapP.setFill(Color.RED);
      snapPC.setFill(Color.RED);
      snapE13.setFill(Color.RED);
      snapE26.setFill(Color.RED);
      snapMACD.setFill(Color.RED);
    }
    facebookE13.setText(SMA(13, facebook.getPriceHistory(), 0));
    facebookE26.setText(SMA(26, facebook.getPriceHistory(), 0));
    facebookMACD.setText(MACD(facebook));
    if (Double.parseDouble(MACD(facebook)) < 0) {
      facebookP.setFill(Color.GREEN);
      facebookPC.setFill(Color.GREEN);
      facebookE13.setFill(Color.GREEN);
      facebookE26.setFill(Color.GREEN);
      facebookMACD.setFill(Color.GREEN);
    } else {
      facebookP.setFill(Color.RED);
      facebookPC.setFill(Color.RED);
      facebookE13.setFill(Color.RED);
      facebookE26.setFill(Color.RED);
      facebookMACD.setFill(Color.RED);
    }
    microsoftE13.setText(SMA(13, microsoft.getPriceHistory(), 0));
    microsoftE26.setText(SMA(26, microsoft.getPriceHistory(), 0));
    microsoftMACD.setText(MACD(microsoft));
    if (Double.parseDouble(MACD(microsoft)) < 0) {
      microsoftP.setFill(Color.GREEN);
      microsoftPC.setFill(Color.GREEN);
      microsoftE13.setFill(Color.GREEN);
      microsoftE26.setFill(Color.GREEN);
      microsoftMACD.setFill(Color.GREEN);
    } else {
      microsoftP.setFill(Color.RED);
      microsoftPC.setFill(Color.RED);
      microsoftE13.setFill(Color.RED);
      microsoftE26.setFill(Color.RED);
      microsoftMACD.setFill(Color.RED);
    }
    visaE13.setText(SMA(13, visa.getPriceHistory(), 0));
    visaE26.setText(SMA(26, visa.getPriceHistory(), 0));
    visaMACD.setText(MACD(visa));
    if (Double.parseDouble(MACD(visa)) < 0) {
      visaP.setFill(Color.GREEN);
      visaPC.setFill(Color.GREEN);
      visaE13.setFill(Color.GREEN);
      visaE26.setFill(Color.GREEN);
      visaMACD.setFill(Color.GREEN);
    } else {
      visaP.setFill(Color.RED);
      visaPC.setFill(Color.RED);
      visaE13.setFill(Color.RED);
      visaE26.setFill(Color.RED);
      visaMACD.setFill(Color.RED);
    }
    pepsiE13.setText(SMA(13, pepsi.getPriceHistory(), 0));
    pepsiE26.setText(SMA(26, pepsi.getPriceHistory(), 0));
    pepsiMACD.setText(MACD(pepsi));
    if (Double.parseDouble(MACD(pepsi)) < 0) {
      pepsiP.setFill(Color.GREEN);
      pepsiPC.setFill(Color.GREEN);
      pepsiE13.setFill(Color.GREEN);
      pepsiE26.setFill(Color.GREEN);
      pepsiMACD.setFill(Color.GREEN);
    } else {
      pepsiP.setFill(Color.RED);
      pepsiPC.setFill(Color.RED);
      pepsiE13.setFill(Color.RED);
      pepsiE26.setFill(Color.RED);
      pepsiMACD.setFill(Color.RED);
    }
    atntE13.setText(SMA(13, atnt.getPriceHistory(), 0));
    atntE26.setText(SMA(26, atnt.getPriceHistory(), 0));
    atntMACD.setText(MACD(atnt));
    if (Double.parseDouble(MACD(atnt)) < 0) {
      atntP.setFill(Color.GREEN);
      atntPC.setFill(Color.GREEN);
      atntE13.setFill(Color.GREEN);
      atntE26.setFill(Color.GREEN);
      atntMACD.setFill(Color.GREEN);
    } else {
      atntP.setFill(Color.RED);
      atntPC.setFill(Color.RED);
      atntE13.setFill(Color.RED);
      atntE26.setFill(Color.RED);
      atntMACD.setFill(Color.RED);
    }
    verizonE13.setText(SMA(13, verizon.getPriceHistory(), 0));
    verizonE26.setText(SMA(26, verizon.getPriceHistory(), 0));
    verizonMACD.setText(MACD(verizon));
    if (Double.parseDouble(MACD(verizon)) < 0) {
      verizonP.setFill(Color.GREEN);
      verizonPC.setFill(Color.GREEN);
      verizonE13.setFill(Color.GREEN);
      verizonE26.setFill(Color.GREEN);
      verizonMACD.setFill(Color.GREEN);
    } else {
      verizonP.setFill(Color.RED);
      verizonPC.setFill(Color.RED);
      verizonE13.setFill(Color.RED);
      verizonE26.setFill(Color.RED);
      verizonMACD.setFill(Color.RED);
    }
    netflixE13.setText(SMA(13, netflix.getPriceHistory(), 0));
    netflixE26.setText(SMA(26, netflix.getPriceHistory(), 0));
    netflixMACD.setText(MACD(netflix));
    if (Double.parseDouble(MACD(netflix)) < 0) {
      netflixP.setFill(Color.GREEN);
      netflixPC.setFill(Color.GREEN);
      netflixE13.setFill(Color.GREEN);
      netflixE26.setFill(Color.GREEN);
      netflixMACD.setFill(Color.GREEN);
    } else {
      netflixP.setFill(Color.RED);
      netflixPC.setFill(Color.RED);
      netflixE13.setFill(Color.RED);
      netflixE26.setFill(Color.RED);
      netflixMACD.setFill(Color.RED);
    }
    eaE13.setText(SMA(13, electronicArts.getPriceHistory(), 0));
    eaE26.setText(SMA(13, electronicArts.getPriceHistory(), 0));
    eaMACD.setText(MACD(electronicArts));
    if (Double.parseDouble(MACD(electronicArts)) < 0) {
      eaP.setFill(Color.GREEN);
      eaPC.setFill(Color.GREEN);
      eaE13.setFill(Color.GREEN);
      eaE26.setFill(Color.GREEN);
      eaMACD.setFill(Color.GREEN);
    } else {
      eaP.setFill(Color.RED);
      eaPC.setFill(Color.RED);
      eaE13.setFill(Color.RED);
      eaE26.setFill(Color.RED);
      eaMACD.setFill(Color.RED);
    }
  }

  @FXML
  private void onUpdatePressed() {
    appleP.setText(apple.getPrice());
    applePC.setText(apple.getPriceChange());
    snapP.setText(snap.getPrice());
    snapPC.setText(snap.getPriceChange());
    facebookP.setText(facebook.getPrice());
    facebookPC.setText(facebook.getPriceChange());
    microsoftP.setText(facebook.getPrice());
    microsoftPC.setText(microsoft.getPriceChange());
    visaP.setText(visa.getPrice());
    visaPC.setText(visa.getPriceChange());
    pepsiP.setText(pepsi.getPrice());
    pepsiPC.setText(pepsi.getPriceChange());
    atntP.setText(atnt.getPrice());
    atntPC.setText(atnt.getPriceChange());
    verizonP.setText(verizon.getPrice());
    verizonPC.setText(verizon.getPriceChange());
    snapP.setText(snap.getPrice());
    snapPC.setText(snap.getPriceChange());
    netflixP.setText(netflix.getPrice());
    netflixPC.setText(netflix.getPriceChange());
    eaP.setText(electronicArts.getPrice());
    eaPC.setText(electronicArts.getPriceChange());
    setIndicators();


  }

  public String MACD(StockQuote stock) {
    String sma26;
    String output;
    String sma13;
    DecimalFormat df = new DecimalFormat("#.00");

    sma26 = SMA(26, stock.getPriceHistory(), 0);
    sma13 = SMA(13, stock.getPriceHistory(), 0);
    double macd = Double.valueOf(sma26) - Double.valueOf(sma13);
    output = df.format(macd);
    return output;

  }


}
