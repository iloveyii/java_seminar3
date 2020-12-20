package application;
	
import javafx.scene.control.Button;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			primaryStage.setTitle("First Fx");
						
			Button btn = new Button("OK");
			StackPane layout = new StackPane();
			layout.getChildren().addAll(btn);
			
			
			Scene scene = new Scene(layout, 300, 200);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
