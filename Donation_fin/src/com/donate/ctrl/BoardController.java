package com.donate.ctrl;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.donate.domain.BoardVO;
import com.donate.domain.Paging;
import com.donate.service.BoardService;
import com.donate.service.BoardServiceImp;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.coobird.thumbnailator.Thumbnails;


@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(BoardController.class);  
	private BoardService bsv;
    
    public BoardController() {
    	bsv = new BoardServiceImp();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String sv = request.getParameter("sv");
		String destPage = "";
		
		switch (sv) {
		case "reg":
			String realPath = request.getServletContext().getRealPath("/");
				logger.info("realPath: " + realPath);
			String savePath = realPath + "upload";
				logger.info("SavePath: " +savePath);
			int maxSize = 1024*1024;
			File dir = new File(savePath);
			if(!dir.exists()) dir.mkdirs();
			
			MultipartRequest multi
			= new MultipartRequest(request, savePath, maxSize, "utf-8", new DefaultFileRenamePolicy());
			
			BoardVO bvo = new BoardVO();
			bvo.setBid(multi.getParameter("mid"));
			bvo.setIname(multi.getParameter("mins"));
			bvo.setBperson(multi.getParameter("bperson"));
			bvo.setBcontent(multi.getParameter("bcontent"));
			
			if(multi.getFile("imgfile") != null) {
				String uploadPath = multi.getFile("imgfile").getAbsolutePath();
					logger.info(">>>> uploadPath: " + uploadPath);
				
				LocalDateTime now = LocalDateTime.now();
        		DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        		String dateForm = now.format(form);
        			logger.info(dateForm);	
        		
    			String fileName = uploadPath.substring(uploadPath.lastIndexOf("\\")+1);
    				logger.info(">>>> FileName: " + fileName);
				String uploadFileName = dateForm + "_" + fileName;
					logger.info(">>>> uploadFileName: " + uploadFileName);
					
				bvo.setImgfile(uploadFileName);
				
				String fileExt = fileName.substring(fileName.lastIndexOf(".")+1);
				switch (fileExt) {
				case "jpg": case "JPG": case "JPEG": case "jpeg": case "png": case "PNG": 
					
					Thumbnails.of(new File(uploadPath))
	                 .size(270, 270)
	                 .toFile(new File(savePath + "\\s_" + uploadFileName));
					break;

				default:
					break;
				}
				bvo.setThumb("s_" + uploadFileName);	
			}
			 
				 int isReg = bsv.regist(bvo);
				 	logger.info(">>> " + (isReg > 0 ? "상품등록 성공" : "상품등록 실패"));
		         destPage = "board?sv=list";
		         break;
	         
		case "list":
	         int clPage = request.getParameter("cp") != null ? 
	               Integer.parseInt(request.getParameter("cp")) : 1;
	         int total = bsv.totalCount();
	         Paging paging = new Paging(clPage, total);
	         ArrayList<BoardVO> bList = (ArrayList<BoardVO>) bsv.getList(paging);
	         request.setAttribute("bList", bList);
	         request.setAttribute("paging", paging);
	         destPage = "index.jsp?rp=board";
	         break;
	         
		case "info"://디테일
			int bno = Integer.parseInt(request.getParameter("bno"));
			BoardVO bvo2 =  bsv.getInfo(bno);
			request.setAttribute("bvo", bvo2);
			destPage = "index.jsp?rp=bInfo";
			break;
		
		case "mod"://수정하기페이지
			int bno3 = Integer.parseInt(request.getParameter("bno"));
			BoardVO bvo3 = bsv.getInfo(bno3);
			request.setAttribute("bvo", bvo3);
			destPage = "index.jsp?rp=bMod";
			break;
		
		case "update":
		String realPath1 = request.getServletContext().getRealPath("/");
		    logger.info("realPath: " + realPath1);
		String savePath1 = realPath1 + "upload";
			logger.info("SavePath: " +savePath1);
		int maxSize1 = 1024*1024;
		File dir1 = new File(savePath1);
		if(!dir1.exists()) dir1.mkdirs();
		
		MultipartRequest multi1
		= new MultipartRequest(request, savePath1, maxSize1, "utf-8", new DefaultFileRenamePolicy());
		
		BoardVO bvo1 = new BoardVO();
		bvo1.setBno(Integer.parseInt(multi1.getParameter("bno")));
		bvo1.setBid(multi1.getParameter("mid"));
		bvo1.setIname(multi1.getParameter("mins"));
		bvo1.setBperson(multi1.getParameter("bperson"));
		bvo1.setBcontent(multi1.getParameter("bcontent"));
		
		
		if(multi1.getFile("imgfile2") != null) {
			String uploadPath = multi1.getFile("imgfile2").getAbsolutePath();
				logger.info(">>>> uploadPath: " + uploadPath);
			
			LocalDateTime now = LocalDateTime.now();
    		DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    		String dateForm = now.format(form);
    			logger.info(dateForm);	
    		
			String fileName = uploadPath.substring(uploadPath.lastIndexOf("\\")+1);
				logger.info(">>>> FileName: " + fileName);
			String uploadFileName = dateForm + "_" + fileName;
				logger.info(">>>> uploadFileName: " + uploadFileName);
				
			bvo1.setImgfile(uploadFileName);
			
			String fileExt1 = fileName.substring(fileName.lastIndexOf(".")+1);
			switch (fileExt1) {
			case "jpg": case "JPG": case "JPEG": case "jpeg": case "png": case "PNG": 
				
				Thumbnails.of(new File(uploadPath))
                 .size(270, 270)
                 .toFile(new File(savePath1 + "\\s_" + uploadFileName));
				break;

			default:
				break;
			}
			bvo1.setThumb("s_" + uploadFileName);	
		}
		else {
			bvo1.setImgfile(multi1.getParameter("imgfile"));
			bvo1.setThumb(multi1.getParameter("thumb"));
		}
			 int isReg1 = bsv.modify(bvo1);
			 	logger.info(">>> " + (isReg1 > 0 ? "게시판 수정 성공" : "게시판 수정 실패"));
	         destPage = "board?sv=list";
	         break;
	         
		case "delete":
			int bno4 = Integer.parseInt(request.getParameter("bno"));
			logger.info("bno44444444444444: " + bno4);
			int deleteOk = bsv.remove(bno4);
			logger.info(">>> ProductController > delete : " + (deleteOk > 0 ? "삭제성공":"삭제실패"));
			destPage = "board?sv=list";
			break;
	
		
		default:
			break;
		}
		 if(destPage != "") {
	            RequestDispatcher rdp = request.getRequestDispatcher(destPage);
	            rdp.forward(request, response);
		 }
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

}
