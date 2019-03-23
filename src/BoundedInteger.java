public abstract class BoundedInteger {
    protected int value;
    protected int lower;
    protected int upper;
    private BoundedStrategy bs;

    public BoundedInteger(int value, int lower, int upper){
        if(lower > upper)
            throw new IllegalArgumentException("Illegal Interval");
    }

    public void setValue(int value){

        this.value = bs.checkValue(value, lower, upper);
    }

    public void setBoundedStrategy(BoundedStrategy bs){
        this.bs = bs;
    }

    public int getValue(){
        return value;
    }

    public void addWith(int num){

        setValue(value + num);

    }
}
