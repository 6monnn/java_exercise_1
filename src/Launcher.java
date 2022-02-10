import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.util.Arrays;

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

    static int[] freq(String[] arr)
    {
        int fr[] = new int [arr.length];
        int visited = -1;
        for(int i = 0; i < arr.length; i++)
        {
            int count = 1;
            for(int j = i+1; j < arr.length; j++)
            {
                if(arr[i].equals(arr[j]))
                {
                    count++;
                    fr[j] = visited;
                }
            }
            if(fr[i] != visited)
                fr[i] = count;
        }
        return fr;
    }
    static void bubbleSort(int arr[], String tab[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] < arr[j+1])
                {
                    // swap arr[j+1] and arr[j]
                    String tmp = tab[j];
                    int temp = arr[j];
                    tab[j] = tab[j+1];
                    tab[j+1] = tmp;
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }

    public static void main(String[] args) {
        System.out.println("Hello");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        while (!(input).equals("quit")){
            Scanner fs = new Scanner(System.in);
            if (input.equals("fibo"))
            {
                System.out.println("Entrez un nombre :");
                int f = fs.nextInt();
                System.out.println(fib(f));
            }
            if (input.equals("freq")){
                System.out.println("Entrez le chemin du fichier");
                String p = fs.nextLine();
                Path filePath = Paths.get(p);

                try
                {
                    String content = Files.readString(filePath);
                    String[] words = content.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
                    int[] array = freq(words);

                    bubbleSort(array, words);
                    if (words.length > 0){
                        System.out.printf("%s", words[0]);
                    }
                    for (int i = 1; i < 3 ; i++)
                    {
                        System.out.printf(" %s", words[i]);
                    }
                    System.out.println("");
                }
                catch (IOException e)
                {
                    System.out.printf("Unreadable file : %s\n", p);
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("Unkown command");
            }
            input = sc.nextLine();
        }
    }
}
