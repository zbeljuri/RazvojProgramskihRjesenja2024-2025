package com.example.lab9Z1.controller;

import com.example.lab9Z1.model.Osoba;
import com.example.lab9Z1.model.OsobaModel;
import com.example.lab9Z1.model.Uloga;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class OsobaController
{
    @FXML
    private Label ucitavanjeLabel;
    @FXML
    private ListView<Osoba> osobeListView;
    @FXML
    private TextField imeField;
    @FXML
    private TextField prezimeField;
    @FXML
    private TextField adresaField;
    @FXML
    private DatePicker datumRodjenjaPicker;
    @FXML
    private TextField maticniBrojField;
    @FXML
    private ChoiceBox<Uloga> ulogaChoiceBox;
    @FXML
    private Button azurirajOsobuButton;
    @FXML
    private Label porukaLabel;


    private OsobaModel model;


    private ObservableList<Osoba> osobeObservableList = FXCollections.observableArrayList();


    private Osoba izabranaOsoba;


    public OsobaController(OsobaModel model) {
        this.model = model;
    }

    @FXML
    public void initialize() {
        OsobaModel.kreirajTabeluAkoNePostoji();
        OsobaModel.isprazniTabeluOsoba();
        OsobaModel.napuniInicijalnimPodacima();
        ucitavanjeLabel.setText("Ucitani podaci");
        ucitavanjeLabel.setStyle("-fx-background-color: green;");


        azurirajOsobuButton.setText("Azuriraj");


        ulogaChoiceBox.getItems().addAll(Uloga.STUDENT, Uloga.NASTAVNO_OSOBLJE);


        ucitajOsobeIzBaze();
        osobeListView.setItems(osobeObservableList);


        // dodavanje listener-a za klik dugmeta
        azurirajOsobuButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                azurirajOsobu();
            }
        });


        // dodavanje listener-a za izbor osobe iz listview
        osobeListView.getSelectionModel().selectedItemProperty().addListener((observable, starVrijednost, novaVrijednost) -> {
            if (novaVrijednost != null) {
                izabranaOsoba = novaVrijednost;  // azuriranje varijable koja predstavlja trenutno izabranu osobu
                ispuniPolja(novaVrijednost);  // ispunjavanje polja detaljima izabrane osobe
                porukaLabel.setVisible(false); // sakrij labelu koja sadrzi poruku
            }
        });
    }


    private void ucitajOsobeIzBaze() {
        List<Osoba> osobe = OsobaModel.dajSveOsobe();
        osobeObservableList.setAll(osobe);
    }


    private void ispuniPolja(Osoba osoba) {
        imeField.setText(osoba.getIme());
        prezimeField.setText(osoba.getPrezime());
        adresaField.setText(osoba.getAdresa());
        datumRodjenjaPicker.setValue(osoba.getDatumRodjenja().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        maticniBrojField.setText(osoba.getMaticniBroj());
        ulogaChoiceBox.setValue(osoba.getUloga());
    }


    public OsobaModel getModel() {
        return model;
    }

    public void setModel(OsobaModel model) {
        this.model = model;
    }

    private void azurirajOsobu() {
        if(izabranaOsoba != null) {
            // procitaj sadrzaj input polja
            String ime = imeField.getText();
            String prezime = prezimeField.getText();
            String adresa = adresaField.getText();
            LocalDate datumRodjenjaLocal = datumRodjenjaPicker.getValue();
            String maticniBroj = maticniBrojField.getText();
            Uloga uloga = ulogaChoiceBox.getValue();
            // validacija polja forme
            if (ime.isEmpty() || prezime.isEmpty() || adresa.isEmpty() || maticniBroj.isEmpty() || datumRodjenjaLocal==null || uloga==null) {
                porukaLabel.setVisible(true);
                porukaLabel.setText("Sva polja moraju biti popunjena!");
                return;
            }
            Date datumRodjenja = Date.from(datumRodjenjaLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());
            String poruka = model.azurirajOsobu(izabranaOsoba.getId(), ime, prezime, adresa, datumRodjenja, maticniBroj, uloga);
            porukaLabel.setVisible(true);
            porukaLabel.setText(poruka);
            ucitajOsobeIzBaze();
            osobeListView.refresh();
        }
    }
}
