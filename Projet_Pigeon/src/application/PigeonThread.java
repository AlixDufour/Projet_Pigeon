package application;


import java.util.concurrent.TimeUnit;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class PigeonThread extends Thread {

	// store the shapes created in an observable list
	private final Shape s;
	private boolean cancel;

	public PigeonThread() {
		s = new Rectangle(Math.random() * 200, Math.random() * 200, 50, 50);
		s.setFill(Color.color(Math.random(), Math.random(), Math.random()));
		// s.setFill(Color.color(0.5, 0.25, 0));
    }

	@Override
	public void run() {
		cancel = false;
		while (!cancel) {
			TranslateTransition tt = new TranslateTransition(Duration.millis(2000), s);
			tt.setByX(Math.random() * 200);
			tt.setByY(Math.random() * 200);
			tt.play();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	public Shape getShape() {
		return s;
	}
}
