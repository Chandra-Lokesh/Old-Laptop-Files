package designpattern.creational.singleton;

public class PlayService {

    private String value;

    private static PlayService obj;
    public static PlayService getObject(){
        if(obj == null){
            obj = new PlayService();
        }
        return obj;
    }

    private PlayService(){

    }

    public void printValue(){
        System.out.println("Value: " + value);
    }

    public void setValue(String value) {
        this.value = value;
    }
}
