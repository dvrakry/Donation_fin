package com.donate.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.donate.domain.MemberVO;
import com.donate.service.MemberService;
import com.donate.service.MemberServiceImp;



@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(MemberController.class);  
	private MemberService msv;
   
    public MemberController() {
    	msv = new MemberServiceImp();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String sv = request.getParameter("sv");
		String destPage = "";
		
		switch (sv) {
		case "join":
			String mname = request.getParameter("mname");
			String mid = request.getParameter("mid");
			String mpwd = request.getParameter("mpwd");
			String mphone = request.getParameter("mphone");
			String mins = request.getParameter("mins");
			
			MemberVO mvo = new MemberVO(mname, mid, mpwd, mphone, mins);
			int isJoin = msv.join(mvo);
			 logger.info(">>> MemberController > join : " + (isJoin > 0 ? "가입성공":"가입실패"));
		    destPage = "index.jsp";
			break;
		
		case "login":
			String mid2 = request.getParameter("mid");
			String mpwd2 = request.getParameter("mpwd");
			MemberVO mvo2 = new MemberVO(mid2, mpwd2); 
			mvo2 = msv.login(mvo2);
			logger.info(">>>>>>>>>>>>><<<<<<<<<<<" + mvo2);
			HttpSession ses = request.getSession();
			ses.setAttribute("ses_mvo", mvo2);
			destPage = "index.jsp";
			break;
		case "logout":
			HttpSession session = request.getSession();
			session.invalidate();
			destPage="index.jsp";
			break;
		case "list":
			ArrayList<MemberVO> mList = new ArrayList<MemberVO>();
			mList = msv.getList();
			request.setAttribute("mList", mList);
			destPage = "index.jsp?rp=mList";
			break;
			
		case "modify":
			String mid3 = request.getParameter("mid");
				logger.info("><><><><" + mid3);
			MemberVO mvo3 = msv.getInfo(mid3);
			request.setAttribute("mvo", mvo3);
			destPage = "index.jsp?rp=mModify";
			break;
			
		case "update":
			String mid4 = request.getParameter("mid");
			String mname4 = request.getParameter("mname");
			String mpwd4 = request.getParameter("mpwd");
			String mphone4 = request.getParameter("mphone");
			MemberVO mvo4 = new MemberVO(mname4,mid4,mpwd4,mphone4);
			int isUp = msv.modify(mvo4);
			logger.info(">>>> MemberController > update :"  + (isUp > 0 ? "수정성공":"수정실패"));
			destPage = "member?sv=list";
			break;
			
		case "delete":
			String mid5 = request.getParameter("mid");
			int deleteOk = msv.remove(mid5);
			logger.info(">>> MemberController > delete : " + (deleteOk > 0 ? "삭제성공":"삭제실패"));
			destPage = "member?sv=logout";
			break;
			
		case "check":
			String mid6 = request.getParameter("mid");
			int exist = msv.midCheck(mid6);
			PrintWriter out = response.getWriter();
			out.print(exist);
			break;	
			
		default:
			break;
		}if(destPage != "") {
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
