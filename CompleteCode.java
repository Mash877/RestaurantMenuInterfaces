package restaurantmenuinterfaces;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class CompleteCode extends Application {

    private VBox cartItems = new VBox(10);
    private Label totalLabel = new Label("Total Bill: 0 TK");
    private int total = 0;

    @Override
    public void start(Stage stage) {

        BorderPane root = new BorderPane();

        // ================= SIDEBAR =================

        Button homeBtn = new Button("🏠 Home");
        Button menuBtn = new Button("📋 Menu");
        Button cartBtn = new Button("🛒 Cart");

        homeBtn.setPrefSize(180, 50);
        menuBtn.setPrefSize(180, 50);
        cartBtn.setPrefSize(180, 50);

        homeBtn.setStyle("-fx-background-color:#28a745; -fx-text-fill:white; -fx-font-size:16px;");
        menuBtn.setStyle("-fx-background-color:#007bff; -fx-text-fill:white; -fx-font-size:16px;");
        cartBtn.setStyle("-fx-background-color:#ff9800; -fx-text-fill:white; -fx-font-size:16px;");

        VBox sidebar = new VBox(20, homeBtn, menuBtn, cartBtn);
        sidebar.setPadding(new Insets(20));
        sidebar.setAlignment(Pos.TOP_CENTER);
        sidebar.setStyle("-fx-background-color:#08264d;");

        // ================= HOME PAGE =================

        VBox homePage = new VBox(15);
        homePage.setAlignment(Pos.CENTER);

        try {
            Image logo = new Image("file:logo.png");
            ImageView logoView = new ImageView(logo);

            logoView.setFitWidth(150);
            logoView.setFitHeight(150);
            logoView.setPreserveRatio(true);

            homePage.getChildren().add(logoView);
        } catch (Exception e) {
            System.out.println("Logo not found");
        }

        Label title = new Label("ROYAL TASTE");
        title.setStyle("-fx-font-size:50px; -fx-font-weight:bold; -fx-text-fill:#7A1128;");

        Label restaurant = new Label("R E S T A U R A N T");
        restaurant.setStyle("-fx-font-size:28px;");

        Label tagline = new Label("Fresh Food, Happy Mood ♡");
        tagline.setStyle("-fx-font-size:22px; -fx-text-fill:#C89B3C;");

        Label welcome = new Label("Welcome To Our Restaurant!");
        welcome.setStyle("-fx-font-size:24px; -fx-font-weight:bold;");

        Label story = new Label(
                "Our restaurant started its journey in 2015.\n"
                + "We provide fresh and quality food.\n"
                + "Customer satisfaction is our first priority."
        );

        story.setTextAlignment(TextAlignment.CENTER);
        story.setStyle("-fx-font-size:18px;");

        Button enjoy = new Button("Enjoy Your Meal 🍴");
        enjoy.setStyle(
                "-fx-background-color:#7A1128;"
                + "-fx-text-fill:white;"
                + "-fx-font-size:18px;"
        );

        homePage.getChildren().addAll(
                title,
                restaurant,
                tagline,
                welcome,
                story,
                enjoy
        );

        // ================= MENU PAGE =================

        VBox menuPage = new VBox(25);
        menuPage.setPadding(new Insets(30));
        menuPage.setAlignment(Pos.CENTER);

        HBox row1 = new HBox(40,
                createFoodItem("🍔 Burger", 200),
                createFoodItem("🍕 Pizza", 300)
        );

        HBox row2 = new HBox(40,
                createFoodItem("🍚 Fried Rice", 600),
                createFoodItem("🍗 Chicken", 700)
        );

        row1.setAlignment(Pos.CENTER);
        row2.setAlignment(Pos.CENTER);

        menuPage.getChildren().addAll(row1, row2);

        // ================= CART PAGE =================

        Label cartTitle = new Label("🛒 Shopping Cart");
        cartTitle.setStyle("-fx-font-size:30px; -fx-font-weight:bold;");

        totalLabel.setStyle(
                "-fx-font-size:22px;"
                + "-fx-font-weight:bold;"
                + "-fx-text-fill:green;"
        );

        Button checkout = new Button("Checkout");

        checkout.setStyle(
                "-fx-background-color:green;"
                + "-fx-text-fill:white;"
                + "-fx-font-size:18px;"
        );

        checkout.setOnAction(e -> {

            Alert alert =
                    new Alert(Alert.AlertType.INFORMATION);

            alert.setTitle("Order Complete");
            alert.setHeaderText("Royal Taste");

            alert.setContentText(
                    "Thank You For Your Order!\n\n"
                    + "Total Paid: " + total + " TK"
            );

            alert.showAndWait();
        });

        VBox cartPage = new VBox(
                20,
                cartTitle,
                cartItems,
                totalLabel,
                checkout
        );

        cartPage.setAlignment(Pos.TOP_CENTER);
        cartPage.setPadding(new Insets(30));

        // ================= NAVIGATION =================

        homeBtn.setOnAction(e -> root.setCenter(homePage));

        menuBtn.setOnAction(e -> root.setCenter(menuPage));

        cartBtn.setOnAction(e -> root.setCenter(cartPage));

        // ================= ROOT =================

        root.setLeft(sidebar);
        root.setCenter(homePage);

        Scene scene = new Scene(root, 1200, 700);

        stage.setTitle("Royal Taste Restaurant");
        stage.setScene(scene);
        stage.show();
    }

    // ================= FOOD ITEM CARD =================

    private VBox createFoodItem(String name, int price) {

        Label foodName = new Label(name);
        foodName.setStyle(
                "-fx-font-size:20px;"
                + "-fx-font-weight:bold;"
        );

        Label foodPrice = new Label(
                "Price: " + price + " TK"
        );

        Button addBtn = new Button("Add To Cart");

        addBtn.setStyle(
                "-fx-background-color:red;"
                + "-fx-text-fill:white;"
                + "-fx-font-size:14px;"
        );

        addBtn.setOnAction(e -> addToCart(name, price));

        VBox box = new VBox(
                10,
                foodName,
                foodPrice,
                addBtn
        );

        box.setAlignment(Pos.CENTER);

        box.setPadding(new Insets(20));

        box.setPrefSize(220, 180);

        box.setStyle(
                "-fx-background-color:white;"
                + "-fx-border-color:lightgray;"
                + "-fx-border-radius:10;"
                + "-fx-background-radius:10;"
        );

        return box;
    }

    // ================= ADD TO CART =================

    private void addToCart(String name, int price) {

        Label item = new Label(
                name + " - " + price + " TK"
        );

        Button remove = new Button("X");

        remove.setStyle(
                "-fx-background-color:red;"
                + "-fx-text-fill:white;"
        );

        HBox row = new HBox(
                20,
                item,
                remove
        );

        row.setAlignment(Pos.CENTER);

        remove.setOnAction(e -> {

            cartItems.getChildren().remove(row);

            total -= price;

            totalLabel.setText(
                    "Total Bill: "
                    + total
                    + " TK"
            );
        });

        cartItems.getChildren().add(row);

        total += price;

        totalLabel.setText(
                "Total Bill: "
                + total
                + " TK"
        );
    }

    public static void main(String[] args) {
        launch(args);
    }
}