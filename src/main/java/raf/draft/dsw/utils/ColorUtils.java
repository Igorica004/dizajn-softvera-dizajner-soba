package raf.draft.dsw.utils;

import java.awt.*;
import java.util.Random;

public class ColorUtils {

    public static Color randomColor(){
        Random random = new Random();
        return new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
    }
    public static Color getContrastingTextColor(Color backgroundColor) {
        double brightness = (0.299 * backgroundColor.getRed() +
                0.587 * backgroundColor.getGreen() +
                0.114 * backgroundColor.getBlue());

        return brightness < 128 ? Color.WHITE : Color.BLACK;
    }
}
