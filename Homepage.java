/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package homepage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class Homepage extends Application {
    
    @Override
    public void start(Stage stage) {

        // Logo
        Label logo = new Label("🍽");
        logo.setFont(new Font(40));

        // Restaurant Name
        Label name = new Label("ROYAL TASTE");
        name.setFont(new Font(28));

        // Tagline
        Label tagline = new Label("Fresh Food, Happy Mood ❤️");
        tagline.setFont(new Font(16));

        // History Section
        Label history = new Label(
                "Our restaurant started in 2015.\n" +
                "We serve fresh and hygienic food."
        );

        history.setFont(new Font(14));

        // Layout
        VBox root = new VBox(15);
        root.getChildren().addAll(
                logo,
                name,
                tagline,
                history
        );

        root.setAlignment(Pos.CENTER);

        // Scene
        Scene scene = new Scene(root, 700, 450);

        // Stage
        stage.setTitle("Restaurant App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
