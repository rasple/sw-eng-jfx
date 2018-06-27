package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Anforderungsanalyse;
import model.Faktoren;
import utils.Convert;

import java.net.URL;
import java.util.ResourceBundle;

public class SchaetzfaktorenController implements Initializable {
    @FXML
    public Button ok;
    @FXML
    public Button cancel;
    @FXML
    private TextField verfechtungText;

    @FXML
    private Slider verfechtungSlider;

    @FXML
    private TextField dezentraleDatenText;

    @FXML
    private Slider dezentraleDatenSlider;

    @FXML
    private TextField transaktionsrateText;

    @FXML
    private Slider transaktionsrateSlider;

    @FXML
    private TextField rechenoperationenText;

    @FXML
    private Slider rechenoperationenSlider;

    @FXML
    private TextField kontrollverfahrenText;

    @FXML
    private Slider kontrollverfahrenSlider;

    @FXML
    private TextField ausnahmeregelungText;

    @FXML
    private Slider ausnahmeregelungSlider;

    @FXML
    private TextField logikText;

    @FXML
    private Slider logikSlider;

    @FXML
    private TextField wiederverwendbarkeitText;

    @FXML
    private Slider wiederverwendbarkeitSlider;

    @FXML
    private TextField datenbestandskonvertierungText;

    @FXML
    private Slider datenbestandskonvertierungSlider;

    @FXML
    private TextField anpassbarkeitText;

    @FXML
    private Slider anpassbarkeitSlider;

    private Faktoren faktoren;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        faktoren = Anforderungsanalyse.getInstance().getFaktoren();

        verfechtungText.setText(String.valueOf(faktoren.getVerfechtung()));
        dezentraleDatenText.setText(String.valueOf(faktoren.getDezentraleDaten()));
        transaktionsrateText.setText(String.valueOf(faktoren.getTransaktionsrate()));
        rechenoperationenText.setText(String.valueOf(faktoren.getRechenoperationen()));
        kontrollverfahrenText.setText(String.valueOf(faktoren.getKontrollverfahren()));
        ausnahmeregelungText.setText(String.valueOf(faktoren.getAusnahmeregelung()));
        logikText.setText(String.valueOf(faktoren.getLogik()));
        wiederverwendbarkeitText.setText(String.valueOf(faktoren.getWiederverwendbarkeit()));
        datenbestandskonvertierungText.setText(String.valueOf(faktoren.getDatenbestandskonvertierung()));
        anpassbarkeitText.setText(String.valueOf(faktoren.getAnpassbarkeit()));

        addFormatter(verfechtungText);
        addFormatter(dezentraleDatenText);
        addFormatter(transaktionsrateText);
        addFormatter(rechenoperationenText);
        addFormatter(kontrollverfahrenText);
        addFormatter(ausnahmeregelungText);
        addFormatter(logikText);
        addFormatter(wiederverwendbarkeitText);
        addFormatter(datenbestandskonvertierungText);
        addFormatter(anpassbarkeitText);

        setUpSlider(verfechtungSlider, 5, faktoren.getVerfechtung(), verfechtungText);
        setUpSlider(dezentraleDatenSlider, 5, faktoren.getDezentraleDaten(), dezentraleDatenText);
        setUpSlider(transaktionsrateSlider, 5, faktoren.getTransaktionsrate(), transaktionsrateText);
        setUpSlider(rechenoperationenSlider, 5, faktoren.getRechenoperationen(), rechenoperationenText);
        setUpSlider(kontrollverfahrenSlider, 5, faktoren.getKontrollverfahren(), kontrollverfahrenText);
        setUpSlider(ausnahmeregelungSlider, 5, faktoren.getAusnahmeregelung(), ausnahmeregelungText);
        setUpSlider(logikSlider, 5, faktoren.getLogik(), logikText);
        setUpSlider(wiederverwendbarkeitSlider, 5, faktoren.getWiederverwendbarkeit(), wiederverwendbarkeitText);
        setUpSlider(datenbestandskonvertierungSlider, 5, faktoren.getDatenbestandskonvertierung(), datenbestandskonvertierungText);
        setUpSlider(anpassbarkeitSlider, 5, faktoren.getAnpassbarkeit(), anpassbarkeitText);


    }

    private void addFormatter(TextField textField) {
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*.\\d*")) {
                    textField.setText(newValue.replaceAll("[^\\d\\.]", ""));
                }
            }
        });
    }

    private void setUpSlider(Slider slider, double range, double currentValue, TextField textField) {
        slider.setMin(0);
        slider.setMax(range);
        slider.setValue(currentValue);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(0.5);
        slider.setMinorTickCount(100);
        slider.setSnapToTicks(true);
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                if (Double.toString(t1.doubleValue()).length() > 5) {
                    textField.setText(Double.toString(t1.doubleValue()).substring(0, 5));
                } else {
                    textField.setText(Double.toString(t1.doubleValue()));
                }
            }
        });
    }

    public void onClickOk(MouseEvent mouseEvent) {

        faktoren.setVerfechtung(Double.valueOf(verfechtungText.getText()));
        faktoren.setDezentraleDaten(Double.valueOf(dezentraleDatenText.getText()));
        faktoren.setTransaktionsrate(Double.valueOf(transaktionsrateText.getText()));
        faktoren.setRechenoperationen(Double.valueOf(rechenoperationenText.getText()));
        faktoren.setKontrollverfahren(Double.valueOf(kontrollverfahrenText.getText()));
        faktoren.setAusnahmeregelung(Double.valueOf(ausnahmeregelungText.getText()));
        faktoren.setLogik(Double.valueOf(logikText.getText()));
        faktoren.setWiederverwendbarkeit(Double.valueOf(wiederverwendbarkeitText.getText()));
        faktoren.setDatenbestandskonvertierung(Double.valueOf(datenbestandskonvertierungText.getText()));
        faktoren.setAnpassbarkeit(Double.valueOf(anpassbarkeitText.getText()));

        System.out.println(Convert.toJSON(faktoren));
        Anforderungsanalyse.getInstance().setFaktoren(faktoren);
        Stage stage = (Stage) ok.getScene().getWindow();
        stage.close();
    }

    public void onClickCancel(MouseEvent mouseEvent) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    public Faktoren getFaktoren() {
        return faktoren;
    }

    public void setFaktoren(Faktoren faktoren) {
        this.faktoren = faktoren;
    }

}
