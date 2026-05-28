/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package practise.pkg1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class Practise1 extends Application {
     @Override
    public void start(Stage primaryStage) {
   //scene 1
Text ques =new Text ("What is your dept:");
TextField ans1 =new TextField();
ans1.setPromptText("Answer");
Button submit =new Button("Submit");
VBox root =new VBox(10);
root.getChildren().addAll(ques,ans1,submit);
Scene scene1=new Scene(root,400,300);
//scene2
Text ques2 =new Text("what is your ID");
TextField ans2= new TextField();
ans2.setPromptText("answer");
Button submit2 =new Button ("Submit");
Button buttonback=new Button("back");
VBox root2=new VBox(10);
root2.getChildren().addAll(ques2,ans2,submit2,buttonback);
Scene scene2 =new Scene(root2,400,300);
submit.setOnAction(e->{
    String answer = ans1.getText();
    if(answer.equals("CSE"))
    {
        primaryStage.setScene(scene2);
    }
    else
    {
        System.out.println("Wrong answer");
    }
});

//Scene3
Text ques3 = new Text("What is your cgpa");
TextField ans3 = new TextField();
ans3.setPromptText("Answer");
Button submit3 = new Button("Submit");
Button Back =new Button ("Back");
VBox root3 =new VBox(10);
root3.getChildren().addAll(ques3,ans3,submit3,Back);
Scene scene3=new Scene(root3,400,300);
submit3.setOnAction(e->{
   String answer = ans3.getText();
   if(answer.equals("4.00"))
   {
       primaryStage.setScene(scene3);
   }
   else
   {
       System .out.println("Wrong answer");
   }
});
submit2.setOnAction(e->{
    String answer = ans2.getText();
    if(answer.equals("30"))
    {
        primaryStage.setScene(scene3);
    }
    else
    {
        System.out.println("Wrong answer");
    }
});
//Scene 3
Text text =new Text("Congrats");
Button b =new Button("Retry");
VBox root4 =new VBox(10);
root4.getChildren().addAll(text,b);
Scene scene4=new Scene(root4,400,300);
submit3.setOnAction(e->{
 String answer = ans3.getText();
  if(answer.equals("4.00"))
  {
      primaryStage.setScene(scene4);
  }
});
b.setOnAction(e->{
 
      primaryStage.setScene(scene1);
  
});
primaryStage.setScene(scene1);
primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }   
}
