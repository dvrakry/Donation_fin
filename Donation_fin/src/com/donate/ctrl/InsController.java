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
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.donate.service.InsService;
import com.donate.service.InsServiceImp;
import com.donate.ctrl.InsController;
import com.donate.domain.InsVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.coobird.thumbnailator.Thumbnails;


@WebServlet("/ins")
public class InsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(InsController.class);
    private InsService isv;

    public InsController() {
        isv = new InsServiceImp();
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");
	    response.setContentType("text/html;charset=utf-8");
	    
	    String sv = request.getParameter("sv");
	    logger.info(">>> sv : " + sv);
	    String destPage = "";
	    MultipartRequest multi = null;
	    String realPath = null;
	    String savePath = null;
	    int maxSize = 0;
	    InsVO ivo;
	    ivo = new InsVO();
	    File dir;
	    String uploadPath;
	    LocalDateTime now;
        DateTimeFormatter form;
        String dateForm;        
        String fileName;
        String uploadFileName;
        String fileExt;
	    switch (sv) {
		case "reg":
			realPath = request.getServletContext().getRealPath("/");
			savePath = realPath + "upload";
			maxSize = 1024*1024;
			
			
			multi = new MultipartRequest(request, savePath, maxSize, "utf-8",new DefaultFileRenamePolicy());
			ivo = new InsVO();
			ivo.setIname(multi.getParameter("iname"));
			ivo.setLoc(multi.getParameter("loc"));
			ivo.setIpeople(Integer.parseInt(multi.getParameter("ipeople")));
			ivo.setIcnt(multi.getParameter("icnt"));
			ivo.setRepresent(multi.getParameter("represent"));
			uploadPath = multi.getFile("imgfile").getAbsolutePath();
			now = LocalDateTime.now();
            form = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            dateForm = now.format(form);            
            fileName = uploadPath.substring(uploadPath.lastIndexOf("\\")+1);
            uploadFileName = dateForm +"_"+fileName;
            logger.info(uploadFileName);
            ivo.setImgfile(fileName);
            //썸네일
            fileExt =fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
            switch (fileExt) {
			case "jpg": case "jpeg": case "png":
				Thumbnails.of(new File(uploadPath))
                .size(350, 210)
                .toFile(new File(savePath + "\\s_" + uploadFileName)); // 파일 경로?
              logger.info("check3");             
              break;
			
			default:
				break;
			}
            ivo.setThumb("s_"+uploadFileName);
            int isReg = isv.register(ivo);
            logger.info(">>> " + (isReg > 0 ? "시설등록 성공" : "시설등록 실패"));
            destPage = "ins?sv=list";
            			
			break;
			
		case "list":
			HttpSession session = request.getSession();
			session.removeAttribute("ses_ivo");
			ArrayList<InsVO> iList = (ArrayList<InsVO>) isv.getList();
			request.setAttribute("iList", iList);
			destPage = "index.jsp?rp=iList";
			break;
		case "detail":
			int ino = Integer.parseInt(request.getParameter("ino"));
			ivo = isv.getInfo(ino);
			HttpSession ses = request.getSession();
			ses.setAttribute("ses_ivo", ivo);
			destPage="index.jsp?rp=iDetail";
			break;
		case "update":
			int ino2 = Integer.parseInt(request.getParameter("ino"));
			ivo = isv.getInfo(ino2);
			request.setAttribute("ivo", ivo);
			destPage="index.jsp?rp=iUpdate";
			break;
		case "modify":
			realPath = request.getServletContext().getRealPath("/");
			savePath = realPath + "upload";
			maxSize = 1024*1024;
			
			
			multi = new MultipartRequest(request, savePath, maxSize, "utf-8",new DefaultFileRenamePolicy());
			ivo = new InsVO();
			ivo.setIno(Integer.parseInt(multi.getParameter("ino")));
			ivo.setIname(multi.getParameter("iname"));
			ivo.setLoc(multi.getParameter("loc"));
			ivo.setIpeople(Integer.parseInt(multi.getParameter("ipeople")));
			ivo.setIcnt(multi.getParameter("icnt"));
			
			uploadPath = multi.getFile("imgfile").getAbsolutePath();
			now = LocalDateTime.now();
            form = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
            dateForm = now.format(form);            
            fileName = uploadPath.substring(uploadPath.lastIndexOf("\\")+1);
            uploadFileName = dateForm +"_"+fileName;
            logger.info(uploadFileName);
            ivo.setImgfile(fileName);
            //썸네일
            fileExt =fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
            switch (fileExt) {
			case "jpg": case "jpeg": case "png":
				Thumbnails.of(new File(uploadPath))
                .size(350, 210)
                .toFile(new File(savePath + "\\s_" + uploadFileName)); // 파일 경로?
              logger.info("check3");             
              break;
			
			default:
				break;
			}
            ivo.setThumb("s_"+uploadFileName);
            int isReg2 = isv.modify(ivo);
            logger.info(">>> " + (isReg2 > 0 ? "시설수정 성공" : "시설수정 실패"));
            destPage = "ins?sv=list";
			break;
		case "remove":
			int ino3 = Integer.parseInt(request.getParameter("ino"));
			int isReg3 = isv.remove(ino3);
			logger.info(">>> " + (isReg3 > 0 ? "시설수정 성공" : "시설수정 실패"));
			destPage = "ins?sv=list";
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
