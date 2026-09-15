class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();

        for( String s : strs){
            char[] chararray = s.toCharArray();
            Arrays.sort(chararray);

            String key = new String(chararray);
            map.putIfAbsent(key , new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
