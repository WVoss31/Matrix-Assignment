package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;
import matrix.Matrix;
import org.junit.jupiter.api.Test;

/**
 *
 * @author tcolburn
 */
public class MatrixDisplayTest extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        MatrixDisplay md = new MatrixDisplay(50, 4, true);
        md.setPadding(new Insets(10));
        md.update(Matrix.create(4, 3));
        Scene scene = new Scene(md);
        primaryStage.setTitle("Matrix Display Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Test
    public void testLaunch() {
        Application.launch();
    }
    
}