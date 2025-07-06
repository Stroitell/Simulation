package org.example;

public class Entity {
    private final String sprite;
    private Coodinate coodinate;

    public Entity(String sprite, Coodinate coodinate) {
        this.sprite =sprite;
        this.coodinate = coodinate;
    }


    public void setCoodinate(Coodinate coodinate) {
        this.coodinate = coodinate;
    }
    public Coodinate getCoodinate() {
        return coodinate;
    }
    @Override
    public String toString() {
        return sprite + "";
    }
}
