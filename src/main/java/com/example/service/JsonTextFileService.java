package com.example.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.springframework.stereotype.Service;

@Service
public class JsonTextFileService {
   
     public void createJsonFile(String jsoString) {
        File fout = new File("jsonFile.txt");
        FileOutputStream fos;

        try {
            fos = new FileOutputStream(fout);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            String[] jsonStringArray = jsoString.split(" ");
            int keysCounter = -1;
            int squareBracketCounter = 0;
            for (String jsonWord : jsonStringArray) {

                if ((jsonWord.contains("{") || jsonWord.contains("}")
                        && !(jsonWord.indexOf("}") == jsonWord.length() - 1
                                || jsonWord.indexOf("}") == jsonWord.length() - 2))
                        || jsonWord.contains("[")) {

                    keysCounter++;
                    bw.newLine();

                    if (jsonWord.contains("["))
                        squareBracketCounter=keysCounter;

                    if (keysCounter > 1) {
                        for (int i = 0; i <= keysCounter; i++) {
                            bw.write("\t");
                        }
                        bw.write(jsonWord);
                        bw.newLine();
                        bw.write("\t");
                    } else {
                        keysCounter++;
                        bw.write(jsonWord);
                        bw.newLine();
                    }

                    bw.write("\t");

                } else if (jsonWord.contains("{")
                        && (jsonWord.indexOf("{") == jsonWord.length() - 2
                                || jsonWord.indexOf("{") == jsonWord.length() - 1)) {

                    String[] jsonKeyArray = jsonWord.split("\"");
                    bw.write(jsonKeyArray[0] + "\"");
                    bw.newLine();
                    if (jsonKeyArray.length > 1)
                        bw.write("\t" + jsonKeyArray[1]);
                    bw.write("\t");
                } else if (jsonWord.contains("}")
                        && (jsonWord.indexOf("}") == jsonWord.length() - 2
                                || jsonWord.indexOf("}") == jsonWord.length() - 1)

                ) {

                    String[] jsonKeyArray = jsonWord.split("\"");

                    if (jsonKeyArray.length > 1 && keysCounter == 0) {
                        bw.write("\t" + jsonKeyArray[1]);
                    } else if (keysCounter > 1) {
                        for (int i = 0; i <= keysCounter; i++) {
                            bw.write("\t");
                        }
                        bw.newLine();
                        bw.write("\t" + jsonKeyArray[0]);
                        bw.write("\t");
                        bw.newLine();
                    } else {
                        bw.write(jsonKeyArray[0] + "\"");
                        bw.newLine();
                    }

                } else if (jsonWord.contains("]")) {
                   
                    char [] jsonCharArray =jsonWord.toCharArray();

                   // for(int i=0 ; i<=squareBracketCounter;i++)
                    //{   
                    //    bw.write();
                   // }
                    
                } else if (jsonWord.contains(",") && keysCounter <= 0) {
                    bw.write(jsonWord + " ");
                    bw.newLine();
                    bw.write("\t");
                } else if (jsonWord.contains(",") && keysCounter > 0) {
                    bw.write(jsonWord + " ");
                    bw.newLine();
                    for (int i = 1; i < keysCounter; i++)
                        bw.write("\t");
                } else {
                    bw.write(jsonWord + " ");
                }
                bw.append(" ");

            }
            bw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
