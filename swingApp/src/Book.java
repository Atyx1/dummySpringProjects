public class Book {
    private String name;
    private double price;
    private int pageNumber;
    private String category;
    private String ageGroup;
    private String signature;

    public Book(String name, double price, int pageNumber, String category, String ageGroup,String signature) {
        this.name = name;
        this.price = price;
        this.pageNumber = pageNumber;
        this.category = category;
        this.ageGroup = ageGroup;
        this.signature=signature;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public String getCategory() {
        return category;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", Price: $" + price +
                ", Page Number: " + pageNumber +
                ", Category: " + category +
                ", Age Group: " + ageGroup+
                ",Signature :" +signature;
    }
}