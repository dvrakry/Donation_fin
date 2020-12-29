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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.donate.domain.SupportVO;
import com.donate.service.SupportService;
import com.donate.service.SupportServiceImp;


@WebServlet("/support")
public class SupportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(SupportController.class);
    private SupportService ssv;
	
    public SupportController() {
    	ssv = new SupportServiceImp();
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
			String thumb = request.getParameter("thumb");
			logger.info(">>> thumb : " + thumb);
			String pname = request.getParameter("pname");
			logger.info(">>> pname : " + pname);
			int price = Integer.parseInt(request.getParameter("price"));
			logger.info(">>> price : " + price);
			SupportVO svo = new SupportVO(thumb,pname,price);
			int isReg = ssv.regist(svo);
			PrintWriter out = response.getWriter();
			out.print(isReg);
			break;
		case "list":
			//List<> slist = ssv.getList();
			ArrayList<SupportVO> sList = (ArrayList<SupportVO>) ssv.getList();
			request.setAttribute("sList", sList);
			destPage = "index.jsp?rp=sli";
			break;
		case "rm":
			int sno = Integer.parseInt(request.getParameter("sno"));
			logger.info("SNO를 불러온다 " + sno);
			int suRm = ssv.remove(sno);
			logger.info(">>>> "+(suRm>0 ? "삭제 성공" : "삭제 실패"));
			destPage = "support?sv=list";
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
