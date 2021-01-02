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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.donate.domain.MemberVO;
import com.donate.domain.Paging;
import com.donate.domain.ReportVO;
import com.donate.service.MemberService;
import com.donate.service.MemberServiceImp;
import com.donate.service.ReportService;
import com.donate.service.ReportServiceImp;


@WebServlet("/report")
public class ReportController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(ReportController.class);
	private ReportService rsv;
	private MemberService msv;
   
	public ReportController() {
        rsv = new ReportServiceImp();
        msv = new MemberServiceImp();
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
			String [] name2 = request.getParameterValues("mname");
			int clPage = request.getParameter("cp") != null ? 
					Integer.parseInt(request.getParameter("cp")) : 1;
					String name3 = name2[0];			
					int total = rsv.totalCount(name3);
			
			Paging paging = new Paging(clPage, total, name3);
			ArrayList<ReportVO> rList = (ArrayList<ReportVO>) rsv.getList(paging);
			request.setAttribute("rList", rList);
			request.setAttribute("paging", paging);
			destPage = "index.jsp?rp=rList";
			break;
			
		case "list_m":
			String [] name2_m = request.getParameterValues("mname");
			int clPage_m = request.getParameter("cp") != null ? 
					Integer.parseInt(request.getParameter("cp")) : 1;
					String name3_m = name2_m[0];			
					int total_m = rsv.totalCount(name3_m);
			
			Paging paging_m = new Paging(clPage_m, total_m, name3_m);
			ArrayList<ReportVO> rList_m = (ArrayList<ReportVO>) rsv.getList(paging_m);
			MemberVO mvo3 = msv.getInfo(name3_m);
			request.setAttribute("mvo", mvo3);
			request.setAttribute("rList", rList_m);
			request.setAttribute("paging", paging_m);
			destPage = "index.jsp?rp=detail";
			break;
			
			
			
			
		case "list_r":
			String ins4 = request.getParameter("ins");						
			ArrayList<ReportVO> rList4 = (ArrayList<ReportVO>) rsv.getList(ins4);;
			JSONArray rptArr = new JSONArray();
			for (int i = 0; i < rList4.size(); i++) {
				JSONObject rptObj = new JSONObject();
				rptObj.put("name", rList4.get(i).getName());
				rptObj.put("product", rList4.get(i).getProduct());
				rptObj.put("count",rList4.get(i).getCount());
			
				rptArr.add(rptObj);
			}
			String jsonCmtStringData = rptArr.toJSONString();
			logger.info(">>>>jsonCmtStringData  "+jsonCmtStringData);
			PrintWriter out2 = response.getWriter();
			out2.print(jsonCmtStringData);
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
