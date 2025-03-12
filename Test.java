public class Test {
    public static void main(String[] args) {
        String s = "hello world";
        String s1 = "";
        s1 = "hello world";

        String s2 = "hello world world";
       
        s1 = "hello world world";

        System.out.println(s2 == s1);
    }
}