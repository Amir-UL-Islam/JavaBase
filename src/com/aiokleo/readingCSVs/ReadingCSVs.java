package com.aiokleo.readingCSVs;

import java.io.*;
public class ReadingCSVs{
    public static void main(String[] args) throws FileNotFoundException, IOException{
        String path = "/home/aiokleo/datasets/agents.csv";
        String line = "";

        BufferedReader br = new BufferedReader(new FileReader(path));

        while((line = br.readLine()) != null){
            String[] lines = line.split(",");
            System.out.println(lines[1]);
        }
    }
}
