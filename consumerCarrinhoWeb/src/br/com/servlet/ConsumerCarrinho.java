package br.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ejb.CarrinhoEJB;

/**
 * Servlet implementation class ConsumerCarrinho
 */
@WebServlet("/carrinho")
public class ConsumerCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private CarrinhoEJB carrinho;

    public ConsumerCarrinho() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String prod = request.getParameter("produto");
		writer.println("<html>");
		writer.println("<body>");
		if(prod.length()  > 0) {
			carrinho.adicionarProduto(prod);
			writer.println("<h1>Produto adicionado<h1>");
			writer.println(carrinho.getProdutos());
		}
		
		writer.println("</body>");
		writer.println("</html>");
	}

}
