import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {

    public  void generate() throws IOException {
        int count = 1;
        int bound = 1;

        while (count != 101){
            List<Integer> list = getData(bound);
            FileWriter fileWriter = new FileWriter("src/test/java/filesForTests/FILE" + count + ".txt");
            for (int i = 0; i < bound * bound; i++) {
                fileWriter.write("" + list.get(i));
                fileWriter.write("\n");
            }
            bound += 5;
            count++;
            fileWriter.close();
        }

    }


    public static int[][] randomG(int V) {
        int[][] G = new int[V][V];
        Random random = new Random();

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) {
                    G[i][j] = 0;
                }else {
                    G[i][j] = random.nextInt(1000);
                }
            }
        }
        return G;
    }


    public  List<Integer> getData(int V){
        List<Integer> list;
        int[][] array;

        list = new ArrayList<>();
        array = randomG(V);
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                list.add(array[i][j]);
            }
        }
        return list;
    }
}
