package com.convertspeed;

import com.utils.FileOperations;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

/**
 * @author Denys Ovcharuk (DOV) / WorldTicket A/S
 * @since 2017-09-02
 */
public class ConvertSpeedsTest {

    private ConvertSpeedsClient convertSpeedsClient = new ConvertSpeedsClient();
    private ConvertSpeedsSoap convertSpeedsSoap = convertSpeedsClient.client;

    private static HashSet inputDataCsvParser(String filePath){
        FileOperations fileOperations = new FileOperations();
        String inputData="";
        try {
            inputData = fileOperations.readFile(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> inputLines = fileOperations.breakToLines(inputData);
        HashSet<HashMap> parsedData = new HashSet();
        for(String line : inputLines){
            String[] wordsInLine = fileOperations.breakToWords(line,',');
            HashMap<String, String> dataLine = new HashMap();
            dataLine.put("from",wordsInLine[0]);
            dataLine.put("to",wordsInLine[1]);
            dataLine.put("speed",wordsInLine[2]);
            dataLine.put("expectedResult",wordsInLine[3]);
            parsedData.add(dataLine);
        }
        return parsedData;
    }

    @DataProvider(name="Calculations")
    public static Object[] calculations(){
        HashSet hashSet = inputDataCsvParser("convertspeed/speed-parameters.csv");
        Object[] objects = hashSet.toArray();
        return objects;
    }

    @Test(dataProvider = "Calculations")
    public void getSpeed(HashMap data) {
        Double convertSpeed = convertSpeedsSoap.convertSpeed(Double.valueOf(data.get("speed").toString()),SpeedUnit.fromValue(data.get("from").toString()),SpeedUnit.fromValue(data.get("to").toString()));
        assertEquals(Double.valueOf(data.get("expectedResult").toString()),convertSpeed);
    }
}