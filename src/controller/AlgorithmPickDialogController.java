package controller;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Anforderungsanalyse;
import model.Optimieren_I;

import java.net.URL;
import java.util.ResourceBundle;

public class AlgorithmPickDialogController implements Initializable {

    @FXML
    private Label textBox;

    @FXML
    private ComboBox<Optimieren_I> algorithmBox;

    @FXML
    private Button ok;


    @FXML
    void onClickCancel(MouseEvent event) {
        Stage stage = (Stage) ok.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onClickOk(MouseEvent event) {
        Anforderungsanalyse.getInstance().setFpOpti(algorithmBox.getSelectionModel().getSelectedIndex());
        Stage stage = (Stage) ok.getScene().getWindow();
        stage.close();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.algorithmBox.setItems(FXCollections.observableArrayList(Anforderungsanalyse.getInstance().getFpOpti()));
        this.algorithmBox.getSelectionModel().select(0);
        this.textBox.setText(this.algorithmBox.getSelectionModel().getSelectedItem().getBeschreibung());
        this.algorithmBox.valueProperty().addListener(new javafx.beans.value.ChangeListener<Optimieren_I>() {
            @Override
            public void changed(ObservableValue<? extends Optimieren_I> observableValue, Optimieren_I optimieren_i, Optimieren_I t1) {
                textBox.setText(t1.getBeschreibung());
            }
        });
    }
}

