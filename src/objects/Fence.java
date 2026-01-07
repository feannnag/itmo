package objects;

import abstractclasses.GameObject;
import java.util.Objects;

public class Fence extends GameObject {
    private int length;

    public Fence() {
        super("Изгородь");
        this.length = 50;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void destroy() {
        if (!destroyed) {
            super.destroy();
        }
    }

    @Override
    public String toString() {
        return "Fence{length=" + length + "m, " + getStatus() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fence fence = (Fence) o;
        return length == fence.length;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), length);
    }
}