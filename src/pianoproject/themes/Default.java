package themepackage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Default extends Application {
    // Make these protected so they can be accessed by PianoKey
    protected static final Color BACKGROUND_COLOR = Color.rgb(30, 30, 30);
    protected static final Color BASE_COLOR = Color.rgb(20, 20, 20);
    protected static final int BASE_HEIGHT = 230;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        root.setStyle("-fx-background-color: " + toRgbString(BACKGROUND_COLOR));

        Rectangle base = new Rectangle(0, 0, 1300, BASE_HEIGHT);
        base.setFill(BASE_COLOR);
        root.getChildren().add(base);

        Scene scene = new Scene(root, 1300, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Stylish Virtual Piano");
        primaryStage.show();
    }

    // Helper method to convert Color to CSS string
    private String toRgbString(Color color) {
        return String.format("rgb(%d,%d,%d)",
            (int)(color.getRed() * 255),
            (int)(color.getGreen() * 255),
            (int)(color.getBlue() * 255));
    }

    public static void main(String[] args) {
        launch(args);
    }
}