/**
 * Created by xuwei on 2017/2/5.
 * 二分查找算法：比较次数少，查找速度快，算法高效
 * 【二分查找要求】：1.必须采用顺序存储结构 2.必须按关键字大小有序排列。
 */
public class BinSearchDemo {
    public static void main(String[] args) {
        int srcArray[] = {3,5,11,17,21,23,28,30,32,50,64,78,81,95,101};
        System.out.println(binSearch(srcArray, 81));
        System.out.println(binSearch(srcArray,0,srcArray.length -1,30));
    }

    /**
     * 二分查找普通查找方法
     * @param srcArray 查找的数组对象
     * @param key 查找的对象
     * @return 查找对象的下标
     */
    public static int binSearch(int srcArray[],int key) {
        int mid = srcArray.length/2;
        if(key == srcArray[mid]) {
            return mid;
        }
        int start = 0;
        int end = srcArray.length - 1;
        while(start <= end) {
            mid = (end - start)/2 + start;
            if(key > srcArray[mid]) {
                start = mid + 1;
            }else if(key < srcArray[mid]){
                end = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    /**
     *
     * @param srcArray 查找的数组对象
     * @param start 查找范围的开始下标
     * @param end 查找范围的结束下标
     * @param key 查找的对象
     * @return 查找对象的下标
     */
    public static int binSearch(int srcArray[], int start, int end, int key) {
        int mid = (end - start)/2 + start;
        if(key == srcArray[mid]) {
            return mid;
        }
        if(start > end) {
            return -1;
        }else if(key > srcArray[mid]) {
            return binSearch(srcArray,mid + 1, end, key);
        }else if(key < srcArray[mid]) {
            return binSearch(srcArray,start,end - 1,key);
        }
        return -1;
    }
}
