package com.donate.ctrl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.donate.domain.ReportVO;
import com.donate.service.ReportService;
import com.donate.service.ReportServiceImp;


@WebServlet("/report")
public class ReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(ReportController.class);
	private ReportService rsv;
    public ReportController() {
        rsv = new ReportServiceImp();
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String sv = request.getParameter("sv");
		String destPage = "";
		ReportVO rvo = null;
		
		switch (sv) {
		case "reg":
			
			rvo = new ReportVO();
			//String name, String product, int price, int count, String ins
			
			String [] name = request.getParameterValues("mname");
			String [] product = request.getParameterValues("product");
			String [] price = request.getParameterValues("sprice");
			String [] ins = request.getParameterValues("ins");
			String [] count = request.getParameterValues("rcount");
			
			for (int i = 0; i < product.length; i++) {
				logger.info(">>>>>>>"+count[i]);
				rvo.setCount(Integer.parseInt(count[i]));
				rvo.setPrice(Integer.parseInt(price[i]));
				rvo.setName(name[i]);
				rvo.setProduct(product[i]);
				rvo.setIns(ins[i]);
				rsv.regist(rvo);
			}
						
			destPage = "report?sv=list";
			break;
		case "list":
			ArrayList<ReportVO> rList = (ArrayList<ReportVO>) rsv.getList();
			request.setAttribute("rList", rList);
			destPage = "index.jsp?rp=rList";
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
