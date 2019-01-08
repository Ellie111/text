package proxy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogProxy implements Log{
		  private LogRecord logRecord=new LogRecord();
		  private SimpleDateFormat SDF=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		  private String time=SDF.format(new Date());
		  public void method() {
		    System.out.println("方法method被调用！调用时间为："+time);
		    try{
		    logRecord.method();    
		    System.out.println("方法method()调用成功！");
		    }catch(Exception e){
		    System.out.println("方法method()调用失败！");
		    }
		    
		    }
		}