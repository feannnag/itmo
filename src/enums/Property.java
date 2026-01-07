package enums;

public enum Property {
    COTTAGE("Дача", "Жилище Робинзона", true),
    FENCE("Изгородь", "Ограждение", true),
    FIELD("Поле", "Участок для урожая", true),
    GOAT("Коза", "Домашнее животное", false);

    private final String name;
    private final String description;
    private final boolean isDestroyable;

    Property(String name, String description, boolean isDestroyable) {
        this.name = name;
        this.description = description;
        this.isDestroyable = isDestroyable;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public boolean isDestroyable() { return isDestroyable; }
}