package com.vfgw.servlet;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.InputFormatException;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidateVideoDurationServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String filePath = req.getParameter("file1");
		System.out.println(filePath);
		Encoder encoder = new Encoder();
		File srcFile = new File(filePath);
		try {
			final long duration = encoder.getInfo(srcFile).getDuration()/1000;
//			req.setAttribute("duration", duration);
			req.getSession().setAttribute("duration", duration);
		} catch (InputFormatException e) {
			e.printStackTrace();
		} catch (EncoderException e) {
			e.printStackTrace();
		}
//		req.setAttribute("filePath", filePath);
		req.getSession().setAttribute("filePath", filePath);
		req.getRequestDispatcher("/setTimePoint.jsp").forward(req, resp);
	}
	
	

}
