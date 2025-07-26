package org.example.entity;

import org.example.worldMap.WorldMap;
import org.example.coordinate.ChoiceCoordinate;

import java.lang.reflect.Constructor;

public class EntitySpawner {
    private final WorldMap worldMap;

    public EntitySpawner(WorldMap worldMap) {this.worldMap = worldMap;}

    private final ChoiceCoordinate selector = new ChoiceCoordinate();
    public  <T extends Entity> void spawnEntity(Class<T> entityClass, int count) {
        try{
            for (int cnt = 0; cnt < count; cnt++) {

                Constructor<T> constructor = entityClass.getDeclaredConstructor(WorldMap.class);
                Entity entity = constructor.newInstance(worldMap);
                entity.setCoordinate(selector.chooseCoordinate(worldMap));

                if (entity instanceof Creature){
                    worldMap.getCreatures().add((Creature) entity);
                }
                putToEntityMap(worldMap, entity);
            }
        }   catch (Exception e){
            e.printStackTrace();
        }
    }

    public void putToEntityMap (WorldMap worldMap, Entity entity){
        worldMap.getEntityMap().put(entity.getCoordinate(), entity);
        worldMap.getEmptyCoordinates().remove(entity.getCoordinate());
    }

}
