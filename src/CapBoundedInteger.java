public class CapBoundedInteger extends BoundedInteger {

    public CapBoundedInteger(int value, int lower, int upper){
        super(value, lower, upper);
        this.lower = lower;
        this.upper = upper;
        setBoundedStrategy(new Cap());
        setValue(value);
    }
}
