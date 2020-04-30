package Main;

import java.util.Random;

/**
 *
 * @author BradleyH
 */
public class Colour extends Feature{

    @Override
    int getValue() {
        Random rand = new Random();
        int n = rand.nextInt(10);
        /*
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        Colout randomColour = new Colour(r, g, b);
        */
        return n;
    }
}
