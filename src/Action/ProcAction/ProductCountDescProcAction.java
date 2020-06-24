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

public class ProductCountDescProcAction implements Action {
@Override
public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("여기는 카운트");
	Gson gson = new Gson();
	ProductRepository repository = ProductRepository.getInstance();
	List<Product> products = repository.findAllCountDesc();
	String productsJson = gson.toJson(products);
	
	response.setCharacterEncoding("utf-8");
	response.setContentType("application/json); charser=utf-8");
	PrintWriter pw = response.getWriter();
	pw.println(productsJson);
	
    }
}
