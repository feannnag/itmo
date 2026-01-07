package objects;

import abstractclasses.GameObject;
import java.util.Objects;

public class Cottage extends GameObject {
    private int rooms;

    public Cottage() {
        super("Дача");
        this.rooms = 3;
    }

    public int getRooms() {
        return rooms;
    }

    @Override
    public void destroy() {
        if (!destroyed) {
            super.destroy();
        }
    }

    @Override
    public String toString() {
        return "Cottage{rooms=" + rooms + ", " + getStatus() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cottage cottage = (Cottage) o;
        return rooms == cottage.rooms;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rooms);
    }
}