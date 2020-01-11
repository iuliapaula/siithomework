package custom_sorting;

public class SalesRepresentative {
    private String name;
    private int numberOfSales;
    private int quotaPerSale;

    public SalesRepresentative(String name, int numberOfSales, int quotaPerSale) {
        this.name = name;
        this.numberOfSales = numberOfSales;
        this.quotaPerSale = quotaPerSale;
    }

    public int getTotalSales() {
        return numberOfSales * quotaPerSale;
    }

    @Override
    public String toString() {
        return "SalesRepresentative{" +
                "name='" + name + '\'' +
                ", numberOfSales=" + numberOfSales +
                ", quotaPerSale=" + quotaPerSale +
                ", totalSales=" + getTotalSales() +
                '}';
    }


}
