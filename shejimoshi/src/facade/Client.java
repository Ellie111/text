package facade;

public class Client {
	public static void main(String[] args) {
		try
		{
			String text="xyc";
			String address="D:\\设计模式";
			
			
				EncryptFacade ec=new EncryptFacade();
				ec.fileEncrypt(text,address);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}