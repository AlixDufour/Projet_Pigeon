package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

import java.io.FileInputStream;

import javafx.animation.*;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			Scene scene = new Scene(root,400,400);
			
			Rectangle rect = new Rectangle(0,0,100,100);
			rect.setFill(Color.BLUE);
			
			
			
			TranslateTransition tt = new TranslateTransition(Duration.millis(2000), rect);
			tt.setByX(200);
			tt.setByY(200);
			
			tt.play();
			
			root.getChildren().add(rect);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
