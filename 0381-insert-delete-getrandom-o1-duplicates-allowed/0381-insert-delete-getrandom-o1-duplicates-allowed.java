// class RandomizedCollection {
    
//     HashMap<Integer,Integer> map;
    
//     public RandomizedCollection() {
//         map = new HashMap<>();
//     }
    
//     public boolean insert(int val) {
//         boolean res = true;
//         if(map.containsKey(val)) res= false;
//         map.put(val,map.getOrDefault(val,0)+1);
//         if(res==false) return false;
//         return true;
//     }
    
//     public boolean remove(int val) {
//         if(!map.containsKey(val)) return false;
//         if(map.get(val)>1){
//             map.put(val,map.get(val)-1);
//         }else map.remove(val);
//         return true;
//     }
    
//     public int getRandom() {
//         ArrayList<Integer> list = new ArrayList<>(map.keySet());
//         int r = (int)(Math.random()*list.size());
//         return list.get(r);
//     }
// }

// /**
//  * Your RandomizedCollection object will be instantiated and called as such:
//  * RandomizedCollection obj = new RandomizedCollection();
//  * boolean param_1 = obj.insert(val);
//  * boolean param_2 = obj.remove(val);
//  * int param_3 = obj.getRandom();
//  */
class RandomizedCollection {
    HashMap<Integer, Set<Integer>> map;
    List<Integer> list;
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        Set<Integer> indexes = map.get(val);
        // create indexes list if neccessary
        boolean flag = indexes == null || indexes.size() == 0;
        if(indexes == null){
            indexes = new HashSet<>();
            map.put(val, indexes);
        }
        // add new index of val to its indexes set
        indexes.add(list.size());
        // update list
        list.add(val);
        return flag;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        Set<Integer> indexes = map.get(val);
        if(indexes ==  null || indexes.size() == 0){
            // no such element
            return false;
        }else{
            // get one index of val
            int index = indexes.iterator().next();
            // remove it
            indexes.remove(index);
            // if index is already the last index, do nothing but delete it
            if(index != list.size() - 1){
                int last = list.get(list.size() - 1);
                Set<Integer> indexesOfLast = map.get(last);
                // replace val with last number
                list.set(index, last);
                // remove the last index
                indexesOfLast.remove(list.size() - 1);
                // add new index
                indexesOfLast.add(index);
            }
            // remove the last one
            list.remove(list.size() - 1);
            return true;
        }
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        // assume no call when collection is empty
        return list.get((int)(Math.random() * list.size()));
    }
}