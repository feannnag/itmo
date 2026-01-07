package abstractclasses;

import interfaces.WorldProperty;
import java.util.Objects;

public abstract class GameObject implements WorldProperty {
    protected String name;
    protected boolean destroyed;

    public GameObject(String name) {
        this.name = name;
        this.destroyed = false;
    }

    @Override
    public void destroy() {
        this.destroyed = true;
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    @Override
    public String getStatus() {
        return name + ": " + (destroyed ? "РАЗРУШЕНО" : "ЦЕЛО");
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "GameObject{name='" + name + "', destroyed=" + destroyed + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameObject that = (GameObject) o;
        return destroyed == that.destroyed && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, destroyed);
    }
}