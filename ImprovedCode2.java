package restaurantmenuinterfaces;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ImprovedCode2 extends Application {

    @Override
    public void start(Stage primaryStage) {

        // ================= TITLE =================

        Label title = new Label("👑 Royal Taste - Cart");
        title.setStyle(
                "-fx-font-size: 34px;"
                + "-fx-font-weight: bold;"
                + "-fx-text-fill: #d4a017;"
        );

        HBox titleBox = new HBox(title);
        titleBox.setAlignment(Pos.CENTER);
        titleBox.setPadding(new Insets(20));

        // ================= SIDEBAR =================

        Button homeBtn = new Button("🏠 Home");
        Button menuBtn = new Button("📋 Menu");
        Button cartBtn = new Button("🛒 Cart");

        homeBtn.setPrefSize(180, 50);
        menuBtn.setPrefSize(180, 50);
        cartBtn.setPrefSize(180, 50);

        homeBtn.setStyle(
                "-fx-background-color:#14a414;"
                + "-fx-text-fill:white;"
                + "-fx-font-size:18px;"
                + "-fx-font-weight:bold;"
        );

        menuBtn.setStyle(
                "-fx-background-color:#0066ff;"
                + "-fx-text-fill:white;"
                + "-fx-font-size:18px;"
                + "-fx-font-weight:bold;"
        );

        cartBtn.setStyle(
                "-fx-background-color:#ff9800;"
                + "-fx-text-fill:white;"
                + "-fx-font-size:18px;"
                + "-fx-font-weight:bold;"
        );

        VBox sidebar = new VBox(25, homeBtn, menuBtn, cartBtn);
        sidebar.setPadding(new Insets(30));
        sidebar.setAlignment(Pos.TOP_CENTER);

        sidebar.setStyle(
                "-fx-background-color:#08264d;"
                + "-fx-background-radius:20;"
        );

        // ================= TOTAL =================

        final int[] total = {1200};

        Label totalLabel = new Label("Total Bill : 1200 TK");
        totalLabel.setStyle(
                "-fx-font-size:28px;"
                + "-fx-font-weight:bold;"
                + "-fx-text-fill:green;"
        );

        // ================= ITEMS =================

        VBox itemBox = new VBox(20);

        itemBox.getChildren().addAll(

                createItem("🍔 Burger - 200 TK", 200, total, totalLabel, itemBox),
                createItem("🍕 Pizza - 300 TK", 300, total, totalLabel, itemBox),
                createItem("🍗 Chicken - 700 TK", 700, total, totalLabel, itemBox)
        );

        // ================= BILL SECTION =================

        Button checkout = new Button("Checkout");
        checkout.setPrefSize(200, 50);

        checkout.setStyle(
                "-fx-background-color:green;"
                + "-fx-text-fill:white;"
                + "-fx-font-size:20px;"
                + "-fx-font-weight:bold;"
                + "-fx-background-radius:10;"
        );

        checkout.setOnAction(e -> {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Order Complete");
            alert.setHeaderText("Royal Taste");

            alert.setContentText(
                    "Thank You For Your Order!\n\n"
                    + "Total Paid: " + total[0] + " TK"
            );

            alert.showAndWait();
        });

        VBox billSection = new VBox(20, totalLabel, checkout);

        billSection.setAlignment(Pos.CENTER);

        billSection.setPadding(new Insets(25));

        billSection.setStyle(
                "-fx-background-color:#f4fff4;"
                + "-fx-border-color:lightgreen;"
                + "-fx-border-radius:15;"
                + "-fx-background-radius:15;"
        );

        VBox centerContent = new VBox(25);

        centerContent.getChildren().addAll(
                itemBox,
                billSection
        );

        centerContent.setPadding(new Insets(20));

        // ================= MAIN CONTENT =================

        HBox body = new HBox(30);

        body.getChildren().addAll(
                sidebar,
                centerContent
        );

        body.setPadding(new Insets(20));

        BorderPane root = new BorderPane();

        root.setTop(titleBox);
        root.setCenter(body);

        root.setStyle(
                "-fx-background-color:#f7f7f7;"
        );

        Scene scene = new Scene(root, 1000, 650);

        primaryStage.setTitle("Royal Taste Cart");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private HBox createItem(
            String name,
            int price,
            int[] total,
            Label totalLabel,
            VBox itemBox) {

        Label itemLabel = new Label(name);

        itemLabel.setStyle(
                "-fx-font-size:22px;"
                + "-fx-font-weight:bold;"
        );

        Button remove = new Button("X");

        remove.setStyle(
                "-fx-background-color:red;"
                + "-fx-text-fill:white;"
                + "-fx-font-size:18px;"
                + "-fx-font-weight:bold;"
        );

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        HBox row = new HBox(
                20,
                itemLabel,
                spacer,
                remove
        );

        row.setAlignment(Pos.CENTER_LEFT);

        row.setPadding(new Insets(20));

        row.setStyle(
                "-fx-background-color:white;"
                + "-fx-background-radius:15;"
                + "-fx-border-color:#e5e5e5;"
                + "-fx-border-radius:15;"
        );

        remove.setOnAction(e -> {

            itemBox.getChildren().remove(row);

            total[0] -= price;

            totalLabel.setText(
                    "Total Bill : "
                    + total[0]
                    + " TK"
            );
        });

        return row;
    }

    public static void main(String[] args) {
        launch(args);
    }
}