package org.example.entity;

import org.example.Color;
import org.example.coordinate.Coordinate;
import org.example.worldMap.WorldMap;

public class Herbivore extends Creature{

    public Herbivore(WorldMap worldMap) {
        super(Color.BLUE.getColor()+" H "+Color.RESET.getColor(), Coordinate.getDefaultCoordinate(), worldMap,  2, 1, Grass.class, 0);
    }

    public void attackTarget (){
        killTarget();
        cureHp();
        reduceHunger();
    }

    private void cureHp (){
        setHp(getHp() + 1);
    }
}
