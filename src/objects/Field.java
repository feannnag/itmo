package objects;

import abstractclasses.GameObject;
import java.util.Objects;

public class Field extends GameObject {
    private final String cropType;

    public Field(String cropType) {
        super("Поле (" + cropType + ")");
        this.cropType = cropType;
    }

    public String getCropType() {
        return cropType;
    }

    @Override
    public void destroy() {
        if (!destroyed) {
            super.destroy();
        }
    }

    @Override
    public String toString() {
        return "Field{cropType='" + cropType + "', " + getStatus() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return Objects.equals(cropType, field.cropType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), cropType);
    }
}