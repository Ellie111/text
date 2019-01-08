package Bridge;

public class Test {
	public static void main(String[] args) {
	    // TODO Auto-generated method stub
	  VideoFile vf;  
	  OperatingSystemVersion osType1 = new WindowVersion();  
	  vf = new AVIFile();  
	  osType1.setVideo(vf);  
	  osType1.play("AVI");  
	      
	  OperatingSystemVersion osType2 = new LinuxVersion();  
	  vf = new RMVBFile();  
	  osType2.setVideo(vf);  
	  osType2.play("RMVB");  
	      
	  OperatingSystemVersion osType3 = new UnixVersion();  
	  vf = new MPEGFile();  
	  osType3.setVideo(vf);  
	  osType3.play("MPEG");
	  }
}
