package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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

        // Simon, mach hier deine Berechnungen und schreib die ergebnisse in
        textbox.setText("Hallo Welt");
        //ok papa
    }
}
