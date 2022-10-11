/* Amaya Bryant
 * Course: CSC 360 - OOP II
 * Date: 10/5/22
 * Assignment: 3 - Modern Art Generator
 * Objective: generate automated modern art (rectangles of different sizes and opacities) using javafx  
 */
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.scene.control.ComboBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;


public class ModernArt2 extends Application{
    private TextField objectCount = new TextField();
    private TextField maxSize = new TextField();
    private Button draw = new Button("Draw");

  @Override 
  public void start(Stage primaryStage) {
    //Create UI
    Pane artworkPane = new Pane();
    HBox drawingBarPane = new HBox();
    drawingBarPane.setSpacing(10);
    //CircleHandler handlerC = new CircleHandler();

    String optionsForComboBox [] = {"Circle", "Rectangle"};
    ComboBox options = new ComboBox(FXCollections.observableArrayList(optionsForComboBox));
    options.setValue(optionsForComboBox[0]);//sets default option to Circle
    drawingBarPane.getChildren().add(options);

    drawingBarPane.getChildren().add(new Label(" Object Count: "));
    drawingBarPane.getChildren().add(objectCount);
    drawingBarPane.getChildren().add(new Label(" Max Size: "));
    drawingBarPane.getChildren().add(maxSize);
    drawingBarPane.getChildren().add(draw);

    BorderPane borderpane = new BorderPane();
    borderpane.setCenter(artworkPane);//place artworkPane in Center
    borderpane.setBottom(drawingBarPane);//place drawingBarPane at bottom

    
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
      artworkPane.getChildren().add(r);
    }

    Scene scene = new Scene(borderpane, 650, 400);//make room at bottom for hbox by increasing length to 400 
    primaryStage.setTitle("Modern Art Generator"); // stage title
    primaryStage.setScene(scene); // Place scene in stage
    primaryStage.show(); // Display the stage
  }

  class CircleHandler implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent e){

    }
  }
  class RectangleHandler implements EventHandler<ActionEvent>{
    @Override
    public void handle(ActionEvent e){
        
    }
  }

  private void drawShapes(){
    double objectCounter = Double.parseDouble(objectCount.getText());
    double maximumSize = Double.parseDouble(maxSize.getText());
    //if cirlce 
    //if rectangle 
  }

  public static void main(String[] args) {
    launch(args);
  }
}
