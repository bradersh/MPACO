package Main;

/**
 *
 * @author BradleyH
 */
public abstract class FeatureEntity extends Entity {
    
    protected int feature;
    
    public FeatureEntity(float x, float y) {
        super(x, y);
        feature = 1;
    }
}
