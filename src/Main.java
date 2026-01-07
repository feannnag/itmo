import enums.Property;
import exceptions.DoNotWrongTextException;
import interfaces.AliveNames;
import interfaces.WorldProperty;
import abstractclasses.GameObject;
import abstractclasses.LivingEntity;
import objects.*;
import records.DiscoveryRecord;

import java.util.*;
import java.time.LocalDateTime;

class FearLevel {
    public static final int CALM = 1;
    public static final int NERVOUS = 2;
    public static final int AFRAID = 3;

    public static String getDescription(int level) {
        return switch(level) {
            case CALM -> "Спокойствие";
            case NERVOUS -> "Нервозность";
            case AFRAID -> "Страх";
            default -> "Неизвестно";
        };
    }
}

class PrayerResult {
    public static final String SUCCESS = "Молитва услышана";
    public static final String FAILURE = "Молитва не достигла небес";
}

// Класс Робинзона
class Robinson extends LivingEntity {
    private List<GameObject> property;
    private final List<DiscoveryRecord> discoveries;
    private final Random random;
    private int fearLevel;

    public Robinson() {
        super("Робинзон Крузо");
        this.property = new ArrayList<>();
        this.discoveries = new ArrayList<>();
        this.random = new Random();
        this.fearLevel = FearLevel.CALM;
    }

    public void discoverSavages(List<Savage> savages) {
        if (savages == null || savages.isEmpty()) return;
        this.fearLevel = random.nextBoolean() ? FearLevel.NERVOUS : FearLevel.AFRAID;
        discoveries.add(new DiscoveryRecord(
                "Обнаружены " + savages.size() + " дикарей",
                LocalDateTime.now(),
                fearLevel
        ));
    }

    public String pray() {
        return (fearLevel == FearLevel.NERVOUS) ?
                PrayerResult.SUCCESS : PrayerResult.FAILURE;
    }

    public void destroyProperty() {
        if (property.isEmpty()) return;

        for (GameObject obj : property) {
            if (!obj.isDestroyed()) {
                obj.destroy();
            }
        }
    }

    public void addProperty(GameObject obj) {
        property.add(obj);
    }

    public List<GameObject> getProperty() {
        return new ArrayList<>(property);
    }

    public int getFearLevel() {
        return fearLevel;
    }

    public List<DiscoveryRecord> getDiscoveries() {
        return new ArrayList<>(discoveries);
    }

    @Override
    public String toString() {
        return "Robinson{name='" + getName() + "', fearLevel=" +
                FearLevel.getDescription(fearLevel) + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Robinson robinson = (Robinson) o;
        return Objects.equals(getName(), robinson.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            simulateScenario();

        } catch (Exception e) {
            // Просто игнорируем исключения, как требуется
        }
    }

    private static void simulateScenario() {
        StringBuilder story = new StringBuilder();
        Random random = new Random();

        // Начало истории
        story.append("Было около полудня. \n");
        story.append("Я шел берегом моря, направляясь к своей лодке, и вдруг, \n");
        story.append("к великому своему изумлению и ужасу, увидел след голой человеческой ноги, \n");
        story.append("ясно отпечатавшийся на песке! \n");
        story.append("Я остановился и не мог сдвинуться с места, как будто меня поразил гром, \n");
        story.append("как будто я увидел привидение. \n\n");

        // Создаем Робинзона и его имущество
        Robinson robinson = new Robinson();
        robinson.addProperty(new Cottage());
        robinson.addProperty(new Fence());
        robinson.addProperty(new Field("рис"));
        robinson.addProperty(new Field("ячмень"));

        // Проверяем появление дикарей (75% шанс)
        if (random.nextDouble() < 0.75) {
            // Создаем дикарей
            int savageCount = random.nextInt(3) + 3;
            List<Savage> savages = new ArrayList<>();
            for (int i = 1; i <= savageCount; i++) {
                savages.add(new Savage(i));
            }

            robinson.discoverSavages(savages);
            int fearType = random.nextInt(2);

            // Выбираем сценарий
            if (fearType == 0) {
                handleScenario2(story, robinson, savageCount);
            } else {
                handleScenario3(story, robinson, savageCount);
            }
        } else {
            handleScenario1(story);
        }

        // Выводим историю
        System.out.println(story.toString());

        // Демонстрация исключения (без вывода сообщений)
        demonstrateException();
    }

    private static void handleScenario1(StringBuilder story) {
        story.append("Однако прошло еще два дня, и я стал гораздо смелее. \n");
        story.append("И, когда я вернулся на то место, где был таинственный след, \n");
        story.append("для меня стало очевидно, когда я для сравнения поставил ногу на след, \n");
        story.append("что на песке отпечатался мой след!\n\n");
        story.append("Я продолжал жить своей обычной жизнью,\n");
        story.append("ухаживая за полями и своей козой.\n");
        story.append("Все мое имущество осталось в целости и сохранности.\n");
    }

    private static void handleScenario2(StringBuilder story, Robinson robinson, int savageCount) {
        story.append("Однако прошло еще два дня, и я стал гораздо смелее. \n");
        story.append("Но, когда я вернулся на то место, где был таинственный след, \n");
        story.append("для меня стало очевидно, когда я для сравнения поставил ногу на след, \n");
        story.append("моя нога оказалась значительно меньше!\n\n");
        story.append("Помимо этого я обнаружил новые следы дикарей! Их было ")
                .append(savageCount).append("!\n\n");

        // Основной текст сценария 2
        appendMainText(story);

        story.append("Страх опасности всегда страшнее опасности уже наступившей, и \n");
        story.append("ожидание зла в десять тысяч раз хуже самого зла. Для меня же всего ужаснее \n");
        story.append("было то, что в этот раз я не находил облегчения в смирении и молитве. \n");
        story.append("Я уподобился Саулу, скорбевшему не только о том, что на него \n");
        story.append("идут филистимляне, но и о том, что бог покинул его. Я не искал \n");
        story.append("утешения там, где мог его найти, я не взывал к богу в печали моей. \n");
        story.append("А обратись я к богу, как делал это прежде, я бы легче перенес это \n");
        story.append("новое испытание, я бы смелее взглянул в глаза опасности, мне грозившей.\n");

        // Робинзон разрушает имущество (без вывода сообщений)
        robinson.destroyProperty();
    }

    private static void handleScenario3(StringBuilder story, Robinson robinson, int savageCount) {
        story.append("Однако прошло еще два дня, и я стал гораздо смелее. \n");
        story.append("Но, когда я вернулся на то место, где был таинственный след, \n");
        story.append("для меня стало очевидно, когда я для сравнения поставил ногу на след, \n");
        story.append("моя нога оказалась значительно меньше!\n\n");
        story.append("Помимо этого я обнаружил новые следы дикарей! Их было ")
                .append(savageCount).append("!\n\n");

        // Основной текст сценария 3
        appendMainText(story);

        story.append("Ожидание опасности не может сравниться с её реальным наступлением, \n");
        story.append("и грозящее зло меркнет перед лицом свершившегося. \n");
        story.append("Но на этот раз величайшим моим утешением стало то, что я вновь \n");
        story.append("обрёл отраду в смирении и молитве. Я уподобился тому, кто скорбит о \n");
        story.append("бедствии, но не о потере веры. Я искал и нашёл утешение там, \n");
        story.append("где всегда мог его обрести, я взывал к Богу в печали моей. \n");
        story.append("И поскольку я обратился к Нему, как делал это прежде, это новое испытание \n");
        story.append("перенеслось легче, и я смог смелее взглянуть в глаза надвигавшейся опасности.\n");
    }

    private static void appendMainText(StringBuilder story) {
        story.append("К каким только нелепым решениям ни приходит человек под влиянием страха!\n");
        story.append("Страх отнимает у нас способность распоряжаться теми средствами,\n");
        story.append("какие разум предлагает нам на помощь.\n\n");
        story.append("Если дикари, рассуждал я, найдут моих коз и увидят мои поля с \n");
        story.append("растущим на них хлебом, они будут постоянно возвращаться на \n");
        story.append("остров за новой добычей; а если они заметят мое жилье, то непременно \n");
        story.append("примутся разыскивать его обитателей и доберутся до меня. \n\n");
        story.append("Поэтому первой моей мыслью было переломать изгороди всех моих загонов \n");
        story.append("и выпустить весь скот, затем перекопать оба поля и таким образом уничтожить \n");
        story.append("всходы риса и ячменя, наконец, снести свою дачу, чтобы неприятель не мог \n");
        story.append("открыть никаких признаков присутствия на острове человека. \n\n");
        story.append("Этот план сложился у меня в первую ночь по возвращении моем \n");
        story.append("из только что описанной экспедиции на тот берег, под неостывшим \n");
        story.append("еще впечатлением сделанных мною новых открытий. \n\n");
    }

    private static void demonstrateException() {
        try {
            // Вызываем исключение без вывода сообщений
            validateText("");
        } catch (DoNotWrongTextException e) {
            // Исключение обработано, но не выводим сообщение
        }
    }

    private static void validateText(String text) throws DoNotWrongTextException {
        if (text == null || text.trim().isEmpty()) {
            throw new DoNotWrongTextException("Текст не может быть пустым");
        }
    }
}