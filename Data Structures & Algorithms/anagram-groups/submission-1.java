//take string -> sort it -> save in map with array list -> iterate and return(please look at code again)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            char [] sort = s.toCharArray();
            Arrays.sort(sort);
            String key = new String(sort);

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
