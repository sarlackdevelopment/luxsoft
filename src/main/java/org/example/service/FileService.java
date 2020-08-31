package org.example.service;

import org.springframework.stereotype.Service;

import javax.swing.*;
import java.io.*;
import java.util.*;

@Service
public class FileService {

    public Map<String, ArrayList<HashMap<String, String>>>  readFile(String fileName) {

        HashMap<String, ArrayList<HashMap<String, String>>> answer
                = new HashMap<String, ArrayList<HashMap<String, String>>>();
        ArrayList<HashMap<String, String>> info = new ArrayList<HashMap<String, String>>() {};

        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            
            ArrayList<String> prepare = new ArrayList<>();
            
            while (line != null) {
                prepare.add(line);
                line = reader.readLine();
            }
            
            if (!this.validation(prepare)) {
                answer.put("Not valid", info);
            } else {
                String[] splittingMetaData = prepare.get(0).split(",");
                info.add(new HashMap<String, String>() {{
                    put("name", splittingMetaData[0].trim()); put("value", prepare.get(1).trim());
                }});
                info.add(new HashMap<String, String>() {{
                    put("name", splittingMetaData[1].trim()); put("value", prepare.get(2).trim());
                }});
                info.add(new HashMap<String, String>() {{
                    put("name", splittingMetaData[2].trim()); put("value", prepare.get(3).trim());
                }});
                info.add(new HashMap<String, String>() {{
                    put("name", splittingMetaData[3].trim()); put("value", prepare.get(4).trim());
                }});

                answer.put("OK", info);
            }
        } catch (IOException e) {
            answer.put("Unknown", info);
            return answer;
        }
        return answer;
    }

    private boolean validation(ArrayList<String> value) {
        if (value.size() != 6) {
            return false;
        } else if (!value.get(5).trim().equals("")) {
            return false;
        } else {
            String[] splittingMetaData = value.get(0).split(",");
            if (!(splittingMetaData[0].trim().equals("PRIMARY_KEY")) || !(splittingMetaData[1].trim().equals("NAME"))
                || (!splittingMetaData[2].trim().equals("DESCRIPTION")) || (!splittingMetaData[3].trim().equals("UPDATED_TIMESTAMP"))) {
                return false;
            }
        }
        return true;
    }

}
