import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/categoria")
public class Categoria extends HttpServlet { 

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // protocolo HTTP/HTTPS 
            // request - solicitacao do usuario - ex. o usuario acessando end. via chrome
            // response - resposta do servidor ao usuario - ex, carregar a pag web no chrome
        String nome = req.getParameter("nome");
        String descricao = req.getParameter("descricao");
        PrintWriter out = resp.getWriter();
        out.printf("Modulo Categoria -- cat = %s - %s", nome, descricao);
    } 
}
