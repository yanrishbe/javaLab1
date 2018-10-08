package not_main;

public class Bar_Stool extends Chair {

    public boolean isSectional() {
        return this.sectional;
    }

    public void print() {
        System.out.println("Bar stool:\n"+"Manufacturer "+this.manufacturer
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
