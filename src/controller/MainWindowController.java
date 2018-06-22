package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javassist.bytecode.stackmap.TypeData;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainWindowController {
    public void createNewTextInput(String name) {
        Stage textInput = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/TextInput.fxml"));
            textInput.setTitle("Eingabe " + name);
            Scene scene = new Scene(root);
            textInput.setScene(scene);
            textInput.show();
        } catch (IOException ex) {
            Logger.getLogger(TypeData.ClassName.class.getName()).log(Level.SEVERE, "", ex);
        }
    }

    public void onClickProduktfunktionen(MouseEvent mouseEvent) {
        Stage produktfunktionenWindow = new Stage();
        produktfunktionenWindow.initModality(Modality.APPLICATION_MODAL);
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/Produktfunktionen.fxml"));
            produktfunktionenWindow.setScene(new Scene(root));
            produktfunktionenWindow.setTitle("Produktfunktionen");
            produktfunktionenWindow.show();
        } catch (IOException ex) {
            Logger.getLogger(TypeData.ClassName.class.getName()).log(Level.SEVERE, "", ex);
        }
    }
}

