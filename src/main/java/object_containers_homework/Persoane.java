package object_containers_homework;

import java.util.Objects;

public class Persoane {
    private String name;
    private int age;

    public Persoane(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persoane persoane = (Persoane) o;
        return age == persoane.age &&
                Objects.equals(name, persoane.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
