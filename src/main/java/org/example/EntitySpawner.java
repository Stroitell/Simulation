package org.example;

public class EntitySpawner {


    private static ChoiceCoordinate selector = new ChoiceCoordinate();
    public void spawnEntity(WorldMap worldMap){
        Entity entity = new Entity(" E  ", new Coodinate(-1, -1));
        entity.setCoodinate(selector.chooseCoordinate(worldMap));

        worldMap.getEntityMap().put(entity.getCoodinate(), entity);
        worldMap.getAvailableCoordinates().remove(entity.getCoodinate());
    }

    public static void spawnGrass(WorldMap worldMap){
        Entity entity = new Grass();
        entity.setCoodinate(selector.chooseCoordinate(worldMap));

        worldMap.getEntityMap().put(entity.getCoodinate(), entity);
        worldMap.getAvailableCoordinates().remove(entity.getCoodinate());
    }

    public void spawnAnyEntity(Entity entity, WorldMap worldMap){
        Entity salam = new Grass();
        salam.setCoodinate(selector.chooseCoordinate(worldMap));

        worldMap.getEntityMap().put(salam.getCoodinate(), salam);
        worldMap.getAvailableCoordinates().remove(salam.getCoodinate());
    }
}
