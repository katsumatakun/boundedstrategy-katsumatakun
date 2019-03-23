public class WrappedBoundedInteger extends BoundedInteger {

    public WrappedBoundedInteger(int value, int lower, int upper){
        super(value, lower, upper);
        this.lower = lower;
        this.upper = upper;
        setBoundedStrategy(new Wrap());
        setValue(value);
    }
}
