//need to return the to  k most frequent elelments in arrray 
// we store in map and sort it 

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }

        List<Integer> keys = new ArrayList<>(map.keySet());

        keys.sort((a,b) -> map.get(b) - map.get(a));
        int[] result = new int[k];
        for( int i =0; i< k; i++){
            result[i] = keys.get(i);
        }
        return result;
    }
}
