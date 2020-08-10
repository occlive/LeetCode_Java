package easy;

import java.util.Arrays;

class Demo1 {
	
	public static void main(String args[]) {
		int[] arr = {2, 7, 11, 15};
		int[] answer = new int[2];
		answer = twoSum(arr,9);
		
		System.out.print(Arrays.toString(answer));
		
		
		
	}
	
	
	public static int[] twoSum(int[] nums, int target) {
        int ans[] = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(nums[i]+nums[j]==target && i != j){
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
        
    }
}
