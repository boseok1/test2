package Action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Action.ProcAction.ProductReSetProcAction;
import model.Product;
import repository.ProductRepository;




public class HomeProcAction implements Action {
@Override
public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("ProductTestAction"); 
	ProductRepository productRepository = ProductRepository.getInstance();
	List<Product> products = productRepository.findAll(); 
	request.setAttribute("products", products);
	

	
	System.out.println("홈페이지 이동합니다.");
	// 데이터를 들고 가기위해서 사용
	// 리퀘스트디스패쳐 = 리퀘스트에 담긴 정보를 객체를 생성해서  forward할 페이지를 요청 
	RequestDispatcher rd = request.getRequestDispatcher("home.jsp"); 
	//  home.jsp페이지를 요청과함께 rd에 담아 forward에 요청함
	rd.forward(request, response);
 }
}
