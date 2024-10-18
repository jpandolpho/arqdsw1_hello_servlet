package br.edu.ifsp.dsw1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Hello", urlPatterns = {"/oi","/oi.do"})
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String messages[];
	private int position;
       
    public HelloServlet() {
        super();
        messages = new String[] {
        		"Hello, World!",
        		"Olá, Mundo!",
        		"¡Hola, Mundo!",
        		"Bonjour, le Monde!",
        		"Hallo, Welt!"
        };
        position = -1;
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//try-with-resources, tem nos materiais de aula antigos
		try(PrintWriter out = response.getWriter()){
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Olá Servlet!</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>"+ messages[usePosition()] +"</h1>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private int usePosition() {
		position++;
		if(position==5) {
			position=0;
		}
		return position;
	}
}
