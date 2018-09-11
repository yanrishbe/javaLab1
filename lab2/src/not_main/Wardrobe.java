package not_main;

public class Wardrobe extends Furniture {
    private int width;
    private int height;
    private int depth;

    public Wardrobe() {
    }

    public Wardrobe(Wardrobe object) {
        super(object);
        this.width = object.width;
        this.height = object.height;
        this.depth = object.depth;
    }

    public Wardrobe(String manufacturer, int price, String material, int width, int height, int depth) {
        super(manufacturer, price, material);
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void show(){
        System.out.println("Wardrobe:\n"+"Manufacturer "+getManufacturer()
                +"\n"+"Price "+getPrice()+"\n"+"Material "+getMaterial()+"\n"+
                "Width "+getWidth()+"\n"+"Height: "+getHeight()+"\n"+ "Depth: "+getHeight());

        System.out.println("---------------------------------------------------");
    }
}
