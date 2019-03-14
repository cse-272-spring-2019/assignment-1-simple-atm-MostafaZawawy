package mostafa;
import java.io.FileInputStream;
import java.lang.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//import javafx.event.*;
//import javafx.scene.text.*;
//import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
//import javafx.scene.control.PasswordField;
public class GO extends Application{
	Stage window1;
	 
	public void start (Stage primaryStage)  {
		primaryStage.setTitle("Mostafa's ATM");
	 window1=primaryStage;
	 PasswordField Pw= new PasswordField();
	 
	 Button[] bt = new Button[10];

		for (int i = 0; i <= 9; i++) {
			bt[i] = new Button(String.valueOf(i));
		}
	 
	 
	 
		bt[1].setOnAction(e -> Pw.appendText(String.valueOf(1)));
		bt[2].setOnAction(e -> Pw.appendText(String.valueOf(2)));
		bt[3].setOnAction(e -> Pw.appendText(String.valueOf(3)));
		bt[4].setOnAction(e -> Pw.appendText(String.valueOf(4)));
		bt[5].setOnAction(e -> Pw.appendText(String.valueOf(5)));
		bt[6].setOnAction(e -> Pw.appendText(String.valueOf(6)));
		bt[7].setOnAction(e -> Pw.appendText(String.valueOf(7)));
		bt[8].setOnAction(e -> Pw.appendText(String.valueOf(8)));
		bt[9].setOnAction(e -> Pw.appendText(String.valueOf(9)));
		bt[0].setOnAction(e -> Pw.appendText(String.valueOf(0)));

		HBox hb = new HBox();
		VBox vb1 = new VBox();
		VBox vb2 = new VBox();
		VBox vb3 = new VBox();
	 
	 
	 
	    
		vb1.getChildren().addAll(bt[1], bt[4], bt[7]);
		vb2.getChildren().addAll(bt[2], bt[5], bt[8], bt[0]);
		vb3.getChildren().addAll(bt[3], bt[6], bt[9]);
		hb.getChildren().addAll(vb1, vb2, vb3);
	 
	 
	 
		Button button = new Button();
		Text text = new Text("Enter Password");
		
		//Pw.setPromptText("klm1op");
		text.setX(80);
	    text.setY(170);
	    text.setFont(Font.font("verdana",FontWeight.SEMI_BOLD,FontPosture.ITALIC,20));
	    
	    button.setText("Enter");	
	    button.setStyle("-fx-border-color:#00fa9a");
	    
	    VBox layout= new VBox(10);
	    layout.setAlignment(Pos.BASELINE_CENTER);
		layout.getChildren().addAll(text,Pw,hb,button);
		hb.setTranslateX(110);
		button.setTranslateX(-5.5);
		
	Pw.setOnKeyPressed(e->{
		switch(e.getCode()) {
		case ENTER:
		if(Pw.getText().equals("1234")) {
			text.setText("Your password is Valid!");
		    FirstWindow.FirstAct();
		    window1.close();
		}
			else
				AlertBox.display("WrongPassword!","Please Enter a correct password");
				}}
		);
		
		
		
		
	
			
		button.setOnAction( e->{
		if(Pw.getText().equals("1234")) {
			text.setText("Your password is Valid!");
		    FirstWindow.FirstAct();
		    window1.close();
		}
			else
				AlertBox.display("WrongPassword!","Please Enter a correct password");
				}
		);
		Scene scene=new Scene(layout,300,250);
		window1.setScene(scene);
		window1.show();
	}
	public static void main (String[] args) {
		Application.launch(args);
}}
