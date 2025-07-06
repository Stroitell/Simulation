package org.example;

import java.util.List;
import java.util.Random;

public class ChoiceCoordinate {

    private Random random = new Random();
    WorldMap worldMap = new WorldMap();
    public Coodinate chooseCoordinate (WorldMap worldMap){
        List<Coodinate> coodinates = worldMap.getAvailableCoordinates();
        return coodinates.get(random.nextInt(coodinates.size()));
    }
}
