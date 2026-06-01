/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package project1;

import java.awt.Insets;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class Project1 extends Application {
 @Override
    public void start(Stage primaryStage) {

    // Top Text
    Text t = new Text("Royal Taste ");
    t.setStyle("-fx-font-size:24px; -fx-font-weight:bold;");
        HBox topBox = new HBox(t);
        topBox.setSpacing(10);

        // Left Menu
        Button home = new Button("Home");
        Button menu = new Button("Menu");
        Button cart = new Button("Cart");

        VBox sideMenu = new VBox(home, menu, cart);
        sideMenu.setSpacing(40);

        // Food Item 1
        VBox item1 = new VBox(
                new Text("Burger"),
                new Text("Price: 200"),
                new Button("Add to Cart"));
        item1.setSpacing(10);

        // Food Item 2
        VBox item2 = new VBox(
                new Text("Pizza"),
                new Text("Price: 300"),
                new Button("Add to Cart"));
        item2.setSpacing(10);

        // Food Item 3
        VBox item3 = new VBox(
                new Text("Fried Rice"),
                new Text("Price: 600"),
                new Button("Add to Cart"));
        item3.setSpacing(10);

        // Food Item 4
        VBox item4 = new VBox(
                new Text("Chicken"),
                new Text("Price: 700"),
                new Button("Add to Cart"));
        item4.setSpacing(10);

        
        HBox row1 = new HBox(item1, item2);
        row1.setSpacing(80);

        HBox row2 = new HBox(item3, item4);
        row2.setSpacing(80);

        VBox centerBox = new VBox(row1, row2);
        centerBox.setSpacing(50);

        
        HBox mainBox = new HBox(sideMenu, centerBox);
        mainBox.setSpacing(30);

       
        BorderPane root = new BorderPane();
        root.setTop(topBox);
        root.setCenter(mainBox);

        Scene scene = new Scene(root, 600, 400);

        primaryStage.setTitle("Restaurant Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
