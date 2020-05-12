package Main;

import java.awt.image.BufferedImage;

/**
 * @author BradleyH
 */

public class SpriteSheet {
    
    private final BufferedImage sheet;
    
    public SpriteSheet(BufferedImage sheet){
        this.sheet = sheet;
    }
    
    public BufferedImage crop(int x, int y, int width, int height){ //Returns a subimage of the section of the required sprite sheet 
        return sheet.getSubimage(x, y, width, height);
    }
}
