public class Wrap implements BoundedStrategy {

    @Override
    public int checkValue(int value, int lower, int upper){
        while (value > upper){
            value = value - upper + lower -1;
        }
        while (value < lower){
            value = upper - (lower - value) + 1;
        }

        return value;
    }

}

