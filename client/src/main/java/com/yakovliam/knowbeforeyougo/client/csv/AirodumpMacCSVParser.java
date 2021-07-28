package com.yakovliam.knowbeforeyougo.client.csv;

import java.util.List;

public class AirodumpMacCSVParser implements CSVParser<List<String[]>, List<String>> {

    /**
     * Parses a record list into a list of uuids of all nearby devices
     * Does NOT account for the manufacturer of the device
     *
     * @param strings records
     * @return mac addresses
     */
    @Override
    public List<String> parse(List<String[]> strings) {
        // TODO
        return null;
    }
}
