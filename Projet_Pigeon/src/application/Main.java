package application;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {

		StackPane pane = new StackPane(); // container for shapes
		PigeonThread mr = new PigeonThread(); // make new shapes on other thread
		PigeonThread ms = new PigeonThread();
		
		if (!(mr.getShape() == null))
			Platform.runLater(() -> pane.getChildren().add(mr.getShape()));

		if (!(ms.getShape() == null))
			Platform.runLater(() -> pane.getChildren().add(ms.getShape()));

		Scene scene = new Scene(pane, 1000, 700);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.sizeToScene();

		mr.start();
		ms.start();
	}

	public static void main(String[] args) {
		launch(args);
	}

	/*
	 * @Override public void start(Stage primaryStage) {
	 * 
	 * 
	 * 
	 * /* try {
	 * 
	 * BorderPane root = new BorderPane(); Scene scene = new Scene(root,400,400);
	 * scene.getStylesheets().add(getClass().getResource("application.css").
	 * toExternalForm());
	 * 
	 * Rectangle rect = new Rectangle(0, 0, 100, 100); rect.setFill(Color.BLUE);
	 * 
	 * TranslateTransition tt = new TranslateTransition(Duration.millis(2000),
	 * rect); tt.setByX(200); tt.setByY(200);
	 * 
	 * tt.play();
	 * 
	 * root.getChildren().add(rect);
	 * scene.getStylesheets().add(getClass().getResource("application.css").
	 * toExternalForm());
	 * 
	 * primaryStage.setScene(scene); primaryStage.show(); } catch(Exception e) {
	 * e.printStackTrace(); } }
	 * 
	 * 
	 * public static void main(String[] args) { launch(args); }
	 */
}
