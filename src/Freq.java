import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Freq implements Command{
    @Override
    public String name() {
        return "freq";
    }

    @Override
    public boolean run(Scanner console) {
        System.out.printf("Enter a path\n");
        String path = console.nextLine();
        Path filepath = Paths.get(path);

        try {
            String content = Files.readString(filepath);
            freq(content);
        }
        catch (IOException e) {
            System.out.printf("Unreadable file: \n");
            e.printStackTrace();
        }
        return true;
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
    static int[] frequencies(String[] arr)
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
    public static void freq(String str){
        String[] words = str.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        int[] array = frequencies(words);

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
}