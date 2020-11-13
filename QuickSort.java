public class QuickSort {
    public static void quickSort(int[] array) {
        quick(array,0,array.length - 1);
    }
    public static void quick(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }
        //当数据小于10时使用插入排序
        if(right - left + 1 < 10) {
            insertSort(array,left,right);
        }
        //三数取中法
        medianOfThree(array,left,right);

        int pivotIndex  = partition(array,left,right);
        quick(array,left,pivotIndex - 1);
        quick(array,pivotIndex + 1,right);
    }

    public static void medianOfThree(int[] array,int low,int high) {
        int mid = (low + high) / 2;
        if(array[mid] > array[high]) {
            swap(array,mid,high);
        }
        if(array[low] > array[high]) {
            swap(array,low,high);
        }
        if(array[low] < array[mid]) {
            swap(array,low,mid);
        }
    }

    //Hoare法
    public static int partition(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int pivot = array[left];
        while (i < j) {
            //一定要先从后往前找小于基准的值
            while(i < j && array[j] >= pivot) {
                j--;
            }
            while(i < j && array[i] <= pivot) {
                i++;
            }
            swap(array,i,j);
        }
        swap(array,i,left);
        return i;
    }
    //挖坑法
    private static int partition2(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int pivot = array[left];
        while (i < j) {
            //一定要先从后往前找小于基准的值
            while(i < j && array[j] >= pivot) {
                j--;
            }
            array[i] = array[j];
            while(i < j && array[i] <= pivot) {
                i++;
            }
            array[j] = array[i];
        }
        array[i] = pivot;
        return i;
    }
    //前后遍历法
    private static int partition3(int[] array, int left, int right) {
        int d = left + 1;
        int pivot = array[left];
        for(int i = left + 1;i <= right;i++) {
            if(array[i] < pivot) {
                swap(array,i,d);
                d++;
            }
        }
        swap(array,d,left);
        return d;
    }

    public static void swap(int[] array,int i,int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void insertSort(int[] arr,int low,int high) {
        for (int i = low +1; i <= high; i++) {
            int insert = arr[i];
            int insertIndex = i - 1;
            while(insertIndex >= 0 && insert < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insert;
        }
    }
}
