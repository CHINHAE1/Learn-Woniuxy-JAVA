/**
 * 这个类是：
 *
 * @author: CHINHAE
 * @date: 2024/6/11 11:15
 * @version: 1.0
 */
public class Demo1 {

  public static void main(String[] args){
    int[] nums = {2, 3, 1, 0, 2, 5};
    System.out.println(duplicate(nums));
  }
  public static int duplicate(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      while (nums[i] != i) {
        if (nums[i] == nums[nums[i]]) {
          return  nums[i];
        }
        swap(nums, i, nums[i]);
      }
      swap(nums, i, nums[i]);
    }
    return -1;
  }

  private static void swap(int[] nums, int i, int j) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
  }
}
