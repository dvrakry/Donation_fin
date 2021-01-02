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
			
			
			
		case "/add_m":
			logger.info("check1");
			int mno = Integer.parseInt(request.getParameter("mno"));
			logger.info("!!!!!!!!!!!!!mno" + mno);
			String writer_m = request.getParameter("writer");
			String comment_m = request.getParameter("comment");
			CommentVO cvo_m = new CommentVO(mno,writer_m,comment_m);
			int isOk_m = csv.add_m(cvo_m);
			PrintWriter out_m = response.getWriter();
			
			out_m.print(isOk_m);
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
			
		
		
		
		case "/list_m":
			logger.info("check2");
			int mno2 = Integer.parseInt(request.getParameter("mno"));
			logger.info("!!!!!!!!!!!!!!!!!>>>>>" + mno2);
			List<CommentVO>cList_m =csv.getList_m(mno2);
			JSONArray cmtArr_m = new JSONArray();
			for (int i = 0; i < cList_m.size(); i++) {
				JSONObject cmtObj = new JSONObject();
				cmtObj.put("cno", cList_m.get(i).getCno());
				cmtObj.put("mno", cList_m.get(i).getMno());
				cmtObj.put("writer", cList_m.get(i).getWriter());
				cmtObj.put("comment", cList_m.get(i).getComment());
				cmtObj.put("cregdate", cList_m.get(i).getCregdate());
				cmtArr_m.add(cmtObj);
			}
			logger.info("#$%#$%#$^#$^ cmtArr_m: " + cmtArr_m);
			String jsonCmtStringData_m = cmtArr_m.toJSONString();
			logger.info("#$%#$%#$^#$^ jsonCmtStringData_m: " + jsonCmtStringData_m);
			PrintWriter out2_m = response.getWriter();
			logger.info("#$%#$%#$^#$^ out2_m : " + out2_m);
			out2_m.print(jsonCmtStringData_m);
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
