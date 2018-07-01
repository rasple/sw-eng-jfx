package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Anforderungsanalyse;

import java.net.URL;
import java.util.ResourceBundle;

public class AufwabschController implements Initializable {

    @FXML
    public Label textbox;

    @FXML
    public Button ok;


    public void onClickOk(MouseEvent event) {
        Stage stage = (Stage) ok.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String erg;
        double mannmonate=Anforderungsanalyse.getInstance().aufwandsabschaetzung();
        if(mannmonate==-1){
            erg="Die Produktfunktionen sind inkorrekt";
        }
        if(mannmonate==-2){
            erg="Die Produktdaten sind inkorrekt";
        }
        else{
            erg = "Das Projekt dauert nach der Functionpointmethode " + mannmonate + " Mannmonate";
        }
        // Simon, mach hier deine Berechnungen und schreib die ergebnisse in
        System.out.println(erg);
        textbox.setText(erg);
        //ok papa
    }
}
