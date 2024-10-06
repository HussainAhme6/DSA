
class MyArray{
    // Function to remove the element 
    public static int[] removeTheElement(int[] arr, int index)
    {

        // If the array is empty or the index is not in array range 
        // return the original array 
        if (arr == null || index < 0 || index >= arr.length) {

            return arr;
        }
        int i=0;
        //start form the index till end of array 
        for (i = index; i< arr.length-1; i++)
            arr[i]=arr[i+1];

        // for last index
        arr[i]=0;

        // return the resultant array 
        return arr;
    }
    // Returns index of x if it is present in arr[]. 
    public static int binarySearch(int arr[], int x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            // Check if x is present at mid 
            if (arr[m] == x)
                return m;

            // If x greater, ignore left half 
            if (arr[m] < x)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // If we reach here, then element was 
        // not present 
        return -1;
    }

} 