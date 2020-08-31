package org.example.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class FileService {

//    private enum Status {
//        Ok, IllegalFormat, IllegalType, Unknown;
//    }

    public Map<String, ArrayList<Map<String, String>>> readFile(String fileName) {

        HashMap<String, ArrayList<Map<String, String>>> answer
                = new HashMap<String, ArrayList<Map<String, String>>>();
        ArrayList<Map<String, String>> info = new ArrayList<Map<String, String>>() {};

//        try(FileReader reader = new FileReader(fileName)) {
//
//            int currentSymbol;
//            while((currentSymbol = reader.read()) != -1) {
//                //System.out.print((char)currentSymbol);
//            }
//
//            answer.put("Ok", info);
//
//            return answer;
//        }
//        catch(IOException ex){
//            answer.put("Unknown", info);
//            return answer;
//        }

        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            answer.put("Ok", info);
            return answer;
        } catch (IOException e) {
            answer.put("Unknown", info);
            return answer;
        }
    }

}
