package not_main;

public abstract class Chair implements Furniture, Object {
    boolean regulate;
    boolean sectional;

    @Override
    public abstract boolean isSectional();

    public void setSectional(boolean sectional) {
        this.sectional = sectional;
    }

    public boolean isRegulate() {
        return regulate;
    }

    public void setRegulate(boolean regulate) {
        this.regulate = regulate;
    }
    //переопределение потому что добавляется abstract
    @Override
    public abstract void print();
}
