package learn.DSA.LearnArrays;

public class LearnSystemarraycopy {
    
    /**
     * System.arraycopy() explanation:
     * System.arraycopy() is a built-in method in Java that allows you to copy elements from one array to another efficiently. It takes five parameters:
     * System.arraycopy(Object src, int srcPosition, Object dest, int destPosition, int length)
     * src: The source array from which elements are to be copied.
     * srcPosition: The starting position in the source array from which to begin copying.
     * dest: The destination array to which elements are to be copied.
     * destPosition: The starting position in the destination array where the copied elements will be placed.
     * length: The number of elements to be copied.
     */

    private Object[] resizeArray(Object[] arr, int length){
        if(length < arr.length) return arr;
        Object[] newArr = new Object[length];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        return newArr;
    }

    private Object[] mergeArray(Object[] arr1, Object[] arr2){
        int size = arr1.length + arr2.length;
        Object[] newArr = new Object[size];
        System.arraycopy(arr1, 0, newArr, 0, arr1.length);
        System.arraycopy(arr2, 0, newArr, arr1.length, arr2.length);
        return newArr;
    }

    private void printArray(Object[] arr){
        for(Object i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LearnSystemarraycopy learnSystemarraycopy = new LearnSystemarraycopy();

        System.out.println("--------------------------Resizing an array:---------------------------");

        Integer[] arr = {1, 2, 3, 4, 5};
        learnSystemarraycopy.printArray(arr);
        Object[] resizedArr = learnSystemarraycopy.resizeArray(arr, 10);
        learnSystemarraycopy.printArray(resizedArr);

        System.out.println("--------------------------Merging two arrays:---------------------------");

        Integer[] arr1 = {1, 2, 3, 4, 5};
        Integer[] arr2 = {6, 7, 8, 9};
        learnSystemarraycopy.printArray(learnSystemarraycopy.mergeArray(arr1, arr2));
    
    }
    
}
