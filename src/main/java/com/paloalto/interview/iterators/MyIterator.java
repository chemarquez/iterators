package com.paloalto.interview.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class MyIterator {
    List<Integer> iterators;
    Iterator<Integer> innerIterator;

    int currentIndex = 0;

    public MyIterator(List<Iterator<Integer>> iterators) {
        Objects.requireNonNull(iterators, "iterators parameter cannot be null");
        this.iterators = flatten(iterators);
        this.innerIterator = this.iterators.iterator();
    }

    private List<Integer> flatten(List<Iterator<Integer>> iterators) {
        List<Integer> result = new ArrayList<Integer>();

        for (Iterator<Integer> nestedIterator : iterators) {
            while(nestedIterator.hasNext() ) {
                result.add(nestedIterator.next());
            }
        }
        return result;
    }

    public Integer next() {
        return this.innerIterator.next();
    }

    public boolean hasNext() {
        return this.innerIterator.hasNext();
    }

}

