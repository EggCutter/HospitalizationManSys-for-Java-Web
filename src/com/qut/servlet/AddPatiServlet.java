package com.qut.servlet;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qut.service.PatiInfoService;


@WebServlet("/AddPatiServlet")
public class AddPatiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPatiServlet() {
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
//		处理中文
		request.setCharacterEncoding("UTF-8");
		Map<String,String[]> params=request.getParameterMap();
		PatiInfoService service=new PatiInfoService();
		boolean flag=service.doInsert(params);
		if(flag){
			response.sendRedirect("success.jsp");
		}else{
			response.sendRedirect("error.jsp");
		}
	}

}
