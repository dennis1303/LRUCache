package com.inmobi.panda.cache; /**
 * Created by ankit.anand on 28/06/17.
 */
import com.inmobi.panda.cache.LRUCache;
import org.junit.Assert;
import org.junit.Test;

public class LRUCacheTest {

    @Test
    public void test1(){
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1,1);
        Assert.assertEquals(lruCache.get(1),(Integer)(1));
        lruCache.put(2,2);
        Assert.assertEquals(lruCache.get(2),(Integer)(1));
        lruCache.put(3,3);
        Assert.assertEquals(lruCache.get(3),(Integer)(1));
        Assert.assertEquals(lruCache.get(4),(Integer)(-1));
        lruCache.put(2,2);
        Assert.assertEquals(lruCache.get(2),(Integer)(1));
        lruCache.put(4,4);
        Assert.assertEquals(lruCache.get(4),(Integer)(1));
        Assert.assertEquals(lruCache.get(1),(Integer)(-1));
    }
}
