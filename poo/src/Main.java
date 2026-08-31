public class Main {
    public static void main(String[] args) {
        Person lucas = new Person("Lucas");
        Person alien = new Person("Alien");
        lucas.setAge(19);
        Person.setRace("Person");
        alien.setRace("Alien");
        lucas.setRace("Human");

        System.out.println(lucas.getName() + ": nome e raças: " + lucas.getRace() + alien.getRace() + Person.getRace());

        // Records: -- serve para objetos imutáveis

        var prototype1 = new Alien("prrprrpatapim");
        System.out.println(prototype1.name()); // o metodo .method() já é um getter
    }
}
