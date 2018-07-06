package controller;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.LoadException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Anforderungsanalyse;
import model.Optimieren_I;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlgorithmPickDialogController implements Initializable {

    @FXML
    private Label textBox;

    @FXML
    private ComboBox<Optimieren_I> algorithmBox;

    @FXML
    private Button ok;


    @FXML
    void onClickCancel(MouseEvent event) throws IOException {
        Stage stage = (Stage) ok.getScene().getWindow();
        stage.close();

    }

    @FXML
    void onClickOk(MouseEvent event) {
        Anforderungsanalyse.getInstance().setFpOpti(algorithmBox.getSelectionModel().getSelectedIndex());
        Stage stage = (Stage) ok.getScene().getWindow();
        stage.close();
        Stage optiWindow = new Stage();
        optiWindow.initModality(Modality.APPLICATION_MODAL);
        try {
            optiWindow.getIcons().add(new Image("/res/dhbw.png"));
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/view/Opti.fxml"));
                optiWindow.setScene(new Scene(root));
                optiWindow.setTitle("Selbstoptimierende Nachkalkulation");
                optiWindow.showAndWait();
            } catch (LoadException ex) {
            }
        } catch (IOException ex) {
            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, "", ex);
        }
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

