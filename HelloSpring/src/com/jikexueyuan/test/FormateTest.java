package com.jikexueyuan.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jikexueyuan.dao.IOutputHelper;
import com.jikexueyuan.dao.JsonOutputHelpe;
import com.jikexueyuan.dao.XmlOutputHelper;
import com.jikexueyuan.entity.Employee;

public class FormateTest {
	/**
	 * 格式化为xml格式。
	 * @param args
	 */

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		String conf = "applicationContext.xml";
		//获取Spring容器,容器会调用注解扫描组件
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		//获取容器中的Emp员工信息。
		Employee emp = ac.getBean("emp", Employee.class);
		//格式化为XML格式。
		IOutputHelper toXML = ac.getBean("xmlFormate", XmlOutputHelper.class);
		System.out.println("------格式化为XML格式-----");
		System.out.println(toXML.formate(emp));
		//格式化为JSON格式。
		IOutputHelper toJson = ac.getBean("jsonFormate", JsonOutputHelpe.class);
		System.out.println("------格式化为JSON格式-----");
		System.out.println(toJson.formate(emp));
	}

}
