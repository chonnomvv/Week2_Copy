package kr.co.bit.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.jrockit.jfr.RequestDelegate;

import kr.co.bit.day4.MemberVO;

public class TestServlet extends HttpServlet {
	private ArrayList<MemberVO> list;
	
//	public TestServlet() {
//		list = new ArrayList<MemberVO>();
//	}
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		list = new ArrayList<MemberVO>();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		String url = "./mvc/home.jsp";
		
		String cmd = req.getParameter("cmd");
		cmd = cmd==null?"":cmd;
		if(cmd.equals("viewRegist")) {
			url = "./mvc/regist_member.jsp";
		} else if(cmd.equals("regist")) {
			// 다 꺼내서 인스턴스에 할당
			MemberVO vo = new MemberVO();
			vo.setId(req.getParameter("id"));
			vo.setPw(req.getParameter("pw"));
			vo.setName(req.getParameter("name"));
			vo.setZipcode(req.getParameter("zip1")+"-"+req.getParameter("zip2"));
			vo.setAddr1(req.getParameter("addr1"));
			vo.setAddr2(req.getParameter("addr2"));
			vo.setEmail(req.getParameter("email"));
			vo.setTool(req.getParameter("tool"));
			vo.setProject(req.getParameter("project"));
			String[] temp = req.getParameterValues("lang");
			String[] idx = {"","","",""};
			for(String val : temp) {
				int index = Integer.parseInt(val);
				idx[index] = val;
			}
			vo.setLangs(idx);
			list.add(vo);
			System.out.println("1명 등록");		
			req.setAttribute("message", "success");
		}
		RequestDispatcher rd = req.getRequestDispatcher(url);
		rd.forward(req, resp);
	} 
}









