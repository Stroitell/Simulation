package org.example.entity;

import org.example.Color;
import org.example.coordinate.Coordinate;
import org.example.worldMap.WorldMap;

public class Grass extends Entity{

    public Grass(WorldMap worldMap) {
        super(Color.GREEN.getColor() + " G " + Color.RESET.getColor(), Coordinate.getDefaultCoordinate(), worldMap);
    }

}
