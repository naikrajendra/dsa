package com.rpk;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.hackerrank.warmup.BigSorting;
import com.hackerrank.warmup.FairRations;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void shouldHandleImmutableInputList() {
        assertEquals("4", FairRations.fairRations(List.of(1, 2, 3)));
    }

    @Test
    public void shouldSortImmutableBigNumbers() {
        List<String> input = List.of("3", "123", "45", "6", "7890");
        List<String> expected = List.of("3", "6", "45", "123", "7890");
        assertEquals(expected, BigSorting.bigSorting(input));
    }
}
