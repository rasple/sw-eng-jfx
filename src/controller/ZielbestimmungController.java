package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Anforderungsanalyse;
import model.Zielbestimmung;

import java.net.URL;
import java.util.ResourceBundle;

public class ZielbestimmungController implements Initializable {

    @FXML
    public TextArea text;

    public void onClickSave(MouseEvent mouseEvent) {
        Zielbestimmung zielbestimmung = new Zielbestimmung(text.getText());
        Anforderungsanalyse.getInstance().setZielbestimmung(zielbestimmung);
        Stage stage = (Stage) text.getScene().getWindow();
        stage.close();
    }

    public void onClickCancel(MouseEvent mouseEvent) {
        Stage stage = (Stage) text.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        text.setText(Anforderungsanalyse.getInstance().getZielbestimmung().getText());
    }
}
