package utils;

import com.sun.javafx.collections.ObservableListWrapper;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Anforderungsanalyse;

import java.beans.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IO {
    public static File save(Object obj, Stage stage) {
        File file = null;
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Speichere Datei");
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("KLAUS Dateien (*.klaus)", "*.klaus");
            fileChooser.getExtensionFilters().add(extFilter);
            file = fileChooser.showSaveDialog(stage);
        } catch (Exception ex) {
            return null;
        }
        fSave(obj, file);
        return file;
    }

    public static void fSave(Object obj, File file) {
        try {

            FileOutputStream fos = new FileOutputStream(file);
            XMLEncoder encoder = new XMLEncoder(fos);

            encoder.setExceptionListener(new ExceptionListener() {
                public void exceptionThrown(Exception ex) {
                    System.out.println(ex);
                    Logger.getLogger(IO.class.getName()).log(Level.SEVERE, "", ex);
                }
            });

            if (obj instanceof Anforderungsanalyse) {
                // Wegen Singleton und so
                Anforderungsanalyse anforderungsanalyse = Anforderungsanalyse.getInstance().getCopyOfCurrentAnforderungsanalyse();
                Anforderungsanalyse.getInstance().resetAnforderungsanalyse();
                encoder.writeObject(anforderungsanalyse);
                encoder.close();
                fos.close();
                Anforderungsanalyse.setAnforderungsanalyse(anforderungsanalyse);
            } else {
                encoder.writeObject(obj);
                encoder.close();
                fos.close();
            }
            /*
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Erfolgreich!");
            alert.setContentText("Daten wurden erfolgreich gespeichert!");
            alert.showAndWait();
            */
        } catch (Exception e) {
            Logger.getLogger(IO.class.getName()).log(Level.SEVERE, "", e);
            /*
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fehler");
            alert.setHeaderText("Fehler!");
            alert.setContentText("Daten konnten nicht importiert werden");
            alert.showAndWait();
            */
        }
    }

    public static Object load(Stage stage, File file) {
        return fLoad(file);
    }

    public static Object load(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Öffne Datei");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("K.L.A.U.S. Dateien (*.klaus)", "*.klaus");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = null;
        try {
            file = fileChooser.showOpenDialog(stage);
        } catch (Exception e) {
            return null;
        }
        return fLoad(file);
    }


    public static Object fLoad(File file) {
        Object decoded = null;
        if (file != null) {
            try {
                FileInputStream fis = new FileInputStream(file);
                XMLDecoder decoder = new XMLDecoder(fis);
                decoded = decoder.readObject();
                decoder.close();
                fis.close();
                /*
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Erfolgreich");
                alert.setContentText("Daten wurden erfolgreich gelesen!");
                alert.showAndWait();
                */
                return decoded;
            } catch (Exception ex) {
                Logger.getLogger(IO.class.getName()).log(Level.SEVERE, "", ex);
                /*
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Fehler");
                alert.setHeaderText("Fehler!");
                alert.setContentText("Daten konnten nicht importiert werden");

                alert.showAndWait();
                */
                return null;
            }
        }
        return null;
    }
}
