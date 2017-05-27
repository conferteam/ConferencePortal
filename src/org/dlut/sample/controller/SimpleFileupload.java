package org.dlut.sample.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.dlut.sample.pojo.user.UserInfo;
/**
 * Servlet implementation class SimpleFileupload
 */
@WebServlet("/simpleFileupload")
public class SimpleFileupload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserInfo user = new UserInfo();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().setAttribute("user_email", "1@1.1");// 假装用户已经登录
		request.getSession().setAttribute("user_id", "1"); // 假装有个user_id为1的用户登录了
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 1、创建一个DiskFileItemFactory工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 2、创建一个文件上传解析器
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 解决上传文件名的中文乱码
		upload.setHeaderEncoding("UTF-8");
		// 标记是否新建文件
		boolean newfile = false;

		/*
		 * factory.setSizeThreshold(1024*1024 * 500);//设置内存的临界值为500K File linshi
		 * = new File("E:\\linshi");//当超过500K的时候，存到一个临时文件夹中
		 * factory.setRepository(linshi);
		 */
		upload.setSizeMax(1024 * 500);// 设置上传的文件总的大小不能超过500K
		try {
			// 1. 得到 FileItem 的集合 items
			List<FileItem> /* FileItem */ items = upload.parseRequest(request);

			// 2. 遍历 items:
			for (FileItem item : items) {
				// 若是一个一般的表单域, 打印信息
				if (item.isFormField()) { // 如果表单是text，进入此分支
					String name = item.getFieldName();
					String value = item.getString("utf-8");

					System.out.println(name + ": " + value);

				}
				// 若是文件域则把文件保存到 e:\\files 目录下.
				else {
					String filePath = "e:\\files\\";
					String fileName = item.getName();
					long sizeInBytes = item.getSize();
					System.out.println(fileName);
					System.out.println(sizeInBytes);
					if (fileName.endsWith(".jpg")) {
						fileName = request.getSession().getAttribute("user_id").toString() + ".jpg";
						InputStream in = item.getInputStream();
						byte[] buffer = new byte[1024];
						int len = 0;

						fileName = filePath + fileName;// 文件最终上传的位置
						File file = new File(fileName);
						try {
							// 如果文件不存在，则创建新的文件
							if (!file.exists()) {
								file.createNewFile();
								newfile = true; // 新建了文件
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						System.out.println(fileName);
						OutputStream out = new FileOutputStream(fileName);

						while ((len = in.read(buffer)) != -1) {
							out.write(buffer, 0, len);
						}

						out.close();
						in.close();

						if (newfile) { // 如果创建了新文件，将路径写入数据库
							user.setEmail(request.getSession().getAttribute("user_email").toString());
							user.setAvatar("/ConferencePortal/images/files/"
									+ request.getSession().getAttribute("user_id").toString() + ".jpg");
							try { //原生数据库操作
								// 调用Class.forName()方法加载驱动程序
								Class.forName("com.mysql.jdbc.Driver");

								String url = "jdbc:mysql://localhost:3306/huiyi"; // JDBC的URL
								Connection conn;

								conn = DriverManager.getConnection(url, "root", "123456");
								Statement stmt = conn.createStatement(); // 创建Statement对象

								// 修改数据的代码
								String sql2 = "update user set avatar=? where email=?";
								PreparedStatement pst = conn.prepareStatement(sql2);
								pst.setString(1, user.getAvatar());
								pst.setString(2, user.getEmail());
								pst.executeUpdate();

								stmt.close();
								conn.close();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						response.getWriter().format("success", fileName); //成功上传图片，返回成功
					}
					else{//
						response.getWriter().format("endwrong", fileName); //后缀名错误，返回后缀名错误
					}
				}
			}

		} catch (FileUploadException e) {
			e.printStackTrace(); 
			System.out.println("hehe");
		}

	}
}