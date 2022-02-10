import java.util.Scanner;
public class Launcher {
    static int fib(int n)
    {
        int a = 0, b = 1, c;
        if (n == 0)
            return a;
        for (int i = 2; i <= n; i++)
        {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
    public static void main(String[] args) {
        System.out.println("Hello");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while (!(input).equals("quit")){
            if (input.equals("fibo"))
            {
                System.out.println("Entrez un nombre :");
                Scanner fs = new Scanner(System.in);
                int f = fs.nextInt();
                System.out.println(fib(f));
            }
            else {
                System.out.println(input);
                System.out.println("Unkown command");
            }
            input = sc.nextLine();
        }
    }
}
