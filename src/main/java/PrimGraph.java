import java.util.Arrays;

public class PrimGraph {
    public void Prim(int G[][], int V){ // G -- матрица смежности и V -- кол-во вершин
        int INF = Integer.MAX_VALUE;
        int cur_edge;
        int minWeight;
        boolean[] selected = new boolean[V];  //
        Arrays.fill(selected, false);
        cur_edge = 0;
        minWeight = 0;
        selected[0] = true;
        System.out.println("Edge : Weight");

        while (cur_edge < V - 1) {
            int min = INF;
            int row = 0;
            int col = 0;

            for (int i = 0; i < V; i++) {
                if (selected[i] == true) {
                    for (int j = 0; j < V; j++) {
                        if (!selected[j] && G[i][j] != 0) {
                            if (min > G[i][j]) {
                                min = G[i][j];
                                row = i;
                                col = j;
                            }
                        }
                    }
                }
            }
            System.out.println(row + " - " + col + " :  " + G[row][col]);
            minWeight += G[row][col];
            selected[col] = true;
            cur_edge++;
        }
        System.out.println("Вес: " + minWeight);
    }


    public static void main(String[] args) {
        PrimGraph g = new PrimGraph();
        int V = 6;
        int[][] G = {
                { 0, 7, 8, 0, 0, 0 },
                { 7, 0, 11, 2, 0, 0 },
                { 8, 11, 0, 6, 9, 0 },
                { 0, 2, 6, 0, 11, 9 },
                { 0, 0, 9, 11, 0, 10 },
                { 0, 0, 0, 9, 10, 0 }
        };
       g.Prim(G, V);
    }
}
