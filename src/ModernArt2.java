/* Amaya Bryant
 * Course: CSC 360 - OOP II
 * Date: 10/5/22
 * Assignment: 4 - Modern Art Generator Enhanced
 * Objective: generate automated modern art where the user determines the quantity and maximum size of the shapes using javafx  
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
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;


public class ModernArt2 extends Application{
    private TextField objectCount = new TextField("50");
    private TextField maxSize = new TextField("100");
    private Button draw = new Button("Draw");
    private HBox drawingBarPane;
    Pane artworkPane = new Pane();
    BorderPane borderpane = new BorderPane();
    String optionsForComboBox [] = {"Circle", "Rectangle"};
    ComboBox comboBox = new ComboBox(FXCollections.observableArrayList(optionsForComboBox));
    int objectCounter;
    int maximumSize;
    

  private Pane HBox(){
    drawingBarPane = new HBox();
    drawingBarPane.setSpacing(10);
    comboBox.setValue(optionsForComboBox[0]);//sets default option to Circle
    drawingBarPane.getChildren().add(comboBox);

    drawingBarPane.getChildren().add(new Label(" Object Count: "));
    drawingBarPane.getChildren().add(objectCount);
    drawingBarPane.getChildren().add(new Label(" Max Size: "));
    drawingBarPane.getChildren().add(maxSize);
    drawingBarPane.getChildren().add(draw);

    draw.setOnKeyPressed(event -> {
      if (event.getCode().equals(KeyCode.ENTER)) {
            drawShapes();
      }
      }
    );

    draw.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent event){
        artworkPane.getChildren().clear();
        objectCounter = 50;
        maximumSize = 100;
        drawShapes();
      }
      
    });

    objectCount.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent event){
        artworkPane.getChildren().clear();
        objectCounter = Integer.parseInt(objectCount.getText());
        maximumSize = Integer.parseInt(maxSize.getText());
        drawShapes();
      }  
    });

    maxSize.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent event){
        artworkPane.getChildren().clear();
        objectCounter = Integer.parseInt(objectCount.getText());
        maximumSize = Integer.parseInt(maxSize.getText());
        drawShapes();
      }
    });

    return drawingBarPane;
  }

  @Override 
  public void start(Stage primaryStage) {
    //Create UI
    borderpane.setCenter(artworkPane);//place artworkPane in Center
    borderpane.setBottom(HBox());//place drawingBarPane at bottom

    Scene scene = new Scene(borderpane, 650, 400);//make room at bottom for hbox by increasing length to 400 
    primaryStage.setTitle("Modern Art Generator"); // stage title
    primaryStage.setScene(scene); // Place scene in stage
    primaryStage.show(); // Display the stage
  }

  private void drawShapes(){
    if (comboBox.getValue()=="Rectangle"){
      Rectangle[] rectangleArray = new Rectangle[objectCounter]; 
      for (int i = 0; i < objectCounter - 1; i++){
        Rectangle r = new Rectangle();

        r.setX(getX());
        r.setY(getY());
        r.setWidth(getMaxSize());
        r.setHeight(getMaxSize());
  
        r.setOpacity(Math.random());
        r.setFill(randomColor());
        rectangleArray[i] = r; //in the rectangle array, each rectangle = i++
        artworkPane.getChildren().add(r);
      }
    } else {
      Circle[] circleArray = new Circle[objectCounter];
      for (int i = 0; i < objectCounter - 1; i++){
        Circle c = new Circle();

        c.setCenterX(getX());
        c.setCenterY(getY());
        c.setRadius(getMaxSize());

        c.setOpacity(Math.random());
        c.setFill(randomColor());
        circleArray[i] = c;
        artworkPane.getChildren().add(c);
      }
    }


  }

  private Color randomColor(){
    return Color.color(Math.random(), Math.random(), Math.random());
  }

  private double getX(){
    return (Math.random() * 600);
  }

  private double getY(){
    return (Math.random() * 350);
  }

  private double getMaxSize(){
    return ((Math.random() * maximumSize) + 1);
  }

  public static void main(String[] args) {
    launch(args);
  }
}
