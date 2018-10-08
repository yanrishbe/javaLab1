package not_main;

public class Table implements Furniture, Object {
    private int drawers;
    private int area;
    private boolean sectional;

    public Table(int drawers, int area, boolean sectional) {
        this.drawers = drawers;
        this.area = area;
        this.sectional = sectional;
    }
    public Table(){

    }

    public boolean isSectional() {
        return this.sectional;
    }

    public void setSectional(boolean sectional){
        this.sectional = sectional;
    }

    public void setDrawers(int drawers) {
        this.drawers = drawers;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @Override
    public void print() {
        System.out.println("Table:\n" + "Manufacturer " + this.manufacturer
                + "\n" + "Price " + this.price + "\n" + "Material " + this.material +
                "\n" + "Drawers: " + this.drawers + "\n" + "Area: " + this.area);

        if(this.isSectional()){
            System.out.println("Is sectional\n");
        }
        if(!this.isSectional()){
            System.out.println("Isn't sectional\n");
        }

        System.out.println("---------------------------------------------------");
    }
}


