import java.util.Random;

public class ArrayRand {
    public static void main(String[] args) {
        Random rand = new Random();
        int []a = new int[10];

        for (int i = 0; i <a.length; i++) {
            a[i] = rand.nextInt(90)+10;
        }
        for(int i: a){
            System.out.print(i + " ");
        }

        // 2D array

        System.out.println();
        int b[][] = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        for(int rows[]: b){
            for(int ele: rows){
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
