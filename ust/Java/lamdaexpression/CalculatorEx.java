package lamdaexpression;

interface MathOperation{
    int doCalculation(int a, int b);
}

class Calculator {
    int calculate(int a, int b, MathOperation operation){
        return operation.doCalculation(a, b);
    }
}

public class CalculatorEx {
    public static void main(String[] args) {
        Calculator calci = new Calculator();
        int sum = calci.calculate(10, 5, (a, b)-> a+b);
        int substract = calci.calculate(10, 5, (a, b)-> a-b);
        int largest = calci.calculate(10, 5, (a, b)-> a>b? a: b);
        int gcp = calci.calculate(10, 5, (a,b)-> {
            int g = 1;
            int larger = a > b? a: b;
            for (int i = 0; i <= larger; i++) {
                if(a % i == 0 && b % i == 0){
                    g = i;
                }
            }
            return g;
        });

        System.out.println(gcp);
    }
}