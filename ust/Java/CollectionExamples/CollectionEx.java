package CollectionExamples;

import java.util.*;

public class CollectionEx {
    public static void main(String[] args) {
//        Collection ar = new ArrayList();
        Collection ar = new HashSet();
        ar.add(10);
        ar.add("Laptop");
        ar.add(7.5);
        ar.add(true);

        ar.remove(7.5);

        for(var a: ar){
            System.out.print(a + " ");
        }
    }
}
