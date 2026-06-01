/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package hotel;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class Hotel extends Application {
    
     @Override
    public void start(Stage primaryStage) {

        // Top Title
        Text t = new Text("Royel Taste");
        t.setStyle("-fx-font-size:24px; -fx-font-weight:bold;");
        HBox topBox = new HBox(t);

        // Left Menu 
        Button home = new Button("Home");
        home.setStyle("-fx-background-color: green; -fx-text-fill: white;");

        Button menu = new Button("Menu");
        menu.setStyle("-fx-background-color: blue; -fx-text-fill: white;");

        Button cart = new Button("Cart");
        cart.setStyle("-fx-background-color: orange; -fx-text-fill: white;");

        VBox sideMenu = new VBox(home, menu, cart);
        sideMenu.setSpacing(40);

        // Food Buttons 
        Button add1 = new Button("Add to Cart");
        add1.setStyle("-fx-background-color: red; -fx-text-fill: white;");

        Button add2 = new Button("Add to Cart");
        add2.setStyle("-fx-background-color: red; -fx-text-fill: white;");

        Button add3 = new Button("Add to Cart");
        add3.setStyle("-fx-background-color: red; -fx-text-fill: white;");

        Button add4 = new Button("Add to Cart");
        add4.setStyle("-fx-background-color: red; -fx-text-fill: white;");

        // Food Items
        VBox item1 = new VBox(new Text("Burger"), new Text("Price: 200"), add1);
        item1.setSpacing(10);

        VBox item2 = new VBox(new Text("Pizza"), new Text("Price: 300"), add2);
        item2.setSpacing(10);

        VBox item3 = new VBox(new Text("Fried Rice"), new Text("Price: 600"), add3);
        item3.setSpacing(10);

        VBox item4 = new VBox(new Text("Chicken"), new Text("Price: 700"), add4);
        item4.setSpacing(10);

        
        HBox row1 = new HBox(item1, item2);
        row1.setSpacing(80);

        HBox row2 = new HBox(item3, item4);
        row2.setSpacing(80);

        VBox centerBox = new VBox(row1, row2);
        centerBox.setSpacing(50);

        
        HBox mainBox = new HBox(sideMenu, centerBox);
        mainBox.setSpacing(30);

        // Root
        BorderPane root = new BorderPane();
        root.setTop(topBox);
        root.setCenter(mainBox);

        // Scene
        Scene scene = new Scene(root, 600, 400);

        primaryStage.setTitle("Restaurant Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}