package ex41;
import java.util.*;
import java.io.*;
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Adam Nogueira
 */
public class App41
{
    public static void readNames(Scanner input, ArrayList<String> names) {
        while (input.hasNextLine()) {
            names.add(input.nextLine());
        }
    }

    public static void outputNames(ArrayList<String> names) throws IOException {
        FileWriter output = new FileWriter("C:\\Users\\azxyg\\Documents\\OOP JAVA\\Projects\\nogueira-cop3330-Assignment3\\InputFiles\\exercise41_output.txt");
        output.write("Total of " + names.size() + " names\n");
        output.write("--------------------\n");

        for (String i : names) {

            output.write(i + "\n");

        }
        output.close();

    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner inputFile = new Scanner(new File("C:\\Users\\azxyg\\Documents\\OOP JAVA\\Projects\\nogueira-cop3330-Assignment3\\InputFiles\\exercise41_input.txt"));
        ArrayList<String> names = new ArrayList<String>();
        readNames(inputFile, names);

        Collections.sort(names, String.CASE_INSENSITIVE_ORDER);

        inputFile.close();
        try {
            outputNames(names);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}