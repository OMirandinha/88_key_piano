package pianoproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PianoMain extends Application {
    private static final String[] WHITE_NOTES = {"A", "B", "C", "D", "E", "F", "G"};
    private static final boolean[] HAS_BLACK_AFTER = {
        true, false, true, true, false, true, true // A B C D E F G
    };

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        createPianoKeys(root);

        Scene scene = new Scene(
            root, 
            PianoKey.getWhiteKeyWidth() * 52, 
            PianoKey.getWhiteKeyHeight()
        );
        
        primaryStage.setTitle("Virtual Piano - 88 Keys with Note Labels");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createPianoKeys(Pane root) {
        int whiteKeyCount = 0;
        int totalWhiteKeys = 52;
        double currentX = 0;
        int octave = 0;
        int patternIndex = 0;

        while (whiteKeyCount < totalWhiteKeys) {
            String whiteNote = WHITE_NOTES[patternIndex];

            // Adjust octave at C (each C starts a new octave)
            if (whiteNote.equals("C") && whiteKeyCount != 0) {
                octave++;
            }

            // Create white key
            PianoKey whiteKey = new PianoKey(
                whiteNote, 
                octave, 
                false, 
                currentX
            );
            
            root.getChildren().addAll(
                whiteKey.getKeyVisual(), 
                whiteKey.getLabel()
            );

            // Create black key if needed
            if (HAS_BLACK_AFTER[patternIndex] && whiteKeyCount < totalWhiteKeys - 1) {
                PianoKey blackKey = new PianoKey(
                    whiteNote + "#", 
                    octave, 
                    true, 
                    currentX + PianoKey.getWhiteKeyWidth() - (PianoKey.BLACK_KEY_WIDTH / 2.0)
                );
                
                root.getChildren().addAll(
                    blackKey.getKeyVisual(), 
                    blackKey.getLabel()
                );
            }

            // Move to next white key
            currentX += PianoKey.getWhiteKeyWidth();
            whiteKeyCount++;
            patternIndex = (patternIndex + 1) % WHITE_NOTES.length;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}