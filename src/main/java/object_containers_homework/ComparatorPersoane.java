package object_containers_homework;

import java.util.Comparator;

public class ComparatorPersoane implements Comparator<Persoane> {
    @Override
    public int compare(Persoane o1, Persoane o2) {
        int comparatorName = o1.getName().compareTo(o2.getName());
        if (comparatorName != 0) {
            return comparatorName;
        }
        else {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    }
}
