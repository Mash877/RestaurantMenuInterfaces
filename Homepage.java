import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomePage extends Application {

    @Override
    public void start(Stage stage) {
        Label title = new Label("Restaurant Menu Interface");
        Button menuBtn = new Button("View Menu");
        Button orderBtn = new Button("Order Now");
        Button exitBtn = new Button("Exit");
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);

        root.getChildren().addAll(title, menuBtn, orderBtn, exitBtn);
        Scene scene = new Scene(root, 500, 400);

      
        stage.setTitle("Home Page");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}