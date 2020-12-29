package com.donate.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.donate.domain.CommentVO;
import com.donate.domain.InsVO;
import com.donate.service.CommentService;
import com.donate.service.CommentServiceImp;
import com.donate.service.InsService;
import com.donate.service.InsServiceImp;


@WebServlet("/comment/*")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(CommentController.class);
    private CommentService csv;
    public CommentController() {
    	csv = new CommentServiceImp();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String uri = request.getRequestURI();
		String ctxPath = request.getContextPath(); //project name
		logger.info(">>ctxPath : "+ ctxPath); 
		String svlPath = request.getServletPath(); //@webServlet :/comment 
		logger.info(">>svlPath : "+ svlPath); 
		String mapping = uri.substring(ctxPath.length()+svlPath.length());
		
		switch (mapping) {
		case "/add":
			logger.info("check1");
			int ino = Integer.parseInt(request.getParameter("ino"));
			String writer = request.getParameter("writer");
			String comment = request.getParameter("comment");
			CommentVO cvo = new CommentVO(ino,writer,comment);
			int isOk = csv.add(cvo);
			PrintWriter out = response.getWriter();
			
			out.print(isOk);
			break;	
		case "/list":
			logger.info("check2");
			int ino2 = Integer.parseInt(request.getParameter("ino"));
			List<CommentVO>cList =csv.getList(ino2);
			JSONArray cmtArr = new JSONArray();
			for (int i = 0; i < cList.size(); i++) {
				JSONObject cmtObj = new JSONObject();
				cmtObj.put("cno", cList.get(i).getCno());
				cmtObj.put("ino", cList.get(i).getIno());
				cmtObj.put("writer", cList.get(i).getWriter());
				cmtObj.put("comment", cList.get(i).getComment());
				cmtObj.put("cregdate", cList.get(i).getCregdate());
				cmtArr.add(cmtObj);
			}
			String jsonCmtStringData = cmtArr.toJSONString();
			logger.info(">>>>jsonCmtStringData  "+jsonCmtStringData);
			PrintWriter out2 = response.getWriter();
			out2.print(jsonCmtStringData);
			break;

		case "/rm":
			int cno = Integer.parseInt(request.getParameter("cno"));
			int isRm =csv.remove(cno);
			PrintWriter out3 = response.getWriter();
			out3.print(isRm);
			break;

		default:
			break;
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}  
    


	
}
