package com.jiekexueyuan.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.springframework.stereotype.Controller;

import com.jikexueyuan.dao.XmlOutputHelper;
import com.jikexueyuan.entity.Employee;

@Controller
public class XmlOutputControl {
	private XmlOutputHelper xmlOutputHelper;

	public XmlOutputHelper getXmlOutputHelper() {
		return xmlOutputHelper;
	}

	@Resource(name = "xmlFormate")
	public void setXmlOutputHelper(XmlOutputHelper xmlOutputHelper) {
		this.xmlOutputHelper = xmlOutputHelper;
	}

	public void execute(HttpServletRequest req, HttpServletResponse res)
			throws IOException {
		String xml = xmlOutputHelper.formate(new Employee());
		try {
			Document document = DocumentHelper.parseText(xml);
			document.setXMLEncoding("utf-8");
			PrintWriter out=res.getWriter();
			//调用业务层的方法,并获取XML输出
			out.print(document.asXML());
			//输出到浏览器
			out.flush();
			//关闭
			out.close();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
