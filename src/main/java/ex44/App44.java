package ex44;
import java.util.*;
import java.io.*;
import org.json.simple.*;
import org.json.simple.parser.*;
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Adam Nogueira
 */
public class App44 {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("C:\\Users\\azxyg\\Documents\\OOP JAVA\\Projects\\nogueira-cop3330-Assignment3\\InputFiles\\exercise44_input.json"));
            JSONObject jsonObject = (JSONObject)obj;
            JSONArray subjects = (JSONArray)jsonObject.get("products");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String input;
            int flag = 0;
            System.out.print("What is the product name? ");
            input = bufferedReader.readLine();
            Iterator iterator = subjects.iterator();
            while (iterator.hasNext()) {
                JSONObject json = (JSONObject) iterator.next();
                String name = (String)json.get("name");
                if(input.toLowerCase().equals(name.toLowerCase())){
                    System.out.println("Name: "+name);
                    System.out.println("Price: "+json.get("price"));
                    System.out.println("Quantity: "+json.get("quantity"));
                    flag = 1;
                }
            }
            if(flag == 0){
                System.out.println("Sorry, that product was not found in our inventory");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

