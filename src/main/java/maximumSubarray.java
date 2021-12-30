import static java.lang.Math.floor;

public class maximumSubarray {

    public static int[] findMaximumSubarray(int[] A, int low, int high){
        if (high == low)
            return  new int[] {low, high, A[low]};
        else{
            int mid = (int)floor((low+high)/2);
            int[] left = findMaximumSubarray(A, low, mid);
            int[] right = findMaximumSubarray(A, mid+1, high);
            int[] cross = findMaxCrossingSubarray(A, low, mid, high);

            if(left[2] >= right[2] && left[2] >= cross[2])
                return left;
            else if(right[2] >= left[2] && right[2] >= cross[2])
                return  right;
            else return cross;
        }
    }

    public static int[] findMaxCrossingSubarray(int[] A, int low, int mid, int high){

        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft=0;

        for (int i = mid; i>=low; i--){
            sum = sum + A[i];
            if(sum > leftSum){
                leftSum = sum;
                maxLeft = i;
            }
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        int maxRight=0;

        for (int i = mid+1; i<=high; i++){
            sum = sum + A[i];
            if(sum > rightSum){
                rightSum = sum;
                maxRight = i;
            }
        }

        return new int[] {maxLeft, maxRight, leftSum+rightSum};
    }
}
