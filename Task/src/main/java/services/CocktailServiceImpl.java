package services;


import model.Beverage;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import org.json.*;



public class CocktailServiceImpl implements СocktailsService {
    @Override
    public void makeСocktail(Beverage beverage) throws IOException {
        String source = "https://www.thecocktaildb.com/api/json/v1/1/search.php?s=" + beverage.getName();
        URLConnection connection = new URL(source).openConnection();
        InputStream input = connection.getInputStream();
        Scanner sc = new Scanner(input);
        sc.useDelimiter("\\Z");
        String content = sc.next();
        sc.close();

        JSONObject j = new JSONObject(content);

        var l = j.getJSONArray("drinks");
        var b = l.getJSONObject(0);


        File file = new File("/Users/polinom/Repositories/Task/src/main/java/beverage/description");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("Description:\n");
        fileWriter.write("Instructions:\n"  + b.getString("strInstructions"));

        var h = b.keySet();


//open picture
        URL urlJpeg = new URL("https://www.thecocktaildb.com/images/media/drink/9179i01503565212.jpg");
        URLConnection hpCon = urlJpeg.openConnection();
        hpCon.connect();



        for (var s: h) {
            fileWriter.write(s +": " +  b.get(s) + "\n");
        }

        fileWriter.flush();






//        for (var obj : l) {
//
//        }

//        System.out.println(l.toString());

//        System.out.println(l.toString(1));
//    forEach((x) -> System.out.println(((JSONObject)x).getString("strDrink")));


      System.out.println(l.toString(1));


    }
}


