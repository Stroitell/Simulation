package org.example.entity;

import org.example.Color;
import org.example.coordinate.Coordinate;
import org.example.worldMap.WorldMap;

public class Predator extends Creature{

    private final int attackPower = 1;

    public Predator(WorldMap worldMap) {
        super(Color.RED.getColor() +" P "+ Color.RESET.getColor(), Coordinate.getDefaultCoordinate(), worldMap, 1, 2, Herbivore.class, 5);
    }

    public void attackTarget (){
        Creature herbivore = ((Creature) getWorldMap().getEntityMap().get(getTargetAt()));
        herbivore.setHp(herbivore.getHp() - attackPower);

        reduceHunger();
    }

}
