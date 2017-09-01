package com.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-06-03
 */
public class FileOperations {
    String currentDir = System.getProperty("user.dir");



    public String readFile(String path) throws IOException {
        String line = "";
        String output = "";
        //String uri = createAbsolutePath(currentDir, path);
        String uri = getPath(path);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(uri));
        while ((line = bufferedReader.readLine())!=null) {
            System.out.println(line);
            output += line + "\n";
        }
        bufferedReader.close();
        return output;
    }

    public String[] breakToWords(String input){
        input = input.replaceAll("\n"," ");
        String[] words = input.split(String.valueOf(" "));
        return words;
    }

    public String[] breakToWords(String input, char separator){
        input = input.replaceAll("\n",String.valueOf(separator));
        String[] words = input.split(String.valueOf(separator));
        return words;
    }

    public List<String> breakToLines(String input){
        String[] lines = input.split(String.valueOf("\n"));
        List<String> linesNonempty = new ArrayList<>();
        for(String line : lines){
            if(!line.isEmpty()){
                linesNonempty.add(line);
            }
        }
        return linesNonempty;
    }

    public String[] breakToWords(String input, String additionalText){
        input = input.replaceAll("\n"," ");
        String[] words = input.split(String.valueOf(" "));
        for (int i=0; i<words.length; i++) {
            words[i] += additionalText;
        }
        return words;
    }

    public void printWords(String[] words, String separator){
        for(int i=0; i<words.length; i++) {
            System.out.print(words[i] + separator);
        }
    }

    public void writeFile(String output, String path) throws IOException{
        //String uri = createAbsolutePath(currentDir, path);
        String uri = getPath(path);
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(uri)
                ));
        System.out.println(output);
        writer.append(output);
        writer.newLine();
        writer.close();
        System.out.println("Data saved successfully.");
    }

    public void writeFile(String[] output, String path) throws IOException{
        //String uri = createAbsolutePath(currentDir, path);
        String uri = getPath(path);
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(uri)
                ));
        for (String line : output) {
            System.out.println(line);
            writer.append(line);
            writer.newLine();
        }
        writer.close();
        System.out.println("Data saved successfully.");
    }

    public String setFileName(){
        String fileName;
        System.out.println("Please enter the desired file name:");
        Scanner scanner = new Scanner(System.in);
        fileName = scanner.nextLine();
        return fileName;
    }

    public String getUserInput(String stopWord){
        String userInput;
        String line="";
        System.out.println("Enter text line by line. To complete input - enter " + stopWord + " in the new line");
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder();
        while (!(line = scanner.nextLine()).equals(stopWord)) {
            stringBuilder.append(line + "\n");
        }
        userInput = String.valueOf(stringBuilder);
        return userInput;
    }

    public String parseProperties(String userInput){
        String properties = "";
        List<String> lines = breakToLines(userInput);
        List<String> keys = new ArrayList<>();
        List<String> values = new ArrayList<>();
        int index = 0;
        for (int i=0; i<lines.size(); i++) {
            String[] keyValue = breakToWords(lines.get(i),',');
            if(keyValue.length == 2) {
                if (keys.indexOf(keyValue[0]) != -1){
                    values.remove(keys.indexOf(keyValue[0]));
                    values.add(keys.indexOf(keyValue[0]), keyValue[1]);
                } else {
                    keys.add(index, keyValue[0]);
                    values.add(index, keyValue[1]);
                    index++;
                }
            }
        }
        for (int i = 0; i<keys.size(); i++){
            properties += keys.get(i) + "=" + values.get(i) + "\n";
        }
        return properties;
    }

@Deprecated
    public String getAbsolutePath(String relativePath){
        String filePath;
        String linuxStyle = currentDir + relativePath;
        String windowsStyle = currentDir + relativePath;
        filePath = linuxStyle;
        System.out.println(filePath);
        return filePath;
    }
@Deprecated
    public String createAbsolutePath(String project, String relatedToProject){
        File file = new File(project, relatedToProject);
        return file.getAbsolutePath();
    }

    public String getPath(String fileName){
        String path = null;
        URL url = this.getClass().getClassLoader().getResource(fileName);
        if (url != null){
            path = url.getPath();
        } else {
            System.out.println("Resources not found");
        }
        return path;
    }

}
