package restaurantmenuinterfaces;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ImprovedCode extends Application {

    @Override
    public void start(Stage primaryStage) {

        // ===== TITLE =====
        Text title = new Text("Royal Taste - Cart");
        title.setStyle("-fx-font-size:24px; -fx-font-weight:bold;");

        HBox topBox = new HBox(title);
        topBox.setAlignment(Pos.CENTER);
        topBox.setPadding(new Insets(15));

        // ===== SIDE MENU =====
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

        // ===== TOTAL BILL =====
        final int[] total = {1200};

        Label totalLabel = new Label("Total Bill: " + total[0] + " TK");
        totalLabel.setStyle("-fx-font-size:16px; -fx-font-weight:bold;");

        // ===== ITEM 1 =====
        TextField item1 = new TextField("Burger - 200 TK");
        item1.setEditable(false);

        Button remove1 = new Button("X");
        remove1.setStyle("-fx-background-color:red; -fx-text-fill:white;");

        HBox row1 = new HBox(10, item1, remove1);

        // ===== ITEM 2 =====
        TextField item2 = new TextField("Pizza - 300 TK");
        item2.setEditable(false);

        Button remove2 = new Button("X");
        remove2.setStyle("-fx-background-color:red; -fx-text-fill:white;");

        HBox row2 = new HBox(10, item2, remove2);

        // ===== ITEM 3 =====
        TextField item3 = new TextField("Chicken - 700 TK");
        item3.setEditable(false);

        Button remove3 = new Button("X");
        remove3.setStyle("-fx-background-color:red; -fx-text-fill:white;");

        HBox row3 = new HBox(10, item3, remove3);

        // ===== CART BOX =====
        VBox cartBox = new VBox(20);
        cartBox.getChildren().addAll(row1, row2, row3);

        // ===== REMOVE ACTIONS =====
        remove1.setOnAction(e -> {
            cartBox.getChildren().remove(row1);
            total[0] -= 200;
            totalLabel.setText("Total Bill: " + total[0] + " TK");
        });

        remove2.setOnAction(e -> {
            cartBox.getChildren().remove(row2);
            total[0] -= 300;
            totalLabel.setText("Total Bill: " + total[0] + " TK");
        });

        remove3.setOnAction(e -> {
            cartBox.getChildren().remove(row3);
            total[0] -= 700;
            totalLabel.setText("Total Bill: " + total[0] + " TK");
        });

        // ===== CHECKOUT BUTTON =====
        Button checkout = new Button("Checkout");
        checkout.setStyle("-fx-background-color: green; -fx-text-fill: white;");

        checkout.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Order Complete");
            alert.setHeaderText(null);
            alert.setContentText(
                    "Thank You For Your Order!\n\nTotal Paid: "
                            + total[0] + " TK");
            alert.showAndWait();
        });

        cartBox.getChildren().addAll(totalLabel, checkout);

        // ===== MAIN LAYOUT =====
        HBox mainBox = new HBox(40, sideMenu, cartBox);
        mainBox.setPadding(new Insets(20));

        // ===== ROOT =====
        BorderPane root = new BorderPane();
        root.setTop(topBox);
        root.setCenter(mainBox);

        // ===== SCENE =====
        Scene scene = new Scene(root, 700, 450);

        primaryStage.setTitle("Restaurant Cart");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}