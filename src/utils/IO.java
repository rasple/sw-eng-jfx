package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.json.JSONObject;
import org.json.XML;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IO {
    public static void save(Object obj, Stage stage) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JSONObject json = new JSONObject(mapper.writeValueAsString(obj));
            String xml = XML.toString(json);
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Speichere Datei");
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("KLAUS Dateien (*.klaus)", "*.klaus");
            fileChooser.getExtensionFilters().add(extFilter);
            File file = fileChooser.showSaveDialog(stage);
            writeFile(xml, file);
        } catch (Exception ex) {
            Logger.getLogger(IO.class.getName()).log(Level.SEVERE, "", ex);
        }
    }

    public static Object load(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Öffne Datei");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("KLAUS Dateien (*.klaus)", "*.klaus");
        fileChooser.getExtensionFilters().add(extFilter);
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

    static void writeFile(String content, File file) {
        try {
            FileWriter fileWriter = null;
            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
