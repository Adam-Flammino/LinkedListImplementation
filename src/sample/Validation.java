package sample;
/**
 * @Course: SDEV 250 ~ Java Programming II
 * @Author Name: Adam Flammino
 * @Assignment Name: aflammino_week11
 * @Date: Apr 20, 2017
 * @Subclass Validation Description: Checks for empty TextField
 */
import javafx.scene.control.TextField;

public class Validation {
    /**
     * Checks if a TextField is empty
     * @param t
     * @return true if empty
     */
    public  boolean emptyTextField(TextField t){
        return t.getText().trim().equals("");
    }
}
