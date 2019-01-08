package tools;
import java.io.IOException;
import javax.servlet.*;
/**
     * 设置编码字符集
     * @author LIN
     *
     */
public class ChangeEncodingFilter implements Filter
{
     private FilterConfig config;     //FilterConfig 可用于访问Filter配置信息
     @Override
     public void init(FilterConfig config) throws ServletException
     {
     this.config = config;
     }
     @Override
     public void destroy()
     {
     this.config = null;
     }
     @Override
     public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
          throws IOException, ServletException
     {
     // 获取该Filter的配置参数
     String encoding = config.getInitParameter("encoding");
     // 社设置request编码的字符集
     request.setCharacterEncoding(encoding);
     chain.doFilter(request, response);
     }
     
}