package ad;

class DataOperationAdpter implements DataOperation{
	QuickSort quickSort=new QuickSort();
	BinarySearch binarySearch =new BinarySearch();
	public int search(int[] list, int number) {
		return binarySearch.binarySearch(list, number);
	}

	public void sort(int[] list) {
		quickSort.quickSort(list); 
	}
	
}

