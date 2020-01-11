package custom_sorting;

import java.util.Arrays;

public class ExampleSorting {

    public static void main(String[] args) {
        SalesRepresentative salesRepresentative1 = new SalesRepresentative("Ioana", 10, 100);
        SalesRepresentative salesRepresentative2 = new SalesRepresentative("Maria", 12, 1000);
        SalesRepresentative salesRepresentative3 = new SalesRepresentative("Radu", 10, 1000);
        SalesRepresentative[] unsortedReps = new SalesRepresentative[3];
        unsortedReps[0] = salesRepresentative1;
        unsortedReps[1] = salesRepresentative2;
        unsortedReps[2] = salesRepresentative3;

        SalesRepSorting sortingClass = new SalesRepSorting();
        SalesRepresentative[] sortedReps = sortingClass.sortDescending(unsortedReps);
        System.out.println(Arrays.toString(sortedReps));
    }
}