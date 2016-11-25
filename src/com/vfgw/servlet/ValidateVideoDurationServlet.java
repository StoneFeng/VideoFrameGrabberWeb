package com.vfgw.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vfgw.jave.Encoder;
import com.vfgw.jave.EncoderException;
import com.vfgw.jave.InputFormatException;

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
		Encoder encoder = new Encoder();
		File srcFile = new File(filePath);
		try {
			final long duration = encoder.getInfo(srcFile).getDuration()/1000;
			req.getSession().setAttribute("duration", duration);
		} catch (InputFormatException e) {
			e.printStackTrace();
		} catch (EncoderException e) {
			e.printStackTrace();
		}
		req.getSession().setAttribute("filePath", filePath);
		req.getRequestDispatcher("/setTimePoint.jsp").forward(req, resp);
	}
	
	

}
