public class RemoveDuplicatesFromSortedArray2 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length<2){
            return nums.length;
        }
        int k=0;
        int numOfInstances = 0;
        int lastInt = -101;
        int endIndex = nums.length;
        while (k!=endIndex){
            if (nums[k]!=lastInt){
                lastInt=nums[k];
                k++;
                numOfInstances=1;
            }
            else{
                if (numOfInstances==1){
                    numOfInstances++;
                    k++;
                }
                else {
                    for (int j = k; j < endIndex - 1; j++) {
                        nums[j] = nums[j + 1];
                    }
                    endIndex--;
                }
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k= removeDuplicates(nums);
    }
}
