package com.qut.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qut.service.DocInfoService;

/**
 * Servlet implementation class UpdateDocServlet
 */
@WebServlet("/UpdateDocServlet")
public class UpdateDocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDocServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		Map<String, String[]> params=
				request.getParameterMap();
		DocInfoService service=new DocInfoService();
		boolean flag=service.doUpdate(params);
		if(flag){
			response.sendRedirect("success.jsp");
		}else{
			response.sendRedirect("error.jsp");
		}
	}

}
