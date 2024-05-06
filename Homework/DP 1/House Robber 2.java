class Solution {
    public int robbery(List<Integer>list){
        int n=list.size();
        if(n==1){
            return list.get(0);
        }
        int prev2=0;
        int prev=list.get(0);
        for(int i=1;i<n;i++){
            int take=list.get(i);
            if(i>1){
                take+=prev2;
            }
            int nottake=prev;
            int curr=Math.max(take,nottake);
            prev2=prev;
            prev=curr;

        }
        return prev;
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        List<Integer>list1=new ArrayList<>();
        List<Integer>list2=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i!=0){
                list1.add(nums[i]);
            }
            if(i!=n-1){
                list2.add(nums[i]);
            }
        }
        int robbery1=robbery(list1);
        int robbery2=robbery(list2);
        return Math.max(robbery1,robbery2);
    }
}
