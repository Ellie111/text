package mima;

import java.util.Scanner;

public class fangshe {

	private static final int number = 26;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("请输入明文");
		String s = input.nextLine();// 输入明文，要求用小写字母，不要打空格
		System.out.println("请输入密钥k1");
		int a = input.nextInt();// 输入密钥k1
		if(gcd(a,26)!=1){System.out.println("密钥错误");}
		else{System.out.println("请输入密钥k2");
		int b = input.nextInt();// 输入密钥k2
		if(b>25||b<0){System.out.println("密钥错误");}
		else{
		String ch2 = encrypt(s, a, b);// 调用加密函数，得到密文
		System.out.println("密文为:"+ch2);
		// deciphering
		int a2 = Euclid(a, number);// 采用欧几里得算法计算a的逆。定义为a2；
		System.out.println("k1的逆=" + a2);
		String ch3 = deciphering(ch2, a2, b);// 调用解密算法，得到明文
		System.out.println("明文为：" + ch3);
		}}

	}
	public static int gcd(int a,int i){
		int j=0;
		do{
			j=a%i;
			a=i;
			i=j;
		}while(j!=0);
		return a;	
	}

	public static String encrypt(String s, int a, int b) {// 加密函数的实现
		char[] ch = s.toCharArray();
		int length = ch.length;// 明文长度
		int[] in = new int[length];
		for (int i = 0; i < ch.length; i++) {
			in[i] = ch[i] - 97;// 利用ascii变成0-25数字
		}
		for (int i = 0; i < length; i++) {
			in[i] = (in[i] * a + b) % 26;// 加密算法
		}
		for (int i = 0; i < ch.length; i++) {
			ch[i] = (char) (in[i] + 97);// 将数字变成字母
		}
		return String.valueOf(ch);// 将字符串数字变成String类型的字符串，返回

	}

	public static int Euclid(int a, int munber) {// 求k1 的逆的实现
		int a1 = 1, a2 = 0, a3 = number;
		int b1 = 0, b2 = 1, b3 = a;
		int t1, t2, t3;
		int q;
		q = a3 / b3;
		t1 = a1 - q * b1;
		t2 = a2 - q * b2;
		t3 = a3 - q * b3;
		while (t3 != 1) {
			a1 = b1;
			a2 = b2;
			a3 = b3;
			b1 = t1;
			b2 = t2;
			b3 = t3;
			q = a3 / b3;
			t1 = a1 - q * b1;
			t2 = a2 - q * b2;
			t3 = a3 - q * b3;
		}
		int a4 = t2 % munber;
		if (a4 < 0)
			a4 += munber;// 如果a4小于0，要加上26变正
		return a4;// 返回a的逆
	}

	public static String deciphering(String s, int a, int b) {// 解密的实现
		char[] ch = s.toCharArray();
		int length = ch.length;// 密文长度
		int[] in = new int[length];
		for (int i = 0; i < ch.length; i++) {
			in[i] = ch[i] - 97;// 利用ascii变成0-25数字
		}
		for (int i = 0; i < length; i++) {
			in[i] = ((in[i] - b) * a) % 26;// 解密算法
			if (in[i] < 0)
				in[i] += 26;
		}
		for (int i = 0; i < ch.length; i++) {
			ch[i] = (char) (in[i] + 97);// 将数字变成字母
		}
		return String.valueOf(ch);// 将字符串数字变成String类型的字符串，返回
	}

}