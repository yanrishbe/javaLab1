package not_main;

public class Stool extends Chair {

    public Stool(boolean sectional, boolean regulate) {
        this.sectional = sectional;
        this.regulate = regulate;
    }

    public boolean isSectional() {
        return this.sectional;
    }

    public void print() {
        System.out.println("Stool:\n"+"Manufacturer "+this.manufacturer
                +"\n"+"Price "+this.price+"\n"+"Material "+this.material);
        if(this.isSectional()){
            System.out.println("Is sectional\n");
        }
        if(!this.isSectional()){
            System.out.println("Isn't sectional\n");
        }

        if(this.isRegulate()){
            System.out.println("Is regulated\n");
        }
        if(!this.isRegulate()){
            System.out.println("Isn't regulated\n");
        }
        System.out.println("---------------------------------------------------");
    }
}
