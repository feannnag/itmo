package abstractclasses;

import interfaces.AliveNames;
import java.util.Objects;

public abstract class LivingEntity implements AliveNames {
    protected String name;
    protected int health;

    public LivingEntity(String name) {
        this.name = name;
        this.health = 100;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.max(0, health);
    }

    @Override
    public abstract String toString();

    @Override
    public abstract boolean equals(Object o);

    @Override
    public abstract int hashCode();
}