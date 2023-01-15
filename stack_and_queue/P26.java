package stack_and_queue;
import java.util.*;

// LRU Cache Implementation

public class P26 {

    //Constructor for initializing the cache capacity with the given value.
    public LinkedHashMap<Integer , Integer> map ;
    int cachesize;

    P26(int cap) {
        //code here
        this.cachesize = cap;
        this.map  = new LinkedHashMap<>();

    }

    //Function to return value corresponding to the key.
    public  int get(int key) {
        // your code here
        if(map.containsKey(key)){
            int v = map.get(key);
            makeRecent(key , v);
            return map.get(key);
        }else{
            return -1;
        }
    }

    //Function for storing key-value pair.
    public  void set(int key, int value) {
        // your code here

        if(map.containsKey(key)){
            map.put(key , value);
            makeRecent(key , value);
        }else{
            map.put(key , value );
            makeRecent(key, value);
        }

        if(map.size() > cachesize ){
            map.remove(map.entrySet().iterator().next().getKey());
        }
    }

    public  void makeRecent(int key , int value){
        map.remove(key);
        map.put(key, value);
    }

}