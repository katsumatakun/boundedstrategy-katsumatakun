public class ExceptionBoundedInteger extends BoundedInteger {

    public ExceptionBoundedInteger(int value, int lower, int upper){
        super(value, lower, upper);
        this.lower = lower;
        this.upper = upper;
        setBoundedStrategy(new ThrowException());
        setValue(value);
    }
}
