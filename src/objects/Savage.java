package objects;

import abstractclasses.LivingEntity;
import java.util.Objects;

public class Savage extends LivingEntity {
    private final int id;

    public Savage(int id) {
        super("Дикарь #" + id);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Savage{id=" + id + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Savage savage = (Savage) o;
        return id == savage.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}