package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

/**
 *
 * @author tcolburn
 */
public class MatrixControlTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        MatrixControl mc = new MatrixControl(3, 3, 50, 6, true);
        Scene scene = new Scene(mc);
        primaryStage.setTitle("Matrix Control Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Test
    public void testLaunch() {
        Application.launch();
    }
    
}