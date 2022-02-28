package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

/**
 *
 * @author tcolburn
 */
public class MatrixOperationTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        MatrixOperation mo = new MatrixOperation(3, 3, 4, false);
        Scene scene = new Scene(mo);
        primaryStage.setTitle("Matrix Operation Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Test
    public void testLaunch() {
        Application.launch();
    }
    
}