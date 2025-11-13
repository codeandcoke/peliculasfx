package com.svalero.peliculasfx;

import com.svalero.peliculasfx.model.Movie;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

public class ApplicationController {

    private List<Movie> movieList;

    @FXML
    private TextField nameField;
    @FXML
    private TextField genderField;
    @FXML
    private Label statusBar;
    @FXML
    private Button saveButton;
    @FXML
    private Button newButton;
    @FXML
    private Button cancelButton;
    @FXML
    private ListView movieListView;

    public ApplicationController() {
        movieList = new ArrayList<>();
    }

    @FXML
    protected void newMovie(ActionEvent event) {
        nameField.setEditable(true);
        nameField.setText("");
        nameField.requestFocus();
        genderField.setEditable(true);
        genderField.setText("");

        saveButton.setDisable(false);
        newButton.setDisable(true);
        cancelButton.setDisable(false);

        statusBar.setText("");
    }

    @FXML
    protected void modifyMovie(ActionEvent event) {

    }

    @FXML
    protected void deleteMovie(ActionEvent event) {

    }

    @FXML
    protected void saveMovie(ActionEvent event) {
        if (nameField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("El nombre es un campo obligatorio");
            alert.show();
            return;
        }

        String name = nameField.getText();
        String gender = genderField.getText();
        Movie movie = new Movie(name, gender);
        movieList.add(movie);
        statusBar.setText("Pelicula añadida correctamente");

        nameField.setEditable(false);
        genderField.setEditable(false);
        saveButton.setDisable(true);
        newButton.setDisable(false);
        cancelButton.setDisable(true);

        refreshMovieListView();
    }

    @FXML
    protected void loadMovie(MouseEvent event) {
        int index = movieListView.getSelectionModel().getSelectedIndex();
        if (index == -1) {
            return;
        }

        Movie movie = movieList.get(index);
        nameField.setText(movie.getName());
        genderField.setText(movie.getGender());
    }

    @FXML
    protected void cancel(ActionEvent event) {
        newButton.setDisable(false);
        saveButton.setDisable(true);
        cancelButton.setDisable(true);

        // FIXME Evitar repeticiones
        nameField.setEditable(false);
        genderField.setEditable(false);
        saveButton.setDisable(true);
        newButton.setDisable(false);
    }

    private void refreshMovieListView() {
        movieListView.getItems().clear();
        for (Movie theMovie : movieList) {
            movieListView.getItems().add(theMovie.getName());
        }
    }
}
