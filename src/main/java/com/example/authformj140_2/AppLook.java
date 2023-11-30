package com.example.authformj140_2;
import DBConnect.UserRepImpl;
import Looks.PersonLook;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AppLook extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label welcomeLabel = new Label ("WELCOME");
        Label nameLabel = new Label ("User Name:  ");
        TextField textName = new TextField();
        Label passwordLabel = new Label("Password:  ");
        TextField textPassword = new TextField();
        Button buttonSignIn = new Button("Sign in");
        Label textLabel = new Label ("Check connection status");


        buttonSignIn.setOnAction((ActionEvent) -> {
            new UserRepImpl().getUsers().forEach(e -> {
                if (textName.getText().equals(e.getName()) && textPassword.getText().equals(e.getPassword())) {
                    textLabel.setText("Valid data");
                    primaryStage.hide();
                    new PersonLook().show();
                } else {
                    textLabel.setText("Invalid data");
                }
            });
        });


        StackPane stackPane = new StackPane();
        GridPane gridPane = new GridPane();
        StackPane.setMargin(gridPane, new Insets(50,50,50,50));
        gridPane.setHgap(5);
        gridPane.setVgap(10);

        GridPane.setConstraints(welcomeLabel, 0, 0, 2, 1);
        welcomeLabel.setFont(Font.font ("Arial", 20));
        welcomeLabel.setStyle("-fx-font-weight: bold");
        GridPane.setConstraints(nameLabel, 0, 1);
        nameLabel.setStyle("-fx-font-size: 12");
        GridPane.setConstraints(textName, 1, 1);
        textName.setStyle("-fx-font-size: 9");
        textName.setText("admin");
        GridPane.setConstraints(passwordLabel, 0, 2);
        passwordLabel.setStyle("-fx-font-size: 12");
        GridPane.setConstraints(textPassword, 1, 2);
        textPassword.setStyle("-fx-font-size: 9");
        textPassword.setText("admin");
        GridPane.setConstraints(buttonSignIn, 1, 3, 1,1, HPos.RIGHT, VPos.BOTTOM);
        buttonSignIn.setStyle("-fx-font-size: 10");
        buttonSignIn.setStyle("-fx-font-weight: bold");
        buttonSignIn.setStyle("-fx-background-color: lightgrey");
        buttonSignIn.setStyle("-fx-border-color: grey");
        GridPane.setConstraints(textLabel, 0, 4, 2, 1, HPos.CENTER, VPos.CENTER);

        stackPane.getChildren().add(gridPane);
        gridPane.getChildren().addAll(welcomeLabel, nameLabel, textName, passwordLabel, textPassword, buttonSignIn, textLabel);

        Scene scene = new Scene(stackPane, 305, 275);
        primaryStage.setResizable(false);
        primaryStage.setTitle("JavaFX Welcome");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void onHelloButtonClick(ActionEvent actionEvent) {
    }
}
