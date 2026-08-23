class TimeMap {

    private HashMap<String, List<pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key , new ArrayList<>());
        map.get(key).add(new pair(value,timestamp));
        
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        List<pair> search = map.get(key);

        int l =0;
        int h = search.size() -1;

        String result ="";

        while(l<=h){
            int mid = l+(h-l)/2;

            if(search.get(mid).timestamp <= timestamp){
                result = search.get(mid).value;
                l = mid + 1;
            }else{
                h = mid -1;
            }
        }
    return result;
    }
    private class pair{
        String value;
        int timestamp;

        pair(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}
