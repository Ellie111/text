package Adapter;

public class AlgotithmAdapter implements DataOperation{		//适配器类
	private QuickSort quick;
	private BinarySearch binary;
	
	public AlgotithmAdapter(QuickSort quick,BinarySearch binary) {
		this.quick = quick;
		this.binary = binary;
	}
	public void sort(int [] sort, int i, int j) {
		quick.quickSort(sort, i, j);
	}

	public int search(int search[], int n) {
		return binary.binarySearch(search, n);
	}
}