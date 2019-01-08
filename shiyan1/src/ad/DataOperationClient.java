package ad;

public class DataOperationClient {
	public static void main(String a[])
	{
	//适配器 DataOperationAdapter
		DataOperation dataAdpter = new DataOperationAdpter();		
		int[] list={1,3,56,23,54,86,43,57,88,56,82,90};
		System.out.println("排序前的数据: ");
		for(int i=0;i<list.length;i++){
			System.out.print(list[i]+"  ");
		} 
		dataAdpter.sort(list);
		System.out.println("\n排序后的数据: ");
		for(int i=0;i<list.length;i++){
			System.out.print(list[i]+"    ");
		}
		int number = 56;
		int index = dataAdpter.search(list, number);	
		System.out.println("\n要查找的数据: "+number+ ", 所在下标:"+index);
}
}