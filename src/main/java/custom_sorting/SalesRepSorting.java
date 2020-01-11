package custom_sorting;

public class SalesRepSorting {
    public SalesRepresentative[] sortDescending(SalesRepresentative[] unsortedReps) {
        int n = unsortedReps.length;
        SalesRepresentative[] sortedReps = new SalesRepresentative[n];
        for (int i = 0; i < n; i++) {
            sortedReps[i] = unsortedReps[i];
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if(sortedReps[j].getTotalSales() < sortedReps[j + 1].getTotalSales()) {
                    SalesRepresentative temp = sortedReps[j];
                    sortedReps[j] = sortedReps[j + 1];
                    sortedReps[j + 1] = temp;
                }
            }
        }
        return sortedReps;
    }
}
