package Java8;

public interface A {
    default void print(){
        System.out.println("Hello from A");
    }
}
