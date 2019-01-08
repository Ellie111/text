package mima;
import java.util.Scanner;
public class Code {
//严羽卿 凯撒加密与解密  2015 10 23
 public static void main(String[] args) {
	 System.out.print("请输入密钥：");
		Scanner s = new Scanner(System.in);
		int key = s.nextInt() % 26; 
  // TODO Auto-generated method stub
  String input = null;
  System.out.println("请输入字母：");
   Scanner sc = new Scanner(System.in); 
   input = sc.next();
  StringBuffer code = new StringBuffer();
        Scanner sc1=new Scanner(System.in);
  System.out.println("加密请按1，解密请按2："); 
        int p;
        p=sc1.nextInt();      
        if(p==1)
        {
      System.out.println("加密之后为：");     
      for(int i = 0;i < input.length();i++)
      {
       char x = input.charAt(i);
       
       if(x >= 'a' && x <= 'w')
       {
        x = (char)(x+3);
        code.append(x);
       }
       if(x >= 'x' && x <= 'z')
       {
        x=(char)(x-23);
        code.append(x);
       }
       
       if(x >= 'A' && x <= 'W')
       {
        x = (char) (x+3);

        code.append(x);
       }
       if(x >= 'X' && x <= 'Z')
       {
        x=(char)(x-23);
        code.append(x);
       }

      } 
        }
        if(p==2)
        {
      System.out.println("解密：");
      for(int i = 0;i < input.length();i++)
      {
       char x = input.charAt(i);
       if(x >= 'a' && x <= 'c')
       {
        x=(char)(x+23);
        code.append(x);
       }
       else if(x >= 'd' && x <= 'z')
       {
        x = (char)(x-3);
        code.append(x);
       }
       else if(x >= 'A' && x <= 'C')
       {
        x=(char)(x+23);
        code.append(x);
       }
       
       else if(x >= 'D' && x <= 'Z')
       {
        x = (char) (x-3);

        code.append(x);
       }

      }
        }
  System.out.println(code);
 

 }

}