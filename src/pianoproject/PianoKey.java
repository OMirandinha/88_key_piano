package pianoproject;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PianoKey {
    private final Rectangle keyVisual;
    private final Text label;
    private final boolean isBlack;
    private final String noteName;
    private final int octave;

    // Constants for key dimensions
    private static final int WHITE_KEY_WIDTH = 23;
    private static final int WHITE_KEY_HEIGHT = 200;
    static final int BLACK_KEY_WIDTH = 14;
    private static final int BLACK_KEY_HEIGHT = 120;

    public PianoKey(String noteName, int octave, boolean isBlack, double xPosition) {
        this.noteName = noteName;
        this.octave = octave;
        this.isBlack = isBlack;

        // Create key visual
        this.keyVisual = createKeyVisual(xPosition);
        this.label = createLabel(xPosition);
    }

    private Rectangle createKeyVisual(double xPosition) {
        Rectangle key = new Rectangle(
            xPosition, 
            0, 
            isBlack ? BLACK_KEY_WIDTH : WHITE_KEY_WIDTH,
            isBlack ? BLACK_KEY_HEIGHT : WHITE_KEY_HEIGHT
        );

        key.setFill(isBlack ? Color.BLACK : Color.WHITE);
        key.setStroke(Color.BLACK);
        return key;
    }

    private Text createLabel(double xPosition) {
        Text text = new Text(noteName + octave);
        text.setFont(Font.font(isBlack ? 9 : 10));
        
        if (isBlack) {
            text.setFill(Color.WHITE);
            text.setX(xPosition + 2);
            text.setY(BLACK_KEY_HEIGHT - 10);
        } else {
            text.setFill(Color.BLACK);
            text.setX(xPosition + 5);
            text.setY(WHITE_KEY_HEIGHT - 10);
        }
        
        return text;
    }

    // Getters for the JavaFX nodes
    public Rectangle getKeyVisual() {
        return keyVisual;
    }

    public Text getLabel() {
        return label;
    }

    // Static helper methods for piano creation
    public static int getWhiteKeyWidth() {
        return WHITE_KEY_WIDTH;
    }

    public static int getWhiteKeyHeight() {
        return WHITE_KEY_HEIGHT;
    }
}