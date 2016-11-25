package com.vfgw.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vfgw.jave.Encoder;
import com.vfgw.jave.EncoderException;

public class SetTimePointServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Long duration = (Long) req.getSession().getAttribute("duration");
		String filePath = (String) req.getSession().getAttribute("filePath");
		String timePoint = req.getParameter("timePoint");
		timePoint = "".equals(timePoint) ? "1" : timePoint;
		float floatTimePoint = Float.parseFloat(timePoint);
		if (floatTimePoint > duration) {
			floatTimePoint = duration;
		}
		File srcFile = new File(filePath);
		File imgFile = new File(req.getServletContext().getRealPath("/")+"test.jpg");
		if (imgFile.exists()) {
			imgFile.delete();
			imgFile = new File(req.getServletContext().getRealPath("/")+"test.jpg");
		}
		Encoder encoder = new Encoder();
		try {
			encoder.getImage(srcFile, imgFile, floatTimePoint);
		} catch (EncoderException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("/displayThumb.jsp").forward(req, resp);
	}
	
	

}
