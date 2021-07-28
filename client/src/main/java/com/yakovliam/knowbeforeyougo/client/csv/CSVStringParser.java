package com.yakovliam.knowbeforeyougo.client.csv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

public class CSVStringParser implements CSVParser<String, List<String[]>> {

    @Override
    public List<String[]> parse(String s) {
        // parse csv string
        CSVReader reader = new CSVReader(new StringReader(s));

        List<String[]> records;

        try {
            records = reader.readAll();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
            return null;
        }

        return records;
    }
}
