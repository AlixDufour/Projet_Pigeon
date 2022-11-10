module Projet_Pigeon {
	requires javafx.controls;
	requires javafx.graphics;

	
	opens application to javafx.graphics, javafx.fxml;
}
