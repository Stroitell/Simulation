package org.example.actions;

import org.example.entity.Creature;
import org.example.entity.EntitySpawner;
import org.example.entity.Grass;
import org.example.entity.Herbivore;
import org.example.entity.Predator;
import org.example.entity.Rock;
import org.example.worldMap.WorldMap;
import org.example.worldMap.WorldMapRender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InitActions {

    public static void initActions (WorldMap worldMap){
        EntitySpawner spawner = new EntitySpawner(worldMap);

        spawner.spawnEntity(Predator.class, worldMap.getNumberPredators());
        spawner.spawnEntity(Herbivore.class, worldMap.getNumberHerbivores());

        spawner.spawnEntity(Grass.class, worldMap.getStartNumberGrass());
        spawner.spawnEntity(Rock.class, worldMap.getNumberRock());

        shuffleCreatures(worldMap);

        WorldMapRender.renderMap(worldMap);
    }

    public static void shuffleCreatures(WorldMap worldMap){
        List<Creature> list = new ArrayList<>(worldMap.getCreatures());
        Collections.shuffle(list);
        worldMap.getCreatures().clear();
        worldMap.getCreatures().addAll(list);
    }

    public static void spawnEntityIfNeed(WorldMap worldMap, TurnActions turnActions){
        spawnGrass(worldMap, 3, turnActions);
        spawnHerbivore(worldMap, 4);
        spawnPredator(worldMap, 2);
    }

    private static void spawnHerbivore (WorldMap worldMap, int count){
        EntitySpawner spawner = new EntitySpawner(worldMap);
        if (worldMap.getNumberHerbivores() < worldMap.getMinNumberHerbivores()){
            spawner.spawnEntity(Herbivore.class, count);
            worldMap.incrementNumberHerbivore(count);
        }
    }

    private static void spawnPredator (WorldMap worldMap, int count){
        EntitySpawner spawner = new EntitySpawner(worldMap);
        if (worldMap.getNumberPredators() < worldMap.getMinNumberPredators()){
            spawner.spawnEntity(Predator.class, count);
            worldMap.incrementNumberPredator(count);
        }
    }

    private static void spawnGrass (WorldMap worldMap, int count, TurnActions turnActions){
        turnActions.incrementIndex();
        EntitySpawner spawner = new EntitySpawner(worldMap);
        if (turnActions.getIndex() == 2) {
            spawner.spawnEntity(Grass.class, count);
            turnActions.setIndex(0);
        }
    }
}
