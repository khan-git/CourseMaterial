package Java8to21.Assign1;

import java.util.ArrayList;
import java.util.List;
import Java8to21.Assign1.Person;

public class Main {
    public static void main(String[] args) {
        var people = getPeople();

    }

    private static List<Person> getPeople() {
        
        List<Person> result = new ArrayList<>();
        result.add(new Person("Mike", 33, 1.8));
        result.add(new Person("Mary", 25, 1.4));
        result.add(new Person("Alan", 34, 1.7));
        result.add(new Person("Zoe", 30, 1.5));
        return result;
    }

    void consumer(List<Person> people) {

    }

}
