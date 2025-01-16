package com.example.dodatni;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private ObservableList<Integer> elemnti = FXCollections.observableArrayList(
            10, 20, 30, 40, 50, 60, 70, 80, 90, 100
    );

    @Override
    public void start(Stage Scena) throws Exception {
        ListView<Integer> listView = new ListView<>(elemnti);

        listView.setOnMouseClicked(event -> {
            int odabraniIndeks = listView.getSelectionModel().getSelectedIndex();
            if (odabraniIndeks < 0) {
                return; // nista
            }

            int trenutnaVr = elemnti.get(odabraniIndeks);
            int sljedeciIndeks = (odabraniIndeks == elemnti.size() - 1) ? 0 : odabraniIndeks + 1;
            int trVr = elemnti.get(sljedeciIndeks);

            if (trenutnaVr < trVr) {
                // Zamjena sa sl
                elemnti.set(odabraniIndeks, trVr);
                elemnti.set(sljedeciIndeks, trenutnaVr);
            } else if (trenutnaVr > trVr) {
                // Zamjena sa pr
                int prethodniIndeks = (odabraniIndeks == 0) ? elemnti.size() - 1 : odabraniIndeks - 1;
                int prethodnaVr = elemnti.get(prethodniIndeks);

                if (trenutnaVr > prethodnaVr) {
                    elemnti.set(prethodniIndeks, trenutnaVr);
                    elemnti.set(odabraniIndeks, prethodnaVr);
                }
            }
        });

        StackPane glavni = new StackPane();
        glavni.getChildren().add(listView);

        Scene scene = new Scene(glavni, 400, 300);

        Scena.setTitle("Lista sa zamjenom elemenata");
        Scena.setScene(scene);
        Scena.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
