package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainWindowController {


    public void onClickProduktfunktionen(MouseEvent mouseEvent) {
        Stage produktfunktionenWindow = new Stage();
        produktfunktionenWindow.initModality(Modality.APPLICATION_MODAL);
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/Produktfunktionen.fxml"));
            produktfunktionenWindow.setScene(new Scene(root));
            produktfunktionenWindow.setTitle("Produktfunktionen");
            produktfunktionenWindow.show();
        } catch (IOException ex) {
            Logger.getLogger(ProduktfunktionenController.class.getName()).log(Level.SEVERE, "", ex);
        }
    }

    public void onClickProduktdaten(MouseEvent mouseEvent) {
        Stage produktfunktionenWindow = new Stage();
        produktfunktionenWindow.initModality(Modality.APPLICATION_MODAL);
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/Produktdaten.fxml"));
            produktfunktionenWindow.setScene(new Scene(root));
            produktfunktionenWindow.setTitle("Produktdaten");
            produktfunktionenWindow.show();
        } catch (IOException ex) {
            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, "", ex);
        }
    }

    public void onClickExport(MouseEvent event) {
    }

    public void onClickImport(MouseEvent event) {
    }

    public void onClickOpti(MouseEvent event) {
        Stage optiWindow = new Stage();
        optiWindow.initModality(Modality.APPLICATION_MODAL);
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/Opti.fxml"));
            optiWindow.setScene(new Scene(root));
            optiWindow.setTitle("Produktdaten");
            optiWindow.show();
        } catch (IOException ex) {
            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, "", ex);
        }
    }

    public void onClickAufwabsch(MouseEvent event) {
        Stage aufwabschWindow = new Stage();
        aufwabschWindow.initModality(Modality.APPLICATION_MODAL);
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/Aufwabsch.fxml"));
            aufwabschWindow.setScene(new Scene(root));
            aufwabschWindow.setTitle("Produktdaten");
            aufwabschWindow.show();
        } catch (IOException ex) {
            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, "", ex);
        }
    }
}

