package com.inmobi.panda.cache;

import java.util.*;

/**
 * Created by ankit.anand on 28/06/17.
 */
public class LRUCache implements Cache<Integer,Integer,Integer>  {

    private int capacity;
    private HashMap<Integer,Integer> cacheMap;
    private List<Integer> queue;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<>();
        queue = new ArrayList<>();
    }

    private void evict(){
        cacheMap.remove(queue.get(0));
        queue.remove(0);
    }



    @Override
    public synchronized Integer get(Integer key) {
        if(cacheMap.containsKey(key))
        {
            return 1;
        }
        return -1;
    }

    @Override
    public synchronized void put(Integer key, Integer value) {
        if(queue.size() < capacity){
            if(get(key) == -1){
                queue.add(key);
                cacheMap.put(key,value);

            }
            else{
                queue.remove(queue.indexOf(key));
                queue.add(key);
                cacheMap.put(key,value);
            }
        }
        else{
            if(get(key) == -1){
                evict();
                queue.add(key);
                cacheMap.put(key,value);
            }
            else{
                queue.remove(cacheMap.get(key));
                queue.add(key);
                cacheMap.put(key,value);
            }
        }
    }



}




