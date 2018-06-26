package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Anforderungsanalyse;
import model.Produktumgebung;

import java.net.URL;
import java.util.ResourceBundle;

public class ProduktumgebungController implements Initializable {
    @FXML
    public TextArea text;

    public void onClickSave(MouseEvent mouseEvent) {
        Produktumgebung produktumgebung = new Produktumgebung(text.getText());
        Anforderungsanalyse.getInstance().setProduktumgebung(produktumgebung);
        Stage stage = (Stage) text.getScene().getWindow();
        stage.close();
    }

    public void onClickCancel(MouseEvent mouseEvent) {
        Stage stage = (Stage) text.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        text.setText(Anforderungsanalyse.getInstance().getProduktumgebung().getText());
    }
}
