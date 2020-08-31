package org.example.service;

import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;

@Service
public class FileService {

    public void readFile(String fileName) {

        try(FileReader reader = new FileReader(fileName)) {
            int currentSymbol;
            while((currentSymbol = reader.read()) != -1){
                System.out.print((char)currentSymbol);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
