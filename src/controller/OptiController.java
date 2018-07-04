package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Anforderungsanalyse;
import model.Faktoren;
import model.SelbstoptiException;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

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

        Pattern pattern = Pattern.compile("\\d*|\\d+\\,\\d*");
        TextFormatter formatter = new TextFormatter<>(change -> {
            return pattern.matcher(change.getControlNewText()).matches() ? change : null;
        });

        dialog.getEditor().setTextFormatter(formatter);
        dialog.setTitle("Eingabe");
        dialog.setHeaderText("Bitte um Eingabe:");
        dialog.setContentText("Zeit in Mannmonaten");

        Optional<String> result = dialog.showAndWait();

        double mannmonate = Double.valueOf(result.get());
        try {
            Faktoren sollfaktoren = Anforderungsanalyse.getInstance().selbstoptimierung(mannmonate);
            textbox.setText(sollfaktoren.Userausgabe());
        } catch (SelbstoptiException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fehler");
            alert.setHeaderText("Ein Fehler ist aufgetreten");
            alert.setContentText(e.getLocalizedMessage());
            alert.showAndWait();
            Stage stage = (Stage) ok.getScene().getWindow();
            stage.close();

        }
    }
}
