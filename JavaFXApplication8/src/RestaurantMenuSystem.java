import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class RestaurantMenuSystem extends Application {

    @Override
    public void start(Stage stage) {

        // SIDEBAR
        Button home = new Button("Home");
        Button menu = new Button("Menu");
        Button cart = new Button("Cart");

        home.setPrefSize(200, 60);
        menu.setPrefSize(200, 60);
        cart.setPrefSize(200, 60);

        String btnStyle = "-fx-font-size:18px; -fx-font-weight:bold;";
        home.setStyle(btnStyle);
        menu.setStyle(btnStyle);
        cart.setStyle(btnStyle);

        VBox sidebar = new VBox(20, home, menu, cart);
        sidebar.setPadding(new Insets(20));
        sidebar.setAlignment(Pos.TOP_CENTER);
        sidebar.setStyle("-fx-background-color:#F2F2F2;");

        //HOME PAGE 
      Image logoImage = new Image("file:logo.png");
ImageView logoView = new ImageView(logoImage);

logoView.setFitWidth(150);
logoView.setFitHeight(150);
logoView.setPreserveRatio(true);
        Label title = new Label("ROYAL TASTE");
        title.setStyle("-fx-font-size:60px; -fx-font-weight:bold; -fx-text-fill:#7A1128;");

        Label restaurant = new Label("R E S T A U R A N T");
        restaurant.setStyle("-fx-font-size:32px; -fx-font-weight:bold;");

        Label tagline = new Label("Fresh Food, Happy Mood ♡");
        tagline.setStyle("-fx-font-size:28px; -fx-text-fill:#C89B3C;");

        Label design = new Label("──────✦──────");
        design.setStyle("-fx-font-size:24px; -fx-text-fill:#7A1128;");

        Label welcome = new Label("Welcome to Our Restaurant!");
        welcome.setStyle("-fx-font-size:28px; -fx-font-weight:bold; -fx-text-fill:#444;");

        Label storyTitle = new Label("Our Story");
        storyTitle.setStyle("-fx-font-size:26px; -fx-font-weight:bold; -fx-text-fill:#444;");

        Label left = new Label("──────");
        Label right = new Label("──────");

        left.setStyle("-fx-text-fill:#C89B3C;");
        right.setStyle("-fx-text-fill:#C89B3C;");

        HBox titleBox = new HBox(10, left, storyTitle, right);
        titleBox.setAlignment(Pos.CENTER);

        Label story = new Label(
                "Our restaurant started its journey in 2015 with a passion for\n" +
                "serving delicious and high-quality food.\n" +
                "We believe in using fresh ingredients, maintaining hygiene,\n" +
                "and providing the best service to our customers.\n" +
                "Customer satisfaction is our first priority."
        );
story.setWrapText(true);
story.setStyle("-fx-font-size:18px;");
story.setAlignment(Pos.CENTER);
story.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
story.setMaxWidth(600);
       

        Button enjoy = new Button("Enjoy Your Meal 🍴");
        enjoy.setStyle(
                "-fx-background-color:#7A1128;" +
                "-fx-text-fill:white;" +
                "-fx-font-size:20px;" +
                "-fx-font-weight:bold;"
        );

        VBox center = new VBox(
                15,
                  logoView,
                title,
                restaurant,
                tagline,
                design,
                welcome,
                titleBox,
                story,
                enjoy
        );

        center.setAlignment(Pos.CENTER);

        //  MENU PAGE

        VBox menuCenter = new VBox(20);
        menuCenter.setAlignment(Pos.CENTER);

        Label menuLabel = new Label("MENU PAGE");
        menuLabel.setStyle("-fx-font-size:30px; -fx-font-weight:bold;");

        Button menuBack = new Button("Back to Home");

        menuCenter.getChildren().addAll(menuLabel, menuBack);

        // CART PAGE 

        VBox cartCenter = new VBox(20);
        cartCenter.setAlignment(Pos.CENTER);

        Label cartLabel = new Label("CART PAGE");
        cartLabel.setStyle("-fx-font-size:30px; -fx-font-weight:bold;");

        Button cartBack = new Button("Back to Home");

        cartCenter.getChildren().addAll(cartLabel, cartBack);

        // ROOT 

        BorderPane root = new BorderPane();
        root.setLeft(sidebar);
        root.setCenter(center);

    

        
        // SCENE 

        Scene scene = new Scene(root, 1200, 700);

        stage.setTitle("Restaurant Menu System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
