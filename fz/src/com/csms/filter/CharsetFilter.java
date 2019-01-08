package com.csms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//实现javax.servlet.Filter接口即可作为一个过滤器了
public class CharsetFilter implements Filter {

private String charset;//字符编码
private boolean enabled;//开关

public void destroy() {
System.out.println("销毁编码过滤器");
}

public void doFilter(ServletRequest request, ServletResponse response,
FilterChain chain) throws IOException, ServletException {

if (enabled && charset != null) {//如果开关打开 且 字符编码不空
            //设置编码
request.setCharacterEncoding(charset);
response.setCharacterEncoding(charset);
}

      
chain.doFilter(request, response);
}

public void init(FilterConfig config) throws ServletException {

System.out.println("初始化编码过滤器");
         //从配置文件获取参数：charset
this.charset = config.getInitParameter("charset");
this.enabled = "true".equals(config.getInitParameter("enabled"));
System.out.println("字符编码：" + charset + "    是否启用：" + enabled);
}

}
 
