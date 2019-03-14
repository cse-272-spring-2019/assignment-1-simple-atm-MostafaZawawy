package mostafa;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.*;
import javafx.stage.Stage;
public class SecondWindow {
static  double x;
static int i;
public  static double  SecondAct(String title) {
	Stage window= new Stage();  
	window.setTitle(title);
	Label label= new Label(title);
	TextField text=new TextField(); 
	HBox vb= new HBox();
	VBox Vb1= new VBox();
	Button b1=new Button("Done");
	b1.setOnAction(e->{
		x=Double.parseDouble(text.getText());
	 //FirstWindow.FirstAct().label.setText("You Deposited:"+x);
		window.close();
	});
	Button[]bt=new Button[10];
	
	
	 for(i=0;i<=9;i++) {
	bt[i]=new Button(String.valueOf(i));
	 }
	 
	 bt[1].setOnAction(e->text.setText(text.getText()+String.valueOf(1)));
	 bt[2].setOnAction(e->text.setText(text.getText()+String.valueOf(2)));
	 bt[3].setOnAction(e->text.setText(text.getText()+String.valueOf(3)));
	 bt[4].setOnAction(e->text.setText(text.getText()+String.valueOf(4)));
	 bt[5].setOnAction(e->text.setText(text.getText()+String.valueOf(5)));
	 bt[6].setOnAction(e->text.setText(text.getText()+String.valueOf(6)));
	 bt[7].setOnAction(e->text.setText(text.getText()+String.valueOf(7)));
	 bt[8].setOnAction(e->text.setText(text.getText()+String.valueOf(8)));
	 bt[9].setOnAction(e->text.setText(text.getText()+String.valueOf(9)));
	 bt[0].setOnAction(e->text.setText(text.getText()+String.valueOf(0)));
	 
	
	    HBox hb= new HBox();
	    VBox vb1= new VBox();
	    VBox vb2= new VBox();
	    VBox vb3= new VBox();

	    hb.getChildren().addAll(label,text,b1);
	    vb1.getChildren().addAll(bt[1],bt[4],bt[7]);
	    vb2.getChildren().addAll(bt[2],bt[5],bt[8],bt[0]);
	    vb3.getChildren().addAll(bt[3],bt[6],bt[9]);	

	
	
	
	  vb.getChildren().addAll(vb1,vb2,vb3);
	  Vb1.getChildren().addAll(hb,vb);
	
    Scene scene=new Scene(Vb1);
	  
	
	window.setScene(scene);
	window.show();
	return x;  
	}
  
}
