package com.prussia.test.myspring.util;

import com.prussia.play.spring.domain.vo.Quote;
import com.prussia.play.spring.domain.vo.Value;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

@Slf4j
public class ReferenceTest {

    @Test
    public void testStrongReference() {
        Map<Quote, Value> aMap = new
                HashMap<Quote, Value>();

        Quote quote = new Quote();
        Value value = new Value();

        aMap.put(quote, value);

        quote = null;

        System.gc();
        System.out.println("aMap.size() = " + aMap.size());

        Assert.assertEquals(aMap.size(), 1);
    }

    @Test
    public void testWeakHashMap() {
        WeakHashMap<Quote, Value> aMap = new
                WeakHashMap<Quote, Value>();

        Quote quote = new Quote();
        Value value = new Value();

        aMap.put(quote, value);

        quote = null;

        System.gc();
        int count = 0;
        while (0 != aMap.size()) {
            ++count;
            System.gc();
        }
        System.out.println("Took " + count
                + " calls to System.gc() to result in weakHashMap size of : "
                + aMap.size());
    }
}
