package mima;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Mainer {
	
	StringBuffer MStr = new StringBuffer("");	// 加密字符串
	StringBuffer CStr = new StringBuffer("");	// 解密字符串
	
	public static void main(String[] args) {
	
		System.out.print("请输入密钥：");
		Scanner s = new Scanner(System.in);
		int key = s.nextInt() % 26; // %26的意义是获取密钥的偏移值
		Mainer ks = new Mainer();
		ks.E(key);	// 加密
		ks.D(key);	// 解密
	}

	/**
	 * 加密 公式
	 */
	 void E(int k) {
		try {
			System.out.println("请输入一段明文：");
			char b[];
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
			String str2 = br2.readLine();
			b = str2.toCharArray();
			char ch = ' ';
			for (int i = 0; i < str2.length(); i++) {
				if (b[i] >= 'a' && b[i] <= 'z') {
					ch = (char) ((b[i] - 'a' + k) % 26 + 'a');
				}
				if(b[i] >= 'A' && b[i] <= 'Z'){
					ch = (char) ((b[i] - 'A' + k) % 26 + 'A');
				}
				if(b[i]>='0'&&b[i]<='9')
				{
				if(b[i]+k%10<='9')
				{
					ch=(char)(b[i]+k%10);//当提取的字符在9之前的n位时
				}
				else
				{ch=(char)('0'+((b[i]-('9'-k)-1)%10));//孤立出来的n个字符
				}}
				MStr.append(ch);	// 拼接字符串
			}
			System.out.println("密文为："+MStr+"   密匙为：" + k);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * 解密 公式
	 */
	void D(int k) {
		try {
			char b[];
			b = MStr.toString().toCharArray();
			char ch =' ';
			for (int i = 0; i < MStr.length(); i++) {
				if (b[i] >= 'a' && b[i] <= 'z') {
					ch = (char) ((b[i] - 'a' + 26 - k) % 26 + 'a');
				}
				if(b[i] >= 'A' && b[i] <= 'Z'){
					ch = (char) ((b[i] - 'A' + 26 - k) % 26 + 'A');
				}
				if(b[i]>='0'&&b[i]<='9'){
				if(b[i]-k%10>='0')//当提取的字符在0之前的n个时
				{  ch=(char)(b[i]-k%10);}
				else{
				ch=(char)('9'-((b[i]-(k-'0')-1)%10));//操作孤立出来的n个字符
				}}
				 
				CStr.append(ch);	// 拼接字符串
			}
			System.out.println("明文："+CStr);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
