package CollectionExamples;

class CalculatorClass<T> {

    private T value;

    public CalculatorClass(T value) {
        this.value = value;
    }

    public T getValue(){
        return value;
    }

    public void setValue(T value){
        this.value = value;
    }

    public T doubleValue(){
//        return switch (value){
//            case Integer i -> (T) Integer.valueOf((i*2);
//            case String str -> (T) (str + str);
//
//            default -> value;
//        };

        if(value instanceof Integer){
            return (T) Integer.valueOf((int)value * 2);
        }
        else if( value instanceof String){
            return (T) Integer.valueOf( (int)value + (int)value);
        }
        return value;
    }

}

public class Calculator{
    public static void main(String[] args) {
        CalculatorClass<String> cal = new CalculatorClass<>("10");
        System.out.println(cal.getValue());
        System.out.println(cal.doubleValue());
    }
}