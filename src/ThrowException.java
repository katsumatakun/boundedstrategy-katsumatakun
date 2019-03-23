public class ThrowException implements BoundedStrategy {

    @Override
    public int checkValue(int value, int lower, int upper){
        if (value > upper || value < lower ){
            throw new OutOfBoundsException(" Value Out of Bounds");
        }
        return value;
    }
}
