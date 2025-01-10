public class StringExample {
    public static void main(String[] args) {
        String str1 = "ust";
        String str2 = "ust";

        str1 = "hello";

        System.out.println(str1 == str2);

        String s1 = new String("ust");
        String s2 = new String("ust");

        System.out.println(s1.equals(s2));

        String str = "UST Global";
//        char s[] = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }

        System.out.println(str);
    }
}
