package ad;

public class QuickSort {
	public int[] quickSort(int[] num){
		return sort(num,0,num.length-1);
	} 
	private int[] sort(int[] num,int left,int right){
		if(left < right){
			//将第一个数作为参照轴
			int s = num[left];
			int i = left;
			int j = right+1;
			while(true){
				//从左向右找，直到找到比S大的数
				while(i+1<num.length && num[++i]<s);
				//从右向左找，直到找到比S小的数
				while(j-1>-1 && num[--j]>s);
				//此时如果i>=j，则说明已交叉，跳出该永久循环
				if(i >= j){
					break;
				}
				//否则如果i<=j，则交换下标为i和下标为j的两元素的值
				swap(num,i,j);
			}
			//把比S小的数放到下标为left处
			num[left] = num[j];
			//最后将轴S置于比它小和比它大的两组数之间
			num[j] = s;
			//对S的左右两侧分别再次使用快速排序
			sort(num,left,j-1);
			sort(num,j+1,right);
		}
		return num;
	}
		private void swap(int[] num,int i,int j){
			int t;
			t = num[i];
			num[i] = num[j];
			num[j] = t;
		} 

		
	}
