package application;
	
import javafx.scene.control.Button;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


public class Main extends Application  implements EventHandler<ActionEvent>{
	Button btn;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			primaryStage.setTitle("First Fx");
						
			btn = new Button("OK");
			btn.setOnAction(e -> System.out.println("Btn clicked from lambda"));
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

	@Override
	public void handle(ActionEvent event) {
		if(event.getSource() == btn) {
			System.out.println("Btn clicked");
		} else {
			System.out.println(event);
		}
		
	}
	
	
	
	
}
