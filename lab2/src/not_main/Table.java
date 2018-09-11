package not_main;

public class Table extends Furniture {
    private int drawers;
    private int area;

    public Table() {
    }

    public Table(String manufacturer, int price, String material, int drawers, int area) {
        super(manufacturer, price, material);
        this.drawers = drawers;
        this.area = area;
    }

    public Table(Table object) {
        super(object);
        this.drawers = object.drawers;
        this.area = object.area;
    }

    public int getDrawers() {
        return drawers;
    }

    public void setDrawers(int drawers) {
        this.drawers = drawers;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void show(){
        System.out.println("Table:\n"+"Manufacturer "+getManufacturer()
                +"\n"+"Price "+getPrice()+"\n"+"Material "+getMaterial()+
                "\n"+"Drawers: "+getDrawers()+"\n"+ "Area: "+getArea());

        System.out.println("---------------------------------------------------");
    }
}
