package com.jikexueyuan.dao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Repository;
@Repository("xmlFormate")
public class XmlOutputHelper implements IOutputHelper {
	@Override
	public String formate(Object object) {
		// 创建doc
		Document doc = DocumentHelper.createDocument();
		// 获取Class对象
		Class<? extends Object> clazz = object.getClass();
		// 创建根节点(java.lang.Class.getSimpleName() 返回在源代码中给出底层类的简单名称。)
		Element rootElement = doc.addElement(clazz.getSimpleName());
		// 获取该类中所有的属性
		Field[] fields = clazz.getDeclaredFields();
		String xml = "";
		// 遍历所有的属性
		for (Field field : fields) {
			// 获取属性名
			String name = field.getName();
			String getMethodName = "get"
					+ String.valueOf(name.charAt(0)).toUpperCase()
					+ name.substring(1);
			// 调用get方法
			try {
				Method getMethod = clazz.getMethod(getMethodName);
				Object val = getMethod.invoke(object);
				if (val == null) {
					val = "";
				}
				// 将属性和值追加到节点下
				rootElement.addElement(name).addText(val.toString());
				xml=doc.asXML();
			} catch (NoSuchMethodException | SecurityException
					| IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return xml;

	}
}
