package restaurantmenuinterfaces;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RestaurantMenuInterfaces extends Application {

    @Override
    public void start(Stage primaryStage) {

        // ===== CART SCENE =====

        Text title = new Text("Royal Taste - Cart");
        title.setStyle("-fx-font-size:24px; -fx-font-weight:bold;");

        HBox topBox = new HBox(title);
        topBox.setAlignment(Pos.CENTER);
        topBox.setPadding(new Insets(15));

        // ===== Side Menu =====

        Button home = new Button("Home");
        home.setPrefWidth(100);
        home.setStyle("-fx-background-color: green; -fx-text-fill: white;");

        Button menu = new Button("Menu");
        menu.setPrefWidth(100);
        menu.setStyle("-fx-background-color: blue; -fx-text-fill: white;");

        Button cart = new Button("Cart");
        cart.setPrefWidth(100);
        cart.setStyle("-fx-background-color: orange; -fx-text-fill: white;");

        VBox sideMenu = new VBox(20);
        sideMenu.setPadding(new Insets(20));
        sideMenu.getChildren().addAll(home, menu, cart);

        // ===== Cart Items =====

        TextField item1 = new TextField("Burger - 200");
        Button remove1 = new Button("X");
        remove1.setStyle("-fx-background-color:red; -fx-text-fill:white;");

        HBox row1 = new HBox(10, item1, remove1);

        TextField item2 = new TextField("Pizza - 300");
        Button remove2 = new Button("X");
        remove2.setStyle("-fx-background-color:red; -fx-text-fill:white;");

        HBox row2 = new HBox(10, item2, remove2);

        TextField item3 = new TextField("Chicken - 700");
        Button remove3 = new Button("X");
        remove3.setStyle("-fx-background-color:red; -fx-text-fill:white;");

        HBox row3 = new HBox(10, item3, remove3);

        // ===== Cart Area =====

        VBox cartBox = new VBox(20);
        cartBox.getChildren().addAll(row1, row2, row3);

        // ===== Remove Actions =====

        remove1.setOnAction(e -> cartBox.getChildren().remove(row1));
        remove2.setOnAction(e -> cartBox.getChildren().remove(row2));
        remove3.setOnAction(e -> cartBox.getChildren().remove(row3));

        // ===== Total & Checkout =====

        Label totalLabel = new Label("Total Bill: 1200 TK");
        totalLabel.setStyle("-fx-font-size:16px; -fx-font-weight:bold;");

        Button checkout = new Button("Checkout");
        checkout.setStyle("-fx-background-color: green; -fx-text-fill: white;");

        checkout.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Order Complete");
            alert.setHeaderText(null);
            alert.setContentText("Thank You For Your Order!");
            alert.showAndWait();
        });

        cartBox.getChildren().addAll(totalLabel, checkout);

        // ===== Main Layout =====

        HBox mainBox = new HBox(40, sideMenu, cartBox);
        mainBox.setPadding(new Insets(20));

        // ===== Root =====

        BorderPane root = new BorderPane();
        root.setTop(topBox);
        root.setCenter(mainBox);

        // ===== Scene =====

        Scene cartScene = new Scene(root, 700, 450);

        primaryStage.setTitle("Restaurant Cart");
        primaryStage.setScene(cartScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}