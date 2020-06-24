package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Action.Action;
import Action.HomeProcAction;
import Action.ProcAction.ProductCountDescProcAction;
import Action.ProcAction.ProductDeleteProcAction;
import Action.ProcAction.ProductPriceAscProcAction;
import Action.ProcAction.ProductPriceDescProcAction;
import Action.ProcAction.ProductReSetProcAction;

@WebServlet("/cont")
public class ButtonController extends HttpServlet {
	private final static String TAG = "ButtonController";
	private static final long serialVersionUID = 1L;

	public ButtonController() {
		super(); 	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// do프로세스로 요청,응답받기
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// do프로세스로 요청,응답받기
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 // String 타입의 변수 cmd를 만들고  
		// request.getPrameter  메소드로  cmd 값을 얻기
		String cmd = request.getParameter("cmd");
		System.out.println(TAG + "router : " + cmd);
		Action action = router(cmd);
		action.execute(request, response);
	}

	public Action router(String cmd) {
	System.out.println("이동");
		if(cmd.equals("home")) {
		return new HomeProcAction();				
		}else if(cmd.equals("reset")) {
			return new ProductReSetProcAction();
		}else if(cmd.equals("priceAsc")) {
			return new ProductPriceAscProcAction();
		}else if(cmd.equals("priceDesc")) {
			return new ProductPriceDescProcAction();
		}else if(cmd.equals("countDesc")) {
			return new ProductCountDescProcAction();
		}else if(cmd.equals("delete")) {
			return new ProductDeleteProcAction();
		}
			return null;
	}
 }
