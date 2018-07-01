package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class AufwabschController {

    @FXML
    public Label textbox;

    @FXML
    public Button ok;


    public void onClickOk(MouseEvent event) {
        Stage stage = (Stage) ok.getScene().getWindow();
        stage.close();
    }

}
