class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int [] result = new int[temperatures.length];
        int j=0;
        for(int i=0;i<temperatures.length; i++){
            while(!st.empty() && temperatures[i] > temperatures[st.peek()]){
                int temp = st.pop();
                 result[temp]= i - temp;
            }
            st.push(i);
        }
        return result;
    }
}
