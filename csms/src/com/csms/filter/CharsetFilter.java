package com.csms.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//ʵ��javax.servlet.Filter�ӿڼ�����Ϊһ����������
public class CharsetFilter implements Filter {

private String charset;//�ַ�����
private boolean enabled;//����

public void destroy() {
System.out.println("���ٱ��������");
}

public void doFilter(ServletRequest request, ServletResponse response,
FilterChain chain) throws IOException, ServletException {

if (enabled && charset != null) {//������ش� �� �ַ����벻��
            //���ñ���
request.setCharacterEncoding(charset);
response.setCharacterEncoding(charset);
}

      
chain.doFilter(request, response);
}

public void init(FilterConfig config) throws ServletException {

System.out.println("��ʼ�����������");
         //�������ļ���ȡ������charset
this.charset = config.getInitParameter("charset");
this.enabled = "true".equals(config.getInitParameter("enabled"));
System.out.println("�ַ����룺" + charset + "    �Ƿ����ã�" + enabled);
}

}
 
