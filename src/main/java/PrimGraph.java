import java.util.Arrays;

public class PrimGraph {
    public void Prim(int G[][], int V){ // G -- матрица смежности и V -- кол-во вершин

        int INF = Integer.MAX_VALUE; // используем значение для сравнения
        int countEdge;  // отслеживаем текущее кол-во проверенных ребер
        int minWeight; // значение минимального веса остовного дерева
        boolean[] selected = new boolean[V];  // массив помеченных вершин

        Arrays.fill(selected, false);
        countEdge = 0;
        minWeight = 0;
        selected[0] = true; // произвольная начальная вершина всегда помечена
        System.out.println("Edge : Weight");

        while (countEdge < V - 1) {
            int min = INF;
            int row = 0;
            int col = 0;

            for (int i = 0; i < V; i++) { // i - индекс строки
                if (selected[i]) {
                    for (int j = 0; j < V; j++) { // j - индекс столбца
                        if (!selected[j] && G[i][j] != 0) { // вершина не помечена и есть ребро
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
            selected[col] = true; // вершина помечена
            countEdge++;
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
