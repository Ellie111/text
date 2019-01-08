package ad;

public class BinarySearch {
	public int binarySearch(int[] num,int x){
		int low = 0;
		int high = num.length - 1; 
		while(low <= high){ 
			//此时抛出ArrayIndexOutOfBoundsException 异常..
			int mid = low + (high - low)/2;  
			int midVal = num[mid];
			if(x > midVal){
				low = mid + 1;
			}else if (x < midVal){
				high = mid - 1;
			}else{
				return mid; 
			}
		}
		return -1; //没找到元素x
	}

}
