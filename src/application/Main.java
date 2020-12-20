package application;
	
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application  implements EventHandler<ActionEvent>{
	Stage window;
	Scene scene1, scene2;
	Button btn;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			window = primaryStage;
			window.setTitle("Switch scences");
			
			// Scene 1
			Label label1 = new Label("This is first scene");
			Button btn1 = new Button("Goto scene 2");
			
			
			VBox layout1 = new VBox(20);
			layout1.getChildren().addAll(label1, btn1);
			Scene scene1 = new Scene(layout1, 300, 200);
			
			// Scene 2
			Label label2 = new Label("This is second scene");
			Button btn2 = new Button("Goto scene 1");
			
			
			StackPane layout2 = new StackPane();
			layout2.getChildren().addAll(label2, btn2);
			Scene scene2 = new Scene(layout2, 300, 200);
			
			btn1.setOnAction(e -> window.setScene(scene2));
			btn2.setOnAction(e -> window.setScene(scene1));
			window.setScene(scene1);
			window.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
