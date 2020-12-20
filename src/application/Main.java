package application;
	
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main extends Application  implements EventHandler<ActionEvent>{
	Stage window;
	Scene scene1, scene2;
	TextField txtEmail;
	Button btn;
	ListView<String> listView;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			window = primaryStage;
			window.setTitle("Switch scences");
			window.setOnCloseRequest(e -> {
				e.consume();
				closeProgram(window);
				
			});
			
			// Form 
			txtEmail = new TextField();
			Button btnAdd = new Button("Add");
			btnAdd.setOnMouseClicked(e -> btnAddClicked());
			
			
			// List View
			listView = new ListView<>();
			listView.getItems().addAll("AAA", "BBBB", "CCCCC");
			listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			
			// Scene 1
			Label label1 = new Label("Email : ");
			Button btn1 = new Button("Goto scene 2");
			
			
			VBox layout1 = new VBox(10);
			layout1.getChildren().addAll(label1, txtEmail, btnAdd, btn1);
			layout1.setPadding(new Insets(20,20,20,20));
			Scene scene1 = new Scene(layout1, 800, 500);
			
			// Scene 2
			Label label2 = new Label("This is second scene");
			Button btn2 = new Button("Goto scene 1");
			Button btnRemove = new Button("Remove");
			btnRemove.setOnMouseClicked(e -> btnRemoveClicked());

			
			VBox layout2 = new VBox(10);
			layout2.getChildren().addAll(listView, btn2, btnRemove);
			layout2.setPadding(new Insets(20,20,20,20));
			Scene scene2 = new Scene(layout2, 800, 500);
			
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
	
	public static void closeProgram(Stage window) {
		System.out.println("Closing");
		window.close();
	}
	
	private void btnRemoveClicked() {
		ObservableList<String> emails;
		emails = listView.getSelectionModel().getSelectedItems();
		
		for(String email : emails) {
			System.out.println(email);
			
		}
	}
	
	private void btnAddClicked() {
		System.out.println("Btn click");
		String email = txtEmail.getText();
		// Validate
		String regex = "^(.+)@(.+)$";
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(email);
	    boolean valid = matcher.matches() ? true :false;

	    System.out.println("Email valid : " + valid);
        
	}
}
