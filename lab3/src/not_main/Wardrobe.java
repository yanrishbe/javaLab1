package not_main;

public class Wardrobe implements Furniture, Object {
    private int width;
    private int height;
    private int depth;
    private boolean sectional;

    public Wardrobe(int width, int height, int depth, boolean sectional) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.sectional = sectional;
    }

    public Wardrobe ( boolean sectional){
        this.sectional = sectional;
    }

    public boolean isSectional() {
        return this.sectional;
    }
    public void setSectional (boolean sectional) {
        this.sectional = sectional;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void print() {
         System.out.println("Wardrobe:\n" + "Manufacturer " + this.manufacturer
                 + "\n" + "Price " + this.price + "\n" + "Material " + this.material + "\n" +
                 "Width " + this.width + "\n" + "Height: " + this.height + "\n" + "Depth: " + this.depth);

        if(this.isSectional()){
            System.out.println("Is sectional\n");
        }
        if(!this.isSectional()){
            System.out.println("Isn't sectional\n");
        }

         System.out.println("---------------------------------------------------");
     }
}
