package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import model.Anforderungsanalyse;
import model.Produktfunktion;
import org.apache.commons.lang3.StringUtils;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProduktfunktionenController implements Initializable {

    @FXML
    public Button add;

    @FXML
    public Button remove;

    @FXML
    private Button ok;

    @FXML
    private Label label;

    @FXML
    private Button cancel;

    @FXML
    private TableView<Produktfunktion> table;

    @FXML
    private TableColumn<Produktfunktion, String> id;

    @FXML
    private TableColumn<Produktfunktion, String> desc;

    @FXML
    private TableColumn<Produktfunktion, Integer> ftr;

    @FXML
    private TableColumn<Produktfunktion, Integer> det;

    private ObservableList<Produktfunktion> produktfunktionen;

    @FXML
    void onClickAbort(MouseEvent event) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onClickSave(MouseEvent event) {
        Anforderungsanalyse.getInstance().setProduktfunktionen(produktfunktionen);
        for (Produktfunktion p : produktfunktionen) {
            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            try {
                System.out.println(ow.writeValueAsString(p));
            } catch (JsonProcessingException ex) {
                Logger.getLogger(ProduktfunktionenController.class.getName()).log(Level.SEVERE, "", ex);
            }
        }
        Stage stage = (Stage) ok.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void onClickAdd(MouseEvent mouseEvent) {
        if (table.getSelectionModel().getSelectedIndex() != -1) {
            produktfunktionen.add(table.getSelectionModel().getSelectedIndex(), new Produktfunktion());
        } else {
            produktfunktionen.add(produktfunktionen.size(), new Produktfunktion());
        }

    }

    @FXML
    public void onClickRemove(MouseEvent mouseEvent) {
        if (table.getSelectionModel().getSelectedIndex() != -1) {
            produktfunktionen.remove(table.getSelectionModel().getSelectedIndex());
        } else if (produktfunktionen.size() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fehler!");
            alert.setHeaderText("Produktfunktion konnte nicht gelöscht werden");
            alert.setContentText("Liste ist leer");
            alert.showAndWait();
        } else {
            produktfunktionen.remove(produktfunktionen.size());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.produktfunktionen = FXCollections.observableArrayList(Anforderungsanalyse.getInstance().getProduktfunktionen());

        table.setItems(produktfunktionen);

        table.setEditable(true);

        table.setPlaceholder(new Label("Klicken zum editieren"));


        /*id.setCellFactory(new Callback<TableColumn<Produktfunktion, String>, TableCell<Produktfunktion, String>>() {
            @Override
            public TableCell<Produktfunktion, String> call(TableColumn<Produktfunktion, String> produktfunktionStringTableColumn) {
                return new TableCell<Produktfunktion, String>() {

                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if(empty){
                            setText("");
                        }
                        else {
                            setText("PF /" + item + "/");

                        }
                        return;
                    }
                };
            }
        });*/

        id.setCellFactory(TextFieldTableCell.forTableColumn());
        id.setOnEditCommit(
                (TableColumn.CellEditEvent<Produktfunktion, String> t) -> {
                    if (table.getItems().stream().anyMatch((i) -> i.getId().equals(t.getNewValue()))) {
                        (t.getTableView().getItems()
                                .get(t.getTablePosition().getRow())
                        ).setId(t.getOldValue());
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Fehler!");
                        alert.setHeaderText("ID konnte nicht gesetzt werden");
                        alert.setContentText("ID existiert bereits");
                        alert.showAndWait();
                    } else if (StringUtils.isNumeric(t.getNewValue())) {
                        (t.getTableView().getItems()
                                .get(t.getTablePosition().getRow())
                        ).setId(t.getNewValue());

                    } else {
                        (t.getTableView().getItems()
                                .get(t.getTablePosition().getRow())
                        ).setId(t.getOldValue());
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Fehler!");
                        alert.setHeaderText("ID konnte nicht gesetzt werden");
                        alert.setContentText("ID muss eine Zahl sein");
                        alert.showAndWait();
                    }
                    table.refresh();
                }
        );

        id.setCellValueFactory(
                new PropertyValueFactory<Produktfunktion, String>("id")
        );
        desc.setCellFactory(TextFieldTableCell.forTableColumn());
        desc.setOnEditCommit(
                t -> {
                    (t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setDesc(t.getNewValue());
                }
        );
        desc.setCellValueFactory(
                new PropertyValueFactory<Produktfunktion, String>("desc")
        );

        ftr.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        ftr.setOnEditCommit(
                t -> (
                        t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                ).setFtr(t.getNewValue())
        );
        ftr.setCellValueFactory(
                new PropertyValueFactory<Produktfunktion, Integer>("ftr")
        );
        det.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        det.setOnEditCommit(
                t -> (t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setDet(t.getNewValue())
        );
        det.setCellValueFactory(
                new PropertyValueFactory<Produktfunktion, Integer>("det")
        );


    }


}

/*if(table.getItems().stream().map((i)->i.getId()).anyMatch((i) -> i == t.getNewValue())) {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Fehler!");
                            alert.setHeaderText("Produktfunktion kann nicht hinzugefügt werden");
                            alert.setContentText("ID existiert bereits");
                            alert.showAndWait();
                        } else {
                            (t.getTableView().getItems().get(
                                    t.getTablePosition().getRow())
                            ).setDesc(t.getNewValue());
                        }*/