package 二分查找;

public class Recursive_Binary_Search {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int target = 3;
        int left = 0;
        int right = arr.length - 1;
        System.out.println(binarySearch(arr, target, left, right));

    }

    public static int binarySearch(int[] arr, int target, int left, int right) {
        if( arr[left] > target || arr[right] < target || left > right ) {
            return -1;
        }
        int mid = left + ( right - left ) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearch(arr, target, left, right - 1);
        } else if (target > arr[mid]) {
            return binarySearch(arr, target, left + 1, right);
        }
        return -1;
    }
}
