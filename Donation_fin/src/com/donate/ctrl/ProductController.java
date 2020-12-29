package com.donate.ctrl;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.donate.domain.Paging;
import com.donate.domain.ProductVO;
import com.donate.orm.FtpManager;
import com.donate.service.ProductService;
import com.donate.service.ProductServiceImp;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.coobird.thumbnailator.Thumbnails;

@WebServlet("/product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(ProductController.class);
    private ProductService psv;
    
	public ProductController() {
		psv = new ProductServiceImp();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String sv = request.getParameter("sv");
		logger.info(">>> sv : " + sv);
		String destPage = "";
		switch (sv) {
		case "reg":
			String realPath = request.getServletContext().getRealPath("/");
			String savePath = realPath + "upload";
			int maxSize = 1024*1024; 
			
			File dir = new File(savePath); 
			if(!dir.exists()) dir.mkdirs();
			
			
			MultipartRequest multi 
				= new MultipartRequest(request, savePath, maxSize, "utf-8",
						new DefaultFileRenamePolicy());
			ProductVO pvo = new ProductVO();
			pvo.setPname(multi.getParameter("pname"));
			pvo.setPrice(Integer.parseInt(multi.getParameter("price")));
			
			if(multi.getFile("imgfile") != null) {
				String uploadPath = multi.getFile("imgfile").getAbsolutePath(); 
				logger.info(">>>> uploadPath : " + uploadPath);
				
				LocalDateTime now = LocalDateTime.now();
				DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
				String dateForm = now.format(form);
				
				String fileName = uploadPath.substring(uploadPath.lastIndexOf("\\")+1);
				String uploadFileName = dateForm +"_"+fileName; 
				
				logger.info(">>> uploadFileName : " + uploadFileName);
				pvo.setImgfile(uploadFileName);
				
				
				String fileExt = fileName.substring(fileName.lastIndexOf(".")+1);

				switch (fileExt) {
				case "jpg": case "JPG": case "JPEG": case "jpeg": case "png": case "PNG": 
					
					Thumbnails.of(new File(uploadPath))
			        .size(270, 270)
			        .toFile(new File(savePath + "\\s_" + uploadFileName)); // 파일 경로?
					
				default:
					break;
				}
				pvo.setThumb("s_" + uploadFileName);
				
			}
			int isReg = psv.regist(pvo);
			logger.info(">>> " + (isReg > 0 ? "상품등록 성공" : "상품등록 실패"));
			destPage = "product?sv=list";
			
			break;
		case "list":
			int clPage = request.getParameter("cp") != null ? 
					Integer.parseInt(request.getParameter("cp")) : 1;
			int total = psv.totalCount();
			Paging paging = new Paging(clPage, total);
			ArrayList<ProductVO> pList = (ArrayList<ProductVO>) psv.getList(paging);
			request.setAttribute("pList", pList);
			request.setAttribute("paging", paging);
			destPage = "index.jsp?rp=pli";
			break;
		case "mod":
			int pno2 = Integer.parseInt(request.getParameter("pno"));
			logger.info("pno2 >>>" + pno2);
	    	  ProductVO pvo3 = psv.getInfo(pno2);
	    	  request.setAttribute("pvo", pvo3);
	    	  destPage = "index.jsp?rp=pmod";
			break;
		case "upd":
			realPath = request.getServletContext().getRealPath("/");
	          savePath = realPath + "upload";
	          maxSize = 1024*1024; 
	          
	    	  multi 
	          = new MultipartRequest(request, savePath, maxSize, "utf-8",
	                new DefaultFileRenamePolicy());
	    	  ProductVO pvo4 = new ProductVO();
	    	  pvo4.setPno(Integer.parseInt(multi.getParameter("pno")));
	    	  logger.info("check1");
	    	  
	    	  pvo4.setPname(multi.getParameter("pname"));
	    	  logger.info("check3");
	    	  pvo4.setPrice(Integer.parseInt(multi.getParameter("price")));
	    	  logger.info("check4");
	    	  if(multi.getFile("imgfile") != null) {
					String uploadPath = multi.getFile("imgfile").getAbsolutePath(); 
					logger.info(">>>> uploadPath : " + uploadPath);
					
					LocalDateTime now = LocalDateTime.now();
					DateTimeFormatter form = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
					String dateForm = now.format(form);
					
					String fileName = uploadPath.substring(uploadPath.lastIndexOf("\\")+1);
					String uploadFileName = dateForm +"_"+fileName; 
					
					logger.info(">>> uploadFileName : " + uploadFileName);
					pvo4.setImgfile(uploadFileName);
					
					
					String fileExt = fileName.substring(fileName.lastIndexOf(".")+1);
					logger.info("fileExt >>>>>" + fileExt);
					switch (fileExt) {
					case "jpg": case "JPG": case "JPEG": case "jpeg": case "png": case "PNG": 
						
						// 썸네일 로직
						Thumbnails.of(new File(uploadPath))
				        .size(270, 270)
				        .toFile(new File(savePath + "\\s_" + uploadFileName)); 
						logger.info("썸네일 로직 돌았습니다");
					default:
						break;
					}
					pvo4.setThumb("s_" + uploadFileName);
					logger.info("썸네일 로직 돌았습니다22222");
				}
	    	  
	    	  int isUp = psv.modify(pvo4);
	          logger.info(">>> " + (isUp > 0 ? "상품수정 성공" : "상품수정 실패"));
	    	  request.setAttribute("pvo", pvo4);
	    	  destPage = "product?sv=list";
			break;
		case "rm":
			 int pno3 = Integer.parseInt(request.getParameter("pno"));
	    	  int isRm = psv.remove(pno3);
	    	  logger.info(">>>> "+(isRm>0 ? "삭제 성공" : "삭제 실패"));
	    	  destPage = "product?sv=list";
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
