package streamapi;

import java.util.ArrayList;
import java.util.List;

public class StreamApi {

    static List<Integer> ans = new ArrayList<>();

    public static List<Integer> getEvens(List<Integer> list){
        ans.clear();
        list.forEach(i -> {
            if(i % 2 == 0)
                ans.add(i);
        });
        return ans;
    }
    public static List<Integer> getSquares(List<Integer> list){
        ans.clear();
        list.forEach(i -> {
            ans.add(i * i);
        });
        return ans;
    }
    public static int getSum(List<Integer> list){
        int sum = 0;
        for (int i: list)
            sum += i;

        return sum;
    }

    public static void main(String[] args) {

        List<Integer> list = List.of(2,3,4,5,6);
        var eve = getEvens(list);
        var sqa = getSquares(list);
        var sum = getSum(list);
        System.out.println();

    }

}
