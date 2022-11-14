module Projet_Pigeon {
	requires javafx.controls;
	requires javafx.graphics;
	requires java.desktop;
	
	opens application to javafx.graphics, javafx.fxml;
}
