//堆排序
//1、将数组变为大顶堆
//2、将堆顶元素与末尾元素交换
//3、调整结构为大顶堆（末尾元素不参与），继续执行第二步，直到整个数组有序
public class HeapSort{
    public static void heapSort(int[] arr) {
        //将数组变为大顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr,i,arr.length);
        }
        //将堆顶元素与末尾元素交换并调整为大顶堆，调整arr.length-1次
        for (int j = arr.length - 1; j > 0; j--) {
            int temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }
    }
    //i从最后一个非叶子节点开始
    public static void adjustHeap(int arr[],int i,int length) {
        int temp = arr[i];
        //非叶子节点的值被替换为左右孩子节点中较大并且大于非叶子节点的节点的值
        for(int k = i * 2 + 1;k <length;k = k * 2 + 1) {
            //k指向左右孩子较大的节点
            if(k + 1 < length && arr[k] < arr[k + 1]) {
                k++;
            }
            //左右孩子中较大的节点与父节点（非叶子节点）比较
            if(arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
        }
        //将左右孩子中较大的节点值替换为父节点（非叶子节点）的值
        arr[i] = temp;
    }
}
