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
import model.Produktdaten;
import org.apache.commons.lang3.StringUtils;
import utils.Convert;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class ProduktdatenController implements Initializable {
    @FXML
    private Label label;

    @FXML
    private Button ok;

    @FXML
    private Button cancel;

    @FXML
    private TableView<Produktdaten> table;

    @FXML
    private TableColumn<Produktdaten, String> id;

    @FXML
    private TableColumn<Produktdaten, String> desc;

    @FXML
    private TableColumn<Produktdaten, Integer> ret;

    @FXML
    private TableColumn<Produktdaten, Integer> det;

    @FXML
    private TableColumn<Produktdaten, String> type;

    @FXML
    private Button add;

    @FXML
    private Button remove;

    private ObservableList<Produktdaten> produktdaten;

    @FXML
    void onClickAbort(MouseEvent event) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onClickSave(MouseEvent event) {
        produktdaten = produktdaten.stream().filter(i -> !StringUtils.isEmpty(i.getId()))
                .filter(i -> !StringUtils.isEmpty(i.getType()))
                .collect(Collectors.collectingAndThen(toList(), l -> FXCollections.observableArrayList(l)));
        Anforderungsanalyse.getInstance().setProduktdaten(produktdaten);
        for (Produktdaten p : produktdaten) {
            System.out.println(Convert.toJSON(p));
        }
        Stage stage = (Stage) ok.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void onClickAdd(MouseEvent mouseEvent) {
        if (table.getSelectionModel().getSelectedIndex() != -1) {
            produktdaten.add(table.getSelectionModel().getSelectedIndex(), new Produktdaten());
        } else {
            produktdaten.add(produktdaten.size(), new Produktdaten());
        }

    }

    @FXML
    public void onClickRemove(MouseEvent mouseEvent) {
        if (table.getSelectionModel().getSelectedIndex() != -1) {
            produktdaten.remove(table.getSelectionModel().getSelectedIndex());
        } else if (produktdaten.size() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Fehler!");
            alert.setHeaderText("Produktdaten konnten nicht gelöscht werden");
            alert.setContentText("Liste ist leer");
            alert.showAndWait();
        } else {
            produktdaten.remove(produktdaten.size());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.produktdaten = FXCollections.observableArrayList(Anforderungsanalyse.getInstance().getProduktdaten());
        table.setItems(produktdaten);
        table.setEditable(true);
        table.setPlaceholder(new Label("Klicken zum editieren"));

        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        type.setCellFactory(ComboBoxTableCell.forTableColumn("EIF", "ILF"));
        type.setOnEditCommit(
                event -> table.getItems().get(event.getTablePosition().getRow())
                        .setType(event.getNewValue()));

        id.setCellFactory(TextFieldTableCell.forTableColumn());
        id.setOnEditCommit(
                (TableColumn.CellEditEvent<Produktdaten, String> t) -> {
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
                new PropertyValueFactory<Produktdaten, String>("id")
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
                new PropertyValueFactory<Produktdaten, String>("desc")
        );

        ret.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        ret.setOnEditCommit(
                t -> (
                        t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                ).setRet(t.getNewValue())
        );
        ret.setCellValueFactory(
                new PropertyValueFactory<Produktdaten, Integer>("ret")
        );
        det.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        det.setOnEditCommit(
                t -> (t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setDet(t.getNewValue())
        );
        det.setCellValueFactory(
                new PropertyValueFactory<Produktdaten, Integer>("det")
        );
    }
}
