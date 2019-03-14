package ATM;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.control.PasswordField;
class Mostafa extends Application{
Button button;
Text text;
PasswordField Pw;
public void start (Stage primaryStage) throws Exception {
	primaryStage.setTitle("Mostafa's ATM");
	Button button = new Button();
	Text text = new Text();
	PasswordField Pw= new PasswordField();
	Pw.setPromptText("klm1op");
	text.setX(80);
    text.setY(170);
    text.setFont(Font.font("verdana",FontWeight.SEMI_BOLD,FontPosture.ITALIC,20));
    //button.setTextFill();
   // button.setY(20);
	button.setText("Enter");	
    TilePane layout= new TilePane();
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	layout.getChildren().addAll(button,text,Pw);
	button.setOnAction( event->{
	if(Pw.getText().equals("klm1op"))
		text.setText("Your password is Valid!");
		else
		text.setText("Your password is Invalid!");
		}	
	);
	Scene scene=new Scene(layout,300,250);
	primaryStage.setScene(scene);
	primaryStage.show();
}
	public static void main(String[] args) {
 Application.launch(args);

	}
	//C:\Program Files
	//C:\Program Files\Java\jre\bin\Java\jre\bin
}
