package com.company;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class ReadFile_BufferedReader {

    public static void main(String[] args) throws IOException {
        double wantedSize = Double.parseDouble("2.0");
        Random rd = new Random();
        Scanner in = new Scanner(System.in);
        String fileName;
        System.out.println("Enter the fileName with extension : ");
        File file = new File(fileName = in.nextLine());

        PrintWriter printWriter = new PrintWriter(file);
        int count = 0;
        while(true){
            String space = "";
            for(int i = 0; i < 100; i++){
                int nb = rd.nextInt(1000) + 1;
                printWriter.print(space);
                printWriter.print(nb);
                space = " ";
            }
            printWriter.println();

            if(++count == 20000){
                if(file.length() >= wantedSize*1e9){
                    printWriter.close();
                    break;
                }
                else{
                    count = 0;
                }
            }
        }


        FileReader fileReader = new FileReader (fileName);

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while((line = bufferedReader.readLine()) != null)
            System.out.println(line);
    }
}
