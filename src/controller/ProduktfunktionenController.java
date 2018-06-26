package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;
import model.Anforderungsanalyse;
import model.Produktfunktion;
import org.apache.commons.lang3.StringUtils;
import utils.Convert;

import java.net.URL;
import java.util.ResourceBundle;

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

    @FXML
    public TableColumn<Produktfunktion, String> type;

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
            System.out.println(Convert.toJSON(p));
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

        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        type.setCellFactory(ComboBoxTableCell.forTableColumn("EIF", "ILF"));
        type.setOnEditCommit(
                event -> table.getItems().get(event.getTablePosition().getRow())
                        .setType(event.getNewValue()));

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