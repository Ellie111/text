package Adapter;

public class BinarySearch {
	  public int binarySearch(int[] srcArray, int des){   
	      
	        int low = 0;   
	        int high = srcArray.length-1;   
	        while(low <= high) {   
	            int middle = (low + high)/2;   
	            if(des == srcArray[middle]) {   
	                return middle;   
	            }else if(des <srcArray[middle]) {   
	                high = middle - 1;   
	            }else {   
	                low = middle + 1;   
	            }  
	        }  
	        return -1;  
	   }  
	} 