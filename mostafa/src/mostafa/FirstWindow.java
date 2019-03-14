package mostafa;
import java.util.Stack;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.image.*;
public class FirstWindow {
	static int count=0;
	 static String History[]= new String[10];
	//public static  String[] history= new String[10];
	static int i=0;
	private static double balance = 2000;
	Stage window;
	static Label label = new Label("Welcome!");
	Button b1, b2, b3, b4, b5;
	static double x;
	static double y;
	public static double getBalance() {
		return balance;
	}

	public static void setBalance(double balance) {
		FirstWindow.balance = balance;
	}

	public static void FirstAct()  {
	
		Stage window = new Stage();
		HBox h = new HBox(200);
		window.setTitle("Welcome");
		window.setResizable(false);
		label.setWrapText(true);
		//label.setStyle("-fx-border-color:grey;-fx-border-color:grey;-");
	  label.setStyle("-fx-border-color:#008080;");
		Button b1 = new Button("Deposit");
		b1.setStyle("-fx-border-color:green");
		b1.setOnAction(e -> SecondAct("Deposit"));
		Button b4 = new Button("Prev");
		Button b2 = new Button("WithDraw");
		b2.setOnAction(e -> SecondAct("Withdraw"));

		Button b3 = new Button("Balance Inquiry");
		b3.setOnAction(e ->{ 
			label.setText("Your Balance:" + String.valueOf(getBalance()));
			History[i]=("Your last transaction was a Balance inquiryof"+String.valueOf(getBalance()));
			count++;
			i++;
			b4.setDisable(false);
		});
		
		
		b3.setStyle("-fx-border-color:red");
		b2.setStyle("-fx-border-color:green");
       
		
		Button b5 = new Button("next");
		b5.setOnAction(e->{ 
			
			if (count==i) { 
			label.setText("Nofurthur history");
			AlertBox.display("History error","Theres is no further history");
			
			
		}
			else { 	label.setText(History[i]);
			i++;
			
			b4.setDisable(false);
			}
			
			
		});
		
		b4.setOnAction(e->{
			if(count==0||i<=0) {label.setText("No previous orders");
			AlertBox.display("History error","Theres is no further history");
			b4.setDisable(true);
			i=0;
			}
			else { i=i-1; label.setText(History[i]); 
			
			//if(i==count) b4.setDisable(true);
			}
		});
		
		b4.setStyle("-fx-border-color:#00ffff");
		b5.setStyle("-fx-border-color:#00ffff");
		
		
		h.getChildren().addAll(b4, b5);
		BorderPane layout = new BorderPane();
		layout.setRight(b2);
		layout.setLeft(b1);
		layout.setTop(b3);
		layout.setCenter(label);
		layout.setBottom(h);
		//b2
		b4.setTranslateX(110);
		b3.setTranslateX(150);
		Scene scene = new Scene(layout, 400, 200);
		window.setScene(scene);
		window.show();
	}

	public static double SecondAct(String title) {
		Stage window = new Stage();
	    window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		Label label2 = new Label(title+":");
		TextField text = new TextField();
		HBox vb = new HBox();
		VBox Vb1 = new VBox();
		Button b17 = new Button("Done");
		
		
		
		
		text.setOnKeyPressed(e->{
			switch(e.getCode()) {
			case ENTER:
			if (title.equals("Deposit")) {
				if(text.getText().isEmpty()) {
					AlertBox.display("Error","Please enter a value!");
			          FirstWindow.SecondAct("Deposit");}
				else {
				setBalance(getBalance() + Double.parseDouble(text.getText()));
				label.setText("You Deposited:" + Double.parseDouble(text.getText()));
				History[i]=("Your last transaction was a deposite of"+text.getText());
				count++; i++;
				}}
			 else if (title.equals("Withdraw")) {
				 if(text.getText().isEmpty()) {
						AlertBox.display("Error","Please enter a value!");
						FirstWindow.SecondAct("Withdraw");
				 }
				 else {
				if (getBalance() >= Double.parseDouble(text.getText())) {
					setBalance(getBalance() - Double.parseDouble(text.getText()));
					label.setText("You withdrawed:" + Double.parseDouble(text.getText()));
					History[i]=("Your last transaction was a withdraw of"+text.getText());
					count++; i++;
				} else
					AlertBox.display("Error", "Not enough credit");
			}}
			window.close();}
			});
		
		
		b17.setOnAction(e -> {
			
			
			if (title.equals("Deposit")) {
				if(text.getText().isEmpty()) {
					AlertBox.display("Error","Please enter a value!");
			          FirstWindow.SecondAct("Deposit");}
				else {
				setBalance(getBalance() + Double.parseDouble(text.getText()));
				label.setText("You Deposited:" + Double.parseDouble(text.getText()));
				History[i]=("Your last transaction was a deposit of"+text.getText());
				count++; i++;
				}}
			 else if (title.equals("Withdraw")) {
				 if(text.getText().isEmpty()) {
						AlertBox.display("Error","Please enter a value!");
						FirstWindow.SecondAct("Withdraw");
				 }
				 else {
				if (getBalance() >= Double.parseDouble(text.getText())) {
					setBalance(getBalance() - Double.parseDouble(text.getText()));
					label.setText("You withDrawed:" + Double.parseDouble(text.getText()));
					History[i]=("Your last transaction was a withdraw of"+text.getText());
					count++; i++;
				} else
					AlertBox.display("Error", "Not enough credit");
			}}
			window.close();
		});
		Button[] bt = new Button[10];

		for (int i = 0; i <= 9; i++) {
			bt[i] = new Button(String.valueOf(i));
			bt[i].setStyle("-fx-border-color:#008080");
		}

		bt[1].setOnAction(e -> text.setText(text.getText() + String.valueOf(1)));
		bt[2].setOnAction(e -> text.setText(text.getText() + String.valueOf(2)));
		bt[3].setOnAction(e -> text.setText(text.getText() + String.valueOf(3)));
		bt[4].setOnAction(e -> text.setText(text.getText() + String.valueOf(4)));
		bt[5].setOnAction(e -> text.setText(text.getText() + String.valueOf(5)));
		bt[6].setOnAction(e -> text.setText(text.getText() + String.valueOf(6)));
		bt[7].setOnAction(e -> text.setText(text.getText() + String.valueOf(7)));
		bt[8].setOnAction(e -> text.setText(text.getText() + String.valueOf(8)));
		bt[9].setOnAction(e -> text.setText(text.getText() + String.valueOf(9)));
		bt[0].setOnAction(e -> text.setText(text.getText() + String.valueOf(0)));

		HBox hb = new HBox();
		VBox vb1 = new VBox();
		VBox vb2 = new VBox();
		VBox vb3 = new VBox();

		hb.getChildren().addAll(label2, text, b17);
		vb1.getChildren().addAll(bt[1], bt[4], bt[7]);
		vb2.getChildren().addAll(bt[2], bt[5], bt[8], bt[0]);
		vb3.getChildren().addAll(bt[3], bt[6], bt[9]);

		vb.getChildren().addAll(vb1, vb2, vb3);
		vb.setTranslateX(90);
		Vb1.getChildren().addAll(hb, vb);

		Scene scene = new Scene(Vb1);

		window.setScene(scene);
		window.setResizable(false);
		window.show();
		return x;
	}

}
