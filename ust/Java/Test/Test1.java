import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Test1 {
    public static void main(String[] args) {

        HashMap<String, BigDecimal> hm = new HashMap<>();
        hm.put("key1",BigDecimal.valueOf(1));
        hm.put("key2",BigDecimal.valueOf(2));
        hm.put("key3",BigDecimal.valueOf(3));
        hm.put("key4",BigDecimal.valueOf(4));
        hm.put("key5",BigDecimal.valueOf(5));

        System.out.println(hm.values().stream().reduce((sum, e) -> sum.add(e)).orElse(BigDecimal.ZERO));

    }
}
