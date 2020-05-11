package Main;

import java.awt.image.BufferedImage;

/**
 *
 * @author BradleyH
 */
public class Assets {
    
    private static final int width = 32, height = 32;
    public static BufferedImage node1, node2, node3, node4, ant1, ant2, ant3, ant4;//All of the required images as buffered images
    
    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/SpriteSheet.png")); //Takes the sprite sheet and crops each 32x32 square into the buffered images
        
        node1 = sheet.crop(0, 0, width, height);
        node2 = sheet.crop(width, 0, width, height);
        node3 = sheet.crop(width * 2, 0, width, height);
        node4 = sheet.crop(width * 3, 0, width, height);
        ant1 = sheet.crop(0, height, width, height);
        ant2 = sheet.crop(width, height, width, height);
        ant3 = sheet.crop(width * 2, height, width, height);
        ant4 = sheet.crop(width * 3, height, width, height);
    }
    
}
