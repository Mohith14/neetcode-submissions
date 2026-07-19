class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        HashMap<Character, Integer> need = new HashMap<>();
        for(int i = 0; i<t.length(); i++){
            need.put(t.charAt(i),(need.getOrDefault(t.charAt(i),0)+1));
        }
        HashMap<Character , Integer> window = new HashMap<>();
        int l =0;
        int have =0;
        int resetval=0;
        int size = Integer.MAX_VALUE;
        for(int r=0; r < s.length(); r++){
            char c= s.charAt(r);
            window.put(c,(window.getOrDefault(c,0)+1));
            if(need.containsKey(c)&& need.get(c).intValue() == window.get(c).intValue()){
                have++;
            }
            while(have == need.size()){
                if(r - l + 1 < size ){
                    size = Math.min((r-l+1),size);
                    resetval =l;
                }
                char lmc = s.charAt(l);
                window.put(lmc , window.get(lmc) -1);
                if(need.containsKey(lmc) && need.get(lmc).intValue() > window.get(lmc).intValue()){
                    have--;
                }
                l++;
            }
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(resetval, resetval + size);
    }
}
