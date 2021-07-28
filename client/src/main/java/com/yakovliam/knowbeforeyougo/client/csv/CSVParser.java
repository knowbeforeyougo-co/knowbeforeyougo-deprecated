package com.yakovliam.knowbeforeyougo.client.csv;

public interface CSVParser<K, V> {

    /**
     * Parses k context into V
     *
     * @param k k context
     * @return V
     */
    V parse(K k);

}
