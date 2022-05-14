import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TimePrimTest {
    public static HashMap<Integer, int[][]> allData() throws IOException {
        HashMap<Integer, int[][]> data = new HashMap<>();
        int V = 1;
        for (int i = 1; i < 101; i++) {
            File file = new File("src/test/java/filesForTests/FILE" + i + ".txt");
            Scanner scanner = new Scanner(file);
            int[][] G = new int[V][V];
            for (int j = 0; j < V; j++) {
                for (int k = 0; k < V; k++) {
                    int num = scanner.nextInt();
                    G[j][k] = num;
                }
            }
            data.put(V, G);
            V += 5;
        }
        return data;
    }


    public static List<Long> getResult(HashMap<Integer, int[][]> allData){
        List<Long> result = new ArrayList<>();
        PrimGraph primGraph = new PrimGraph();
        int V = 1;
        for (int i = 0; i < allData.size(); i ++) {
            int[][] G = allData.get(V);
            long start = System.nanoTime();
            primGraph.Prim(G, V);
            long t = System.nanoTime() - start;
            result.add(t);
            V += 5;
        }
        return result;
    }


    public static void creatSheet(List<Long> list){
        String FILE_NAME = "src/test/java/filesForTests/result.xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
        int rowNum = 0;
        int colNum1 = 0;
        int colNum2 = 1;
        int k = 1;
        System.out.println("Creating excelList");
        for (int i = 0; i < list.size(); i++) {
            Row row = sheet.createRow(rowNum++);
            Cell cell1 = row.createCell(colNum1);
            Cell cell2 = row.createCell(colNum2);

            cell1.setCellValue(list.get(i));
            cell2.setCellValue(k + " * " + k);
            k += 5;
        }
        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }

    public static void main(String[] args) throws IOException {
        creatSheet(getResult(allData()));
    }
}
