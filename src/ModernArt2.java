/* Amaya Bryant
 * Course: CSC 360 - OOP II
 * Date: 10/5/22
 * Assignment: 3 - Modern Art Generator
 * Objective: generate automated modern art (rectangles of different sizes and opacities) using javafx  
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;


public class ModernArt2 extends Application{
  @Override 
  public void start(Stage primaryStage) {
    Pane pane = new Pane();
    
    Rectangle[] rectangleArray = new Rectangle[50]; 
    for (int i = 0; i < 49; i++){
      Rectangle r = new Rectangle();

      r.setX((Math.random() * 550));//can be set at x coordinate 0 to 550
      r.setY((Math.random() * 250));//can be set at x coordinate 0 to 250
     
      r.setWidth((Math.random() * 100) + 10);//min width 20, max width 100
      r.setHeight((Math.random() * 100) + 10);
 
      r.setOpacity(Math.random());

      r.setFill(Color.color(Math.random(), Math.random(), Math.random()));
      rectangleArray[i] = r; //in the rectangle array, each rectangle = i++
      pane.getChildren().add(r);
    }

    Scene scene = new Scene(pane, 600, 300);
    primaryStage.setTitle("Modern Art Generator"); // stage title
    primaryStage.setScene(scene); // Place scene in stage
    primaryStage.show(); // Display the stage
  }

  public static void main(String[] args) {
    launch(args);
  }
}
