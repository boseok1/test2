package Action.ProcAction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Action.Action;
import model.Product;
import repository.ProductRepository;

public class ProductDeleteProcAction implements Action {
 @Override
public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("삭제?");
	 int productId = Integer.parseInt(request.getParameter("productId"));
		ProductRepository repository = ProductRepository.getInstance();
		int result = repository.deleteById(productId);
		
		if(result == 1) {
			List<Product>products = repository.findAll();
			
			Gson gson = new Gson();
			
			String productsJson = gson.toJson(products);
			
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/json); charser=utf-8");
			PrintWriter pw = response.getWriter();
			pw.println(products);
			
		}
	
}
}
