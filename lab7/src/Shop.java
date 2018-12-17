import java.util.Comparator;

public class Shop implements Comparator<Shop>, Comparable<Shop> {

    private String name;
    private String article;
    private String year;
    private String size;
    private String price;
    private String model;
    private String manufacturer;
    private String colour;

    public Shop(String name, String article, String year, String size, String price, String model, String manufacturer,
                String colour) throws DataExсeption {
        if(name.isEmpty() || !(name.matches("^\\D+$"))) throw new DataExсeption("Incorrect name");
        this.name = name;

        if(article.isEmpty() || !(article.matches("[+]?\\d+"))) throw new DataExсeption("Incorrect article");
        this.article = article;

        if(!(year.matches("[+]?\\d+"))) throw new DataExсeption("Incorrect date of production");
        this.year = year;

        if(size.isEmpty() || !(size.matches("[+]?\\d+")))throw new DataExсeption("Incorrect size");
        this.size = size;

        if(!(price.matches("[+]?\\d+"))) throw new DataExсeption("Incorrect price");
        this.price = price;

        if(!(model.matches("^\\D+$"))) throw new DataExсeption("Incorrect model");
        this.model = model;

        if(!(manufacturer.matches("^\\D+$"))) throw new DataExсeption("Incorrect manufacturer");
        this.manufacturer = manufacturer;

        if(!(colour.matches("^\\D+$"))) throw new DataExсeption("Incorrect colour ");
        this.colour = colour;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getSize() {
        return size;
    }

    public String getPrice() {
        return price;
    }

    public String getArticle() {
        return article;
    }

    public String getColour() {
        return colour;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    @Override
    public int  compare(Shop a, Shop b) {

        return a.getName().compareTo(b.getName());

    }

    @Override
    public int compareTo(Shop o1) {
        return size.compareTo(o1.getSize());
    }

}