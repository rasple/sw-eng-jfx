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
import model.Produktfunktion_I;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

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
    private TableView<Produktfunktion_I> table;

    @FXML
    private TableColumn<Produktfunktion_I, String> id;

    @FXML
    private TableColumn<Produktfunktion_I, String> desc;

    @FXML
    private TableColumn<Produktfunktion_I, Integer> ftr;

    @FXML
    private TableColumn<Produktfunktion_I, Integer> det;

    @FXML
    public TableColumn<Produktfunktion_I, String> type;

    private ObservableList<Produktfunktion_I> produktfunktionen;

    @FXML
    void onClickAbort(MouseEvent event) {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onClickSave(MouseEvent event) {
        produktfunktionen = produktfunktionen.stream().filter(i -> !StringUtils.isEmpty(i.getId()))
                .filter(i -> !StringUtils.isEmpty(i.getType()))
                .collect(Collectors.collectingAndThen(toList(), l -> FXCollections.observableArrayList(l)));

        Anforderungsanalyse.getInstance().setProduktfunktionen(new ArrayList<>(produktfunktionen));
        for (Produktfunktion_I p : produktfunktionen) {
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
        try {
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
        } catch (Exception ex) {

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        this.produktfunktionen = FXCollections.observableArrayList(Anforderungsanalyse.getInstance().getProduktfunktionen());

        table.setItems(produktfunktionen);

        table.setEditable(true);

        table.setPlaceholder(new Label("Klicken zum editieren"));

        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        type.setCellFactory(ComboBoxTableCell.forTableColumn("EI", "EO", "EQ"));
        type.setOnEditCommit(
                event -> table.getItems().get(event.getTablePosition().getRow())
                        .setType(event.getNewValue()));

        id.setCellFactory(TextFieldTableCell.forTableColumn());
        id.setOnEditCommit(
                (TableColumn.CellEditEvent<Produktfunktion_I, String> t) -> {
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
                new PropertyValueFactory<Produktfunktion_I, String>("id")
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
                new PropertyValueFactory<Produktfunktion_I, String>("desc")
        );

        ftr.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        ftr.setOnEditCommit(
                t -> (
                        t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                ).setFtr(t.getNewValue())
        );
        ftr.setCellValueFactory(
                new PropertyValueFactory<Produktfunktion_I, Integer>("ftr")
        );
        det.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        det.setOnEditCommit(
                t -> (t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                ).setDet(t.getNewValue())
        );
        det.setCellValueFactory(
                new PropertyValueFactory<Produktfunktion_I, Integer>("det")
        );


    }


}
