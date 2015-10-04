package app.Controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * Servlet implementation class FileUploadController
 */
//@WebServlet("/FileUploadController")
@MultipartConfig(fileSizeThreshold=1024*1024*2,maxFileSize=1024*1024*10,maxRequestSize=1024*1024*50)
public class FileUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String dir = "UploadedFiles";
	private ServletFileUpload uploader = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path=request.getServletContext().getRealPath("");

		File save_Dir = new File(path + File.separator + dir);
		System.out.println("Save Dir " +save_Dir);
		if(!save_Dir.exists())
		{
			save_Dir.mkdir();
			
			System.out.println("Save Dir " +save_Dir);
		}
		if(ServletFileUpload.isMultipartContent(request)){
			            try {
			            	List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			                for(FileItem item : multiparts){
			                    if(!item.isFormField()){
			                        String name = new File(item.getName()).getName();  
			                        //System.out.println("UserFile " +name);
			                       item.write( new File(path + File.separator + dir + File.separator + name));
			                    }
			                }
			            

		
		 
		
		System.out.println("3 " +save_Dir);
		
		request.setAttribute("message","Upload Completed");
		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		view.forward(request, response);
		}
		catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message","File Upload Failed");
		}
		}	
	}

	
	
	}


