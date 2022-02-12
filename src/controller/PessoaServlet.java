package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pessoa;

/**
 * Servlet implementation class PessoaServlet
 */
@WebServlet("/pessoa")
public class PessoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PessoaServlet() {
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
		String idParam=request.getParameter("id");
		String nomeParam=request.getParameter("nome");
		
		Pessoa p = new Pessoa();
		p.setId(Integer.parseInt(idParam));
		p.setNome(nomeParam);
		
		List<Pessoa> pessoas= new ArrayList<Pessoa>();
		Pessoa p1 = new Pessoa();
		p1.setId(1);
		p1.setNome("Fulano");
		pessoas.add(p1);
		
		Pessoa p2 = new Pessoa();
		p2.setId(2);
		p2.setNome("Beltrano");
		pessoas.add(p2);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		
		request.setAttribute("pessoa", p);
		request.setAttribute("pessoas", pessoas);
		rd.forward(request, response);
		//for(Pessoa pessoa : pessoas) {
	//		System.out.print(pessoa);
	//	}
	}

}
