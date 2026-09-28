package model;

public class Listing {

    private final String name;
    private final String category;
    private final String condition;
    private final String city;
    private final String description;
    private final String price;

    public Listing(String name,
                   String category,
                   String condition,
                   String city,
                   String description,
                   String price) {
        this.name = name;
        this.category = category;
        this.condition = condition;
        this.city = city;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getCondition() {
        return condition;
    }

    public String getCity() {
        return city;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }
}