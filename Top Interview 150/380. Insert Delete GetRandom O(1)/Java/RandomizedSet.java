
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

    private ArrayList<Integer> vals;
    private Map<Integer, Integer> map;

    public RandomizedSet() {
        this.vals = new ArrayList<>();
        this.map = new HashMap<>();
    }

    public boolean contains(int val) {
        return map.containsKey(val);
    }
    
    public boolean insert(int val) {
        if(contains(val)) return false;

        vals.add(val);
        map.put(val, vals.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!contains(val)) return false;

        int index = map.get(val);
        vals.set(index, vals.get(vals.size()-1));
        map.put(vals.get(index), index);
        vals.remove(vals.size()-1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        Random rand = new Random();
        return vals.get(rand.nextInt(vals.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */ 