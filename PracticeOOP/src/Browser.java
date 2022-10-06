
public class Browser{

	    public int[] twoSum(int[] nums, int target) {
	        int[] result = new int[nums.length];
	        for (int i=0;i<nums.length;i++){
	            if (nums[i]+nums[i+1] == target){
	                result(nums[i]);
	                result.push(nums[i+1]);
	            }
	        }
	        return result;
	    }
	}