package merge_two_sorted_arrays_without_extra_space;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        long[] a = {1, 4, 8, 10};
        long[] b = {2, 3, 9};
        long[] c = {1, 3, 5, 7};
        long[] d = {0, 2, 6, 8, 9};
//        BruteForce.mergeTwoSortedArraysWithoutExtraSpace(a, b);
//        Arrays.sort(a);
//        Arrays.sort(b);
//        BruteForce.printList(a);
//        BruteForce.printList(b);
//        BruteForce.mergeTwoSortedArraysWithoutExtraSpace(c, d);
//        Arrays.sort(c);
//        Arrays.sort(d);
//        BruteForce.printList(c);
//        BruteForce.printList(d);
        Optimal.mergeTwoSortedArraysWithoutExtraSpace(a, b);
        BruteForce.printList(a);
        BruteForce.printList(b);
    }
}

class BruteForce {
//    In the Brute Force Approach, first loop through first array, loop through second array,
//    if first array value is greater than the second array value, then replace them.
//    After sort both the arrays.
    public static void mergeTwoSortedArraysWithoutExtraSpace(long []a, long []b){
        for(int iterator = 0; iterator < a.length; iterator++) {
            for(int jterator = b.length - 1; jterator >= 0; jterator--) {
                if(b[jterator] < a[iterator]) {
                    long temp = a[iterator];
                    a[iterator] = b[jterator];
                    b[jterator] = temp;
                }
            }
        }
    }

    public static void printList(long []a) {
        for(long ele : a) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }
}

class Optimal {
//    This approach is based on shell sort
//    First find gap (len of a + len of b / 2 + 1 )
//    left = 0, right = 0
//    check left > right, if so replace

//    Time Complexity : O( m+n log(m+n))

    public static void mergeTwoSortedArraysWithoutExtraSpace(long []arr1, long []arr2){
        int n = arr1.length;
        int m = arr2.length;
        int len = n + m;

        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            int left = 0;
            int right = left + gap;
            while (right < len) {
                if (left < n && right >= n) {
                    swapIfGreater(arr1, arr2, left, right - n);
                }
                else if (left >= n) {
                    swapIfGreater(arr2, arr2, left - n, right - n);
                }
                else {
                    swapIfGreater(arr1, arr1, left, right);
                }
                left++; right++;
            }
            if (gap == 1) break;

            gap = (gap / 2) + (gap % 2);
        }
    }

    public static void swapIfGreater(long[] arr1, long[] arr2, int left, int right) {
        if (arr1[left] > arr2[right]) {
            long temp = arr1[left];
            arr1[left] = arr2[right];
            arr2[right] = temp;
        }
    }
}
