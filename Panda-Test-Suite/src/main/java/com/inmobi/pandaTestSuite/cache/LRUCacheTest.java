package com.inmobi.pandaTestSuite.cache;

import com.inmobi.*;
import com.inmobi.panda.cache.LRUCache;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by ankit.anand on 29/06/17.
 */
public class LRUCacheTest {

    LRUCache lruCache;

    @BeforeMethod
    public void beforTest(){
        lruCache = new LRUCache(5);
    }

    @Test
    public void testIfEmptyCacheReturnsNothing(){
        Assert.assertEquals(lruCache.get(10),(Integer)(-1));
    }

    @Test
    public void testIfKeyCanBePushedInCache() {
        lruCache.put(1,1);
        Assert.assertEquals(lruCache.get(1),(Integer)(1));
    }

    @Test
    public void testIfMultipleKeysCanBeStoredBeforeReachingCacheCapacity(){
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        lruCache.put(4,4);
        Assert.assertEquals(lruCache.get(1),(Integer)(1));
        Assert.assertEquals(lruCache.get(2),(Integer)(1));
        Assert.assertEquals(lruCache.get(3),(Integer)(1));
        Assert.assertEquals(lruCache.get(4),(Integer)(1));
    }

    @Test
    public void testIfMultipleKeysCanBeStoredAfterReachingCacheCapacity(){
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        lruCache.put(4,4);
        lruCache.put(5,5);
        Assert.assertEquals(lruCache.get(1),(Integer)(1));
        Assert.assertEquals(lruCache.get(2),(Integer)(1));
        Assert.assertEquals(lruCache.get(3),(Integer)(1));
        Assert.assertEquals(lruCache.get(4),(Integer)(1));
        Assert.assertEquals(lruCache.get(5),(Integer)(1));
        lruCache.put(6,6);
        Assert.assertEquals(lruCache.get(6),(Integer)(1));
        Assert.assertEquals(lruCache.get(1),(Integer)(-1));
    }

}
