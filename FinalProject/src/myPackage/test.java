package myPackage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class test extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		ScrollPane ye = new ScrollPane();
		VBox yes = new VBox();
		
		
		int x = 0;
		while(x != 100) {
			Text text = new Text();
			text.setText("Ye");
			yes.getChildren().add(text);
			x++;
		}
		
		ye.setContent(yes);
		Scene scene = new Scene(ye);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
