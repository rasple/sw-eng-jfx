package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class OptiController implements Initializable {

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
        TextInputDialog dialog = new TextInputDialog("0");
        dialog.setTitle("Eingabe");
        dialog.setHeaderText("Bitte um Eingabe:");
        dialog.setContentText("Zeit in Mannmonaten");
        dialog.getEditor().textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    dialog.getEditor().setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        Optional<String> result = dialog.showAndWait();
        int mannmonate = Integer.getInteger(result.get());

        // Simon, mach hier deine Berechnungen und schreib die ergebnisse in
        //textbox.setText();
    }
}
