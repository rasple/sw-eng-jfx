package utils;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.xml.bind.JAXB;
import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IO {
    public static void save(Object obj, Stage stage) {
        System.out.println(obj);
        StringWriter stringWriter = new StringWriter();
        JAXB.marshal(obj, stringWriter);
        String xml = stringWriter.toString();
        System.out.println(xml);
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
        File file = fileChooser.showOpenDialog(stage);
        Object decoded = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            XMLDecoder decoder = new XMLDecoder(fis);
            decoded = decoder.readObject();
            decoder.close();
            fis.close();
        } catch (Exception ex) {
            Logger.getLogger(IO.class.getName()).log(Level.SEVERE, "", ex);
        }
        return decoded;
    }
}
