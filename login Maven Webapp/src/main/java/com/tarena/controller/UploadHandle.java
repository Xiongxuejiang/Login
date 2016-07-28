package com.tarena.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "upload")
public class UploadHandle {
	@RequestMapping(value="upload.do")
	public String upload(Model model,MultipartFile file1) throws Exception {
		if(file1!=null){
			//存储图片的物理路径
			String pic_pathString="F:\\picpath\\";
			//原始名称 
			String originalFileName=file1.getOriginalFilename();
			//新文件名
			String newFileName=UUID.randomUUID()+originalFileName.substring(originalFileName.lastIndexOf("."));
			//新文件
			File file = new File(pic_pathString+newFileName);
			//将内存数据写到磁盘
			file1.transferTo(file);
			
			model.addAttribute("picpath", newFileName);
			
		}
		return "message";
	}
}
