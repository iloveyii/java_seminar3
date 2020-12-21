package application;
	
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main extends Application{
	Stage window;
	Scene scene1, scene2;
	TextField txtEmail;
	Button btn;
	ListView<String> listView;
	Label lblError;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			window = primaryStage;
			window.setFullScreen(false);
			window.setMaximized(false);
			window.centerOnScreen();
			window.setResizable(false);
			window.setOpacity(0.95);
			window.setTitle("Register emails");
			window.setOnCloseRequest(e -> {
				e.consume();
				closeProgram(window);
				
			});
			
			// Form 
			txtEmail = new TextField();
			Button btnAdd = new Button("Register");
			
			// List View
			listView = new ListView<>();
			listView.getItems().addAll("AAA", "BBBB", "CCCCC");
			listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			
			// Scene 1
			Label label1 = new Label("Email : ");
			Button btn1 = new Button("Show list");
			lblError = new Label();
			
			
			VBox layout1 = new VBox(10);
			layout1.getChildren().addAll(label1, txtEmail, lblError, btnAdd, btn1);
			layout1.setPadding(new Insets(20,20,20,20));
			Scene scene1 = new Scene(layout1, 800, 500);
			
			Button btn2 = new Button("Back");
			Button btnRemove = new Button("Remove");
			btnRemove.setOnAction(e -> btnRemoveClicked());

			
			VBox layout2 = new VBox(10);
			layout2.getChildren().addAll(listView, btn2, btnRemove);
			layout2.setPadding(new Insets(20,20,20,20));
			Scene scene2 = new Scene(layout2, 800, 500);
			
			btn1.setOnAction(e -> window.setScene(scene2));
			btn2.setOnAction(e -> window.setScene(scene1));
			btnAdd.setOnAction(e -> {
				boolean success = btnAddClicked();
				if(success) {
					lblError.setText("Email added");
					txtEmail.setText("");
					window.setScene(scene2);
				} else {
					lblError.setText("Email invalid");
				}
			});
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
		
		if(emails != null && emails.size() > 0) {
			try {
				for(String email : emails) {
					System.out.println(email);
					if(listView.getItems().contains(email)) {
						listView.getItems().remove(email);
					}
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	private boolean btnAddClicked() {
		String email = txtEmail.getText();
		// Validate
		String regex = "^(.+)@(.+)$";
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(email);
	    boolean valid = matcher.matches() ? true :false;

	    System.out.println("Email valid : " + valid);
	    if(valid) {
	    	listView.getItems().add(email);
	    	return true;
	    }
	    
	    return false;
        
	}
}
