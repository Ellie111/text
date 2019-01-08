package Bridge;

public class WindowVersion extends OperatingSystemVersion {  
    public void play(String fileName) {  
        String osType = "Windows播放";  
        this.vf.decode(osType,fileName);  
    } 
}
