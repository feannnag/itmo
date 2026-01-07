package records;

import java.time.LocalDateTime;

public record DiscoveryRecord(String event, LocalDateTime time, int fearLevel) {
    public DiscoveryRecord {
        if (fearLevel < 1 || fearLevel > 3) {
            throw new IllegalArgumentException("Уровень страха должен быть от 1 до 3");
        }
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", time.toString(), event);
    }
}