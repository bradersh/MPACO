package Main;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BradleyH
 */
public class EdgeSegment extends Location {
    
    public EdgeSegment(){
        List<EdgeSegment> SegmentList = new ArrayList<>();
    }
    
    public void tick(){
        evaporate();
    }
    
}
