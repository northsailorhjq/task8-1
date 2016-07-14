package com.jiekexueyuan.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import com.jikexueyuan.dao.JsonOutputHelpe;
import com.jikexueyuan.entity.Employee;
@Controller
public class JsonOutputControl {
private JsonOutputHelpe jHelpe;

public JsonOutputHelpe getjHelpe() {
	return jHelpe;
}
@Resource(name="jsonFormate")
public void setjHelpe(JsonOutputHelpe jHelpe) {
	this.jHelpe = jHelpe;
}
public void execute(HttpServletRequest req,HttpServletResponse res) throws IOException{
	//获取输出
	PrintWriter out=res.getWriter();
	//获取JSON并输出,传入Emp信息,正常业务中应该从持久层获取
	out.print(jHelpe.formate(new Employee()));
	//关闭
	out.close();
}
}