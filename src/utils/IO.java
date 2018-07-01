package utils;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IO {
    public static void save(Object obj, Stage stage) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Speichere Datei");
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("KLAUS Dateien (*.klaus)", "*.klaus");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showSaveDialog(stage);

            FileOutputStream fos = new FileOutputStream(file);
            XMLEncoder encoder = new XMLEncoder(fos);
            encoder.setExceptionListener(new ExceptionListener() {
                public void exceptionThrown(Exception e) {
                    Logger.getLogger(IO.class.getName()).log(Level.SEVERE, "", e);
                }
            });
            System.out.println();
            encoder.writeObject(obj);
            encoder.close();
            fos.close();

        } catch (Exception e) {
            Logger.getLogger(IO.class.getName()).log(Level.SEVERE, "", e);
        }

    }

    public static Object load(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Öffne Datei");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("KLAUS Dateien (*.klaus)", "*.klaus");
        fileChooser.getExtensionFilters().add(extFilter);
        File file;
        try {
            file = fileChooser.showOpenDialog(stage);
        } catch (Exception e) {
            return null;
        }
        Object decoded = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            XMLDecoder decoder = new XMLDecoder(fis);
            decoded = decoder.readObject();
            decoder.close();
            fis.close();
            return decoded;
        } catch (Exception ex) {
            Logger.getLogger(IO.class.getName()).log(Level.SEVERE, "", ex);
            return null;
        }

    }
}
