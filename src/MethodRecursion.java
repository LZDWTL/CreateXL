import java.util.Scanner;

public class MethodRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num=sc.nextInt();
        System.out.println(recursion(num));


    }


    static int recursion(int num) {
        if (num <= 2) {
            return num;
        }
        else return num*recursion(num-1);
    }
}
