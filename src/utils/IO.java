package utils;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IO {
    static void save(Object obj) {

    }

    static Object load(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Öffne Datei");
        File file = fileChooser.showOpenDialog(stage);
        String objString = "";
        try {
            objString = readFile(file.getPath(), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            Logger.getLogger(IO.class.getName()).log(Level.SEVERE, "", ex);
        }
        return Convert.XMLToObject(objString);
    }

    static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
