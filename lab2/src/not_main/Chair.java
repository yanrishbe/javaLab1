package not_main;

public class Chair extends Furniture {
    private boolean regulate;

    public Chair() {
    }

    public Chair(Chair object) {
        super(object);
        this.regulate = object.regulate;
    }

    public Chair(String manufacturer, int price, String material, boolean regulate) {
        super(manufacturer, price, material);
        this.regulate = regulate;
    }

    public boolean isRegulate() {
        return regulate;
    }

    public void setRegulate(boolean regulate) {
        this.regulate = regulate;
    }

    public void show(){
        System.out.println("Chair:\n"+"Manufacturer "+getManufacturer()
                +"\n"+"Price "+getPrice()+"\n"+"Material "+getMaterial());

        if(this.isRegulate()){
            System.out.println("Is regulated\n");
        }
        if(!this.isRegulate()){
            System.out.println("Isn't regulated\n");
        }
        System.out.println("---------------------------------------------------");
    }
}
