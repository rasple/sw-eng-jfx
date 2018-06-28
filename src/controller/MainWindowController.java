package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.*;
import utils.IO;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainWindowController {
    @FXML
    public Label klaus;

    @FXML
    void onClickExportProduktfunktion() {
        IO.save(Anforderungsanalyse.getInstance().getProduktfunktionen(), (Stage) klaus.getScene().getWindow());
    }

    @FXML
    void onClickImportProduktfunktion() {
        Anforderungsanalyse.getInstance().setProduktfunktionen((List<Produktfunktion>) IO.load((Stage) klaus.getScene().getWindow()));
    }

    @FXML
    void onClickExportProduktdaten() {
        IO.save(Anforderungsanalyse.getInstance().getProduktdaten(), (Stage) klaus.getScene().getWindow());
    }

    @FXML
    void onClickImportProduktdaten() {
        Anforderungsanalyse.getInstance().setProduktdaten((List<Produktdaten>) IO.load((Stage) klaus.getScene().getWindow()));
    }

    @FXML
    void onClickExportProduktumgebung() {
        IO.save(Anforderungsanalyse.getInstance().getProduktumgebung(), (Stage) klaus.getScene().getWindow());
    }

    @FXML
    void onClickImportProduktumgebung() {
        Anforderungsanalyse.getInstance().setProduktumgebung((Produktumgebung) IO.load((Stage) klaus.getScene().getWindow()));
    }

    @FXML
    void onClickExportProdukteinsatz() {
        IO.save(Anforderungsanalyse.getInstance().getProdukteinsatz(), (Stage) klaus.getScene().getWindow());
    }

    @FXML
    void onClickImportProdukteinsatz() {
        Anforderungsanalyse.getInstance().setProdukteinsatz((Produkteinsatz) IO.load((Stage) klaus.getScene().getWindow()));
    }

    @FXML
    void onClickExportZielbestimmung() {
        IO.save(Anforderungsanalyse.getInstance().getZielbestimmung(), (Stage) klaus.getScene().getWindow());
    }

    @FXML
    void onClickImportZielbestimmung() {
        Anforderungsanalyse.getInstance().setZielbestimmung((Zielbestimmung) IO.load((Stage) klaus.getScene().getWindow()));
    }

    @FXML
    void onClickExportSchaetzfaktoren() {
        IO.save(Anforderungsanalyse.getInstance().getFaktoren(), (Stage) klaus.getScene().getWindow());
    }

    @FXML
    void onClickImportSchaetzfaktoren() {
        Anforderungsanalyse.getInstance().setFaktoren((Faktoren) IO.load((Stage) klaus.getScene().getWindow()));
    }

    @FXML
    public void onClickExport(MouseEvent event) {
        IO.save(Anforderungsanalyse.getInstance(), (Stage) klaus.getScene().getWindow());
    }

    @FXML
    public void onClickImport(MouseEvent event) {
        Anforderungsanalyse.getInstance().setAnforderungsanalyse((Anforderungsanalyse) IO.load((Stage) klaus.getScene().getWindow()));
    }
    public void onClickEditProduktfunktionen(MouseEvent mouseEvent) {
        Stage produktfunktionenWindow = new Stage();
        produktfunktionenWindow.initModality(Modality.APPLICATION_MODAL);
        try {
            produktfunktionenWindow.getIcons().add(new Image("/res/dhbw.png"));
            Parent root = FXMLLoader.load(getClass().getResource("../view/Produktfunktionen.fxml"));
            produktfunktionenWindow.setScene(new Scene(root));
            produktfunktionenWindow.setTitle("Produktfunktionen");
            produktfunktionenWindow.show();
        } catch (IOException ex) {
            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, "", ex);
        }
    }

    public void onClickResetProduktfunktionen(MouseEvent mouseEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Bestätigung");
        alert.setHeaderText("Bitte bestätigen Sie");
        alert.setContentText("Wollen Sie alle Produktfunktionen löschen?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Anforderungsanalyse.getInstance().setProduktfunktionen(new ArrayList<Produktfunktion>());
        } else {
            return;
        }
    }

    public void onClickEditProduktdaten(MouseEvent mouseEvent) {
        Stage produktfunktionenWindow = new Stage();
        produktfunktionenWindow.initModality(Modality.APPLICATION_MODAL);
        try {
            produktfunktionenWindow.getIcons().add(new Image("/res/dhbw.png"));
            Parent root = FXMLLoader.load(getClass().getResource("../view/Produktdaten.fxml"));
            produktfunktionenWindow.setScene(new Scene(root));
            produktfunktionenWindow.setTitle("Produktdaten");
            produktfunktionenWindow.show();
        } catch (IOException ex) {
            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, "", ex);
        }
    }

    public void onClickResetProduktdaten(MouseEvent mouseEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Bestätigung");
        alert.setHeaderText("Bitte bestätigen Sie");
        alert.setContentText("Wollen Sie alle Produktdaten löschen?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Anforderungsanalyse.getInstance().setProduktdaten(new ArrayList<Produktdaten>());
        } else {
            return;
        }

    }


    public void onClickOpti(MouseEvent event) {
        Stage optiWindow = new Stage();
        optiWindow.initModality(Modality.APPLICATION_MODAL);
        try {
            optiWindow.getIcons().add(new Image("/res/dhbw.png"));
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
            aufwabschWindow.getIcons().add(new Image("/res/dhbw.png"));
            Parent root = FXMLLoader.load(getClass().getResource("../view/Aufwabsch.fxml"));
            aufwabschWindow.setScene(new Scene(root));
            aufwabschWindow.setTitle("Aufwandsabschätzung");
            aufwabschWindow.show();
        } catch (IOException ex) {
            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, "", ex);
        }
    }


    public void onClickResetProduktumgebung(MouseEvent mouseEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Bestätigung");
        alert.setHeaderText("Bitte bestätigen Sie");
        alert.setContentText("Wollen Sie die Produktumgebung löschen?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Anforderungsanalyse.getInstance().setProduktumgebung(new Produktumgebung());
        } else {
            return;
        }
    }

    public void onClickEditProduktumgebung(MouseEvent mouseEvent) {
        Stage produktumgebungWindow = new Stage();
        produktumgebungWindow.initModality(Modality.APPLICATION_MODAL);
        try {
            produktumgebungWindow.getIcons().add(new Image("/res/dhbw.png"));
            Parent root = FXMLLoader.load(getClass().getResource("../view/Produktumgebung.fxml"));
            produktumgebungWindow.setScene(new Scene(root));
            produktumgebungWindow.setTitle("Produktumgebung");
            produktumgebungWindow.show();
        } catch (IOException ex) {
            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, "", ex);
        }
    }

    public void onClickResetProdukteinsatz(MouseEvent mouseEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Bestätigung");
        alert.setHeaderText("Bitte bestätigen Sie");
        alert.setContentText("Wollen Sie den Produkteinsatz löschen?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Anforderungsanalyse.getInstance().setProdukteinsatz(new Produkteinsatz());
        } else {
            return;
        }
    }

    public void onClickEditProdukteinsatz(MouseEvent mouseEvent) {
        Stage produkteinsatzWindow = new Stage();
        produkteinsatzWindow.initModality(Modality.APPLICATION_MODAL);
        try {
            produkteinsatzWindow.getIcons().add(new Image("/res/dhbw.png"));
            Parent root = FXMLLoader.load(getClass().getResource("../view/Produkteinsatz.fxml"));
            produkteinsatzWindow.setScene(new Scene(root));
            produkteinsatzWindow.setTitle("Produkteinsatz");
            produkteinsatzWindow.show();
        } catch (IOException ex) {
            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, "", ex);
        }
    }

    public void onClickResetZielbestimmung(MouseEvent mouseEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Bestätigung");
        alert.setHeaderText("Bitte bestätigen Sie");
        alert.setContentText("Wollen Sie die Zielbestimmung löschen?");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            Anforderungsanalyse.getInstance().setZielbestimmung(new Zielbestimmung());
        } else {
            return;
        }
    }

    public void onClickEditZielbestimmung(MouseEvent mouseEvent) {
        Stage zielbestimmungWindow = new Stage();
        zielbestimmungWindow.initModality(Modality.APPLICATION_MODAL);
        try {
            zielbestimmungWindow.getIcons().add(new Image("/res/dhbw.png"));
            Parent root = FXMLLoader.load(getClass().getResource("../view/Zielbestimmung.fxml"));
            zielbestimmungWindow.setScene(new Scene(root));
            zielbestimmungWindow.setTitle("Zielbestimmung");
            zielbestimmungWindow.show();
        } catch (IOException ex) {
            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, "", ex);
        }
    }

    public void onClickResetSchaetzfaktoren(MouseEvent mouseEvent) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Bestätigung");
        alert.setHeaderText("Bitte bestätigen Sie");
        alert.setContentText("Wollen Sie die Schätzfaktoren löschen?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            // Anforderungsanalyse.getInstance().setFaktoren(new ArrayList<Faktoren>());
        } else {
            return;
        }
    }

    public void onClickEditSchaetzfaktoren(MouseEvent mouseEvent) {
        Stage schaetzfaktorenWindow = new Stage();
        schaetzfaktorenWindow.initModality(Modality.APPLICATION_MODAL);
        try {
            schaetzfaktorenWindow.getIcons().add(new Image("/res/dhbw.png"));
            Parent root = FXMLLoader.load(getClass().getResource("../view/Schaetzfaktoren.fxml"));
            schaetzfaktorenWindow.setScene(new Scene(root));
            schaetzfaktorenWindow.setTitle("Schätzfaktoren");
            schaetzfaktorenWindow.show();
        } catch (IOException ex) {
            Logger.getLogger(MainWindowController.class.getName()).log(Level.SEVERE, "", ex);
        }
    }



    public void onClickGithub(MouseEvent event) {

        try {
            Desktop.getDesktop().browse(new URI("https://github.com/rasple/sw-eng-jfx"));
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }

    }


}

