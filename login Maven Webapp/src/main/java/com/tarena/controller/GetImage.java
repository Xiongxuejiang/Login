package com.tarena.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/img")
public class GetImage {
	
	@RequestMapping(value="/getImageServlet.do")
	public void getImage(HttpServletRequest request, HttpServletResponse response){
		response.setContentType("image/gif");
		String path = request.getServletContext().getRealPath("/")+"\\images\\image.jpg";
		try {
			FileInputStream in = new FileInputStream(path);
			int size =in.available(); //得到文件大小   
	        byte data[]=new byte[size];   
	        in.read(data);  //读数据   
	        in.close();   
	        response.setContentType("image/gif"); //设置返回的文件类型   
	        OutputStream os = response.getOutputStream();  
	        os.write(data);  
	        os.flush();  
	        os.close();  
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
