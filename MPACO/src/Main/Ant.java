package Main;

import java.util.*;

/**
 *
 * @author BradleyH
 */
public class Ant {
    
    private int feature; //The ants feature (what it is searching for in the nodes)
    private boolean depoisting; //Whether or not the ant is depositing pheremore
    private double antFactor; //The factor to which the number of spawned ants is decided (an antFactor of 1 would be 1 ant for each node etc.)
    private List<Ant> antList = new ArrayList<>();
    
    public Ant(int feature, boolean depositing){
        this.feature = feature;
    }
}
