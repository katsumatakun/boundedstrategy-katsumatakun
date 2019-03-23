public class Cap implements BoundedStrategy {

    public int checkValue(int value, int lower, int upper){
        if(value > upper)
            value = upper;
        if(value < lower)
            value = lower;
        return value;
    }
}
