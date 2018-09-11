package not_main;

public class Furniture {
    private String manufacturer;
    private int price;
    private String material;

    public Furniture() {
    }

    public Furniture(Furniture object) {
        this.manufacturer = object.manufacturer;
        this.price = object.price;
        this.material = object.material;
    }

    public Furniture(String manufacturer, int price, String material) {
        this.manufacturer = manufacturer;
        this.price = price;
        this.material = material;
    }

      public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void show() {
        System.out.println("Furniture in general:\n" + "Manufacturer " + getManufacturer()
                + "\n" + "Price " + getPrice() + "\n" + "Material " + getMaterial());

        System.out.println("---------------------------------------------------");
    }


}




