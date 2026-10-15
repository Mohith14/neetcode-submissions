class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <=1){
            return intervals;
        }

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<>();

        list.add(intervals[0]);

        for(int i=1;i<intervals.length;i++){
            int[] prev = list.get(list.size()-1);

            int[] cur = intervals[i];

            if(prev[1]>=cur[0]){
                prev[1]= Math.max(prev[1],cur[1]);
            }else{
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[list.size()][]);

    }
}
