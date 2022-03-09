import java.util.ArrayList;
import java.util.LinkedList;

public class ObjectHashMap extends AbstractHashMap{

    private ArrayList<LinkedList<Entry>> entries;

    /**
     * constructor for the ObjectHashMap
     * @param maxLoad max number before resizing
     */
    public ObjectHashMap(double maxLoad) {
        super(maxLoad);
        entries = new ArrayList<LinkedList<Entry>>();
        for (int i = 0; i < capacity; i++){
            entries.add(new LinkedList<Entry>());
        }
    }

    public ObjectHashMap(){
        super(0.9);
        entries = new ArrayList<LinkedList<Entry>>();
        for (int i = 0; i < capacity; i++){
            entries.add(new LinkedList<Entry>());
        }
    }

    /**
     * function that adds new Entry to ArrayList or change the value connected to the given key
     * @param key given key
     * @param value given value
     * The time complexity for the function is O(n)
     */
    @Override
    public void put(Object key, Object value) {
        if (!containsKey(key)){
            if ((double)(numKeys/capacity) >= maxLoad){
                resize();
            }
            Entry word = new Entry(key, value);
            entries.get(hash(key)).add(word);
            numKeys++;
        } else {
            getEntry(key).value = value;
        }
    }

     /**
      * function that returns the Entry
      * @param key given key to try to find the Entry of
      * @return the Entry that contains the key
      * the time complexity for the function is O(n)
      */
     @Override
    public Entry getEntry(Object key){
        int idx = hash(key);
        for (int i = 0; i < entries.get(idx).size(); i++){
            if (entries.get(idx).get(i).key.equals(key)){
                return entries.get(idx).get(i);
            }
        }
        return null;
    }

    /**
     * function that finds the value of given key
     * @param key given key that will be used to find the value of
     * @return the value associated with the given key
     * time complexity for the function is O(n)
     */
    @Override
    public Object find(Object key) {
        if (containsKey(key)){
            return getEntry(key).value;
        }
        return null;
    }

    /**
     * function that resizes or make the hashtable larger
     * time complexity for the function is O(n^2)
     */
    @Override
    protected void resize() {
        capacity = capacity * 2;
        ArrayList<LinkedList<Entry>> temp = new ArrayList<LinkedList<Entry>>();
        for (int i = 0; i < capacity; i++){
            temp.add(new LinkedList<Entry>());
        }
        for (int i =0; i < entries.size(); i++){
            for (int j = 0; j < entries.get(i).size(); j++){
                int idx = hash(entries.get(i).get(j).key);
                temp.get(idx).add(entries.get(i).get(j));
            }
        }
        entries = temp;
    }

    /**
     * function that determines whether a key is in hashtable
     * @param key given key that will be tried to locate 
     * @return true if key is in hashtable false otherwise
     * time complexity for the function is O(n)
     */
    @Override
    public boolean containsKey(Object key) {
        if (getEntry(key) != null){
                return true;
            }
        return false;
    }

     /**
      * function that changes the hashtable into array of Entry
      * @return the array of Entry from hashtable
      * time complexity for the function is O(n^2)
      */
     @Override
    public Entry[] getEntries() {
        ArrayList<Entry> arListEntry = new ArrayList<Entry>(numKeys);
        for (int i =0; i < entries.size(); i++){
            for (int j =0; j < entries.get(i).size(); j++){
                if (entries.get(i).size() != 0){
                    arListEntry.add(entries.get(i).get(j));
                }
            }
        }
        Entry[] arr = new Entry[arListEntry.size()];
        arr = arListEntry.toArray(arr);
        return arr;
    }
}
