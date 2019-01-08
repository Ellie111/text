package Adapter;

public class Client {
	//客户端类
		public static void main(String[] args) {
			int[] array = { 41, 13, 5, 32, 34, 61, 8, 49, 18, 12, 52, 20};
			int i;
			System.out.print("排序前：");
			for (i=0; i<array.length; i++)
				System.out.print(array[i]+" ");
			BinarySearch binary = new BinarySearch();
			QuickSort sort = new QuickSort();
			AlgotithmAdapter kk = new AlgotithmAdapter(sort,binary);
	        System.out.println("\n通过二分查找得到数字5：位于数组的第"+(kk.search(array, 5)+1)+"位");  
			kk.sort(array, 0, array.length - 1);
			
			System.out.println("------------------------------");
			System.out.print("排序后：");
			for (i=0; i<array.length; i++)
				System.out.print(array[i]+" ");
			//int[] src = new int[] {1, 3, 5, 7, 8, 9};   
	        System.out.println("\n通过二分查找得到数字5：位于数组的第"+(kk.search(array, 5)+1)+"位");  
		}
	} 