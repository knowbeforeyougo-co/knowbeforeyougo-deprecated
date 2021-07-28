package com.yakovliam.knowbeforeyougo.client.calculator;

public interface Calculator<K, V> {

    /**
     * Calculate v given k
     *
     * @param k k
     * @return v
     */
    V calculate(K k);

}
