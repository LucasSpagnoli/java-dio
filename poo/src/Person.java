import java.time.OffsetDateTime;

public class Person {
    public final String name; // declara com final quando a variável não vai mudar (é como o const do js)
    public int age;
    private int lastYear = OffsetDateTime.now().getYear();
    public int ageDuration;
    public static String race; // statics tem valor global para

    public Person(String name) {
        this.name = name;
        this.ageDuration = 0;
    }


    public void increaseDuration() {
        if (this.lastYear >= OffsetDateTime.now().getYear()) return;
        this.ageDuration++;
        this.lastYear = OffsetDateTime.now().getYear();
    }

    public static void setRace(String raceParam) {
        race = raceParam;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static String getRace() {
        return race;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
