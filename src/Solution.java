import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /*
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */

    static public void main(String [] args){
        Solution s = new Solution();
        int [] nums = {1,2,2};
        System.out.println(s.subsetsWithDup(nums));
    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null){
            return result;
        }
        if (nums.length ==0){
            result.add(subset);
            return result;
        }
        helper(nums,0,subset,result);
        return result;
    }


    private void helper(int[] nums, int startIndex, List<Integer> subset ,List<List<Integer>> result){

        result.add(new ArrayList<>(subset));
        for(int i = startIndex ; i < nums.length; i++){

            if(i!=0 && nums[i] == nums[i-1] && i != startIndex){
                continue;
            }
            subset.add(nums[i]);
            helper(nums,i + 1, subset,result);
            subset.remove(subset.size()-1);
        }
    }
}