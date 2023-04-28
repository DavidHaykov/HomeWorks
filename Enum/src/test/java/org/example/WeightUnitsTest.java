package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeightUnitsTest {

    @Test
    void convert() {
        assertEquals(1000, WeightUnits.TN.convert(WeightUnits.KG));
        assertEquals(0.001, WeightUnits.KG.convert(WeightUnits.TN));
    }

    @Test
    void getGramAmount() {
        assertEquals(453.592, WeightUnits.LBS.getGramAmount(), 0.001);
    }

    @Test
    void convertAmount(){
        assertEquals(1000, WeightUnits.TN.convert(WeightUnits.KG, 1));
        assertEquals(0.001, WeightUnits.KG.convert(WeightUnits.TN));
    }
}