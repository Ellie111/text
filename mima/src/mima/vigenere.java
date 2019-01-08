package mima;

import java.util.Scanner;

public class vigenere {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("输入明文，要求用小写字母，不要打空格");
		String s = input.nextLine();// 输入明文，要求用小写字母，不要打空格
		System.out.println("输入秘钥，要求用小写字母，不要打空格");
		String s2 = input.nextLine();// 输入秘钥，要求用小写字母，不要打空格
		String s3 = encrypt(s, s2);//使用加密算法，得到密文
		System.out.println(s3);
		String s4=deciphering(s3,s2);//使用解密算法，实现解密
		System.out.println(s4);
	}

	public static String encrypt(String s1, String s2) {
		char[] ch1 = s1.toCharArray();
		int length = ch1.length;// 明文长度
		int[] in1 = new int[length];
		for (int i = 0; i < ch1.length; i++) {
			in1[i] = ch1[i] - 97;// 利用ascii变成0-25数字
		}
		char[] ch2 = s2.toCharArray();
		int length2 = ch2.length;// 明文长度
		int[] in2 = new int[length2];
		for (int i = 0; i < ch2.length; i++) {
			in2[i] = ch2[i] - 97;// 利用ascii变成0-25数字
		}
		int j = 0;
		for (int i = 0; i < length; i++) {
			if (j == length2)
				j = 0;
			in1[i] = (in1[i] + in2[j]) % 26;//加密算法，mod26
			j++;
		}
		for (int i = 0; i < length; i++) {
			ch1[i] = (char) (in1[i] + 97);// 将数字变成字母
		}
		return String.valueOf(ch1);// 将字符串数字变成String类型的字符串，返回
	}

	public static String deciphering(String s1, String s2) {
		char[] ch1 = s1.toCharArray();
		int length = ch1.length;// 密文长度
		int[] in1 = new int[length];
		for (int i = 0; i < ch1.length; i++) {
			in1[i] = ch1[i] - 97;// 利用ascii变成0-25数字
		}
		char[] ch2 = s2.toCharArray();
		int length2 = ch2.length;// 明文长度
		int[] in2 = new int[length2];
		for (int i = 0; i < ch2.length; i++) {
			in2[i] = ch2[i] - 97;// 利用ascii变成0-25数字
		}
		int j = 0;
		for (int i = 0; i < length; i++) {
			if (j == length2)
				j = 0;
			in1[i] = (in1[i] - in2[j]) % 26;//解密算法，mod26
			if (in1[i] < 0)
				in1[i] += 26;//如果得到负数，则加上26转正
			j++;
		}
		for (int i = 0; i < length; i++) {
			ch1[i] = (char) (in1[i] + 97);// 将数字变成字母
		}
		return String.valueOf(ch1);// 将字符串数字变成String类型的字符串，返回
	}
}
