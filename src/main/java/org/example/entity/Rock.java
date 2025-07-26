package org.example.entity;

import org.example.coordinate.Coordinate;
import org.example.worldMap.WorldMap;

public class Rock extends Entity{
    public Rock(WorldMap worldMap) {
        super(" R ", Coordinate.getDefaultCoordinate(), worldMap);
    }
}
