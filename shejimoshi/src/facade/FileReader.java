package facade;

public class FileReader {
	public String read(String fileNameSrc)
	{
		String fns=fileNameSrc;
		
		System.out.println("原文件:"+fns);
		
		return fns;
		
	}
}