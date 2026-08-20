class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <=1){
            return intervals;
        }
        //sort in ascedning order with the start_interval
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        for(int i =1; i<intervals.length;i++){
            int [] last_arr = merged.get(merged.size()-1);
            int[] curr_arr = intervals[i];

            if(curr_arr[0] <= last_arr[1]){
                last_arr[1] = Math.max(last_arr[1], curr_arr[1]);
            }else{
                merged.add(intervals[i]);
            }
        }
        return merged.toArray(new int [merged.size()][]);
    }
}
