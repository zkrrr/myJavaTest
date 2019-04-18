package leetcode;

/*
给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5

 */

public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a_len=nums1.length;
        int b_len=nums2.length;
        int total=a_len+b_len;
        if (total%2!=0){
            return findKth(nums1,a_len,nums2,b_len,total/2+1);
        }
        else {
            return (findKth(nums1,a_len,nums2,b_len,total/2)+findKth(nums1,
                    a_len,nums2,b_len,total/2+1))/2;
        }
    }

    public double findKth(int[] a,int a_len, int [] b,int b_len,int k){
        if (a_len > b_len)
            return findKth(b, b_len, a, a_len, k);
        if (a_len == 0)
            return b[k - 1];
        if (k == 1)
            return Math.min(a[0], b[0]);
        int a_flag = Math.min(k / 2, a_len);
        int b_flag = k - a_flag;
        if (a[a_flag - 1] < b[b_flag - 1])
            return findKth(trim(a,a_flag,a_len), a_len - a_flag, b, b_len, k -
                    a_flag);
        else if (a[a_flag - 1] > b[b_flag - 1])
            return findKth(a, a_len, trim(b,b_flag,b_len), b_len - b_flag,
                    k - b_flag);
        else
            return a[a_flag - 1];
    }

    private static int[] trim(int [] a,int start,int end){
        int res[]=new int[end-start];
        int index=0;
        for (int i=start;i<end;i++){
            res[index++]=a[i];
        }

        return res;
    }


    public static void main(String[] args) {
        int a[]={1,2};

        int b[]={2};
        System.out.println(new FindMedianSortedArrays().findMedianSortedArrays(a,b));
    }

}
