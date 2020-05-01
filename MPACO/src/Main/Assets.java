package Main;

import java.awt.image.BufferedImage;

/**
 *
 * @author BradleyH
 */
public class Assets {
    
    private static final int width = 32, height = 32;
    public static BufferedImage ant, node, edge, pEdge;//All of the required images as buffered images
    
    public static void init(){
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/SpriteSheet.png")); //Takes the sprite sheet and crops each 32x32 square into the buffered images
        
        ant = sheet.crop(0, 0, width, height);
        node = sheet.crop(width, 0, width, height);
        edge = sheet.crop(width * 2, 0, width, height);
        pEdge = sheet.crop(width * 3, 0, width, height);
    }
    
}
