package com.paloalto.interview.iterators;

import com.sun.org.apache.xpath.internal.operations.String;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RunWith(DataProviderRunner.class)
public class MyIteratorTest {

    @Test(expected = NullPointerException.class)
    public void nullIteratorTest() {
        MyIterator iterator = new MyIterator(null);
    }

    @Test
    public void oneIteratorTest() {
        //Given
        List<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(3);
        List<List<Integer>> data = new ArrayList<>();
        data.add(integers);
        List<Iterator<Integer>> noneNullIterator = buildMyIterator(data);
        //Execute
        MyIterator iterator = new MyIterator(noneNullIterator);
        StringBuilder str = new StringBuilder();
        while (iterator.hasNext()) {
            str.append(" ");
            str.append(iterator.next());
        }
        //Then
        Assert.assertEquals("2 3", str.toString().trim());
    }

    @Test
    public void twoOrMoreIteratorTest() {
        //Given
        List<Integer> odds = new ArrayList<>();
        odds.add(3);
        odds.add(5);

        List<Integer> even = new ArrayList<>();
        even.add(2);
        even.add(4);

        List<List<Integer>> data = new ArrayList<>();
        data.add(odds);
        data.add(even);

        List<Iterator<Integer>> noneNullIterator = buildMyIterator(data);
        //Execute
        MyIterator iterator = new MyIterator(noneNullIterator);
        StringBuilder str = new StringBuilder();
        while (iterator.hasNext()) {
            str.append(" ");
            str.append(iterator.next());
        }
        //Then
        Assert.assertEquals("3 5 2 4", str.toString().trim());
    }

    public List<Iterator<Integer>> buildMyIterator ( List<List<Integer>> input) {

        List<Iterator<Integer>> noneNullIterator = new ArrayList<>();
        for (List<Integer> integers: input ) {
            noneNullIterator.add(integers.iterator());
        }
        return noneNullIterator;
    }



}
