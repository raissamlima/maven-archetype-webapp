import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/produto")
public class Produto extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        String nome = req.getParameter("nome");
        String paramValor = req.getParameter("valor");
        String id_categoria = req.getParameter("id_categoria");

        if (paramValor != null) {
            float valor = Float.parseFloat(paramValor);
            out.printf("Modulo Produtos - Prod = %s - %f - %s", nome, valor, id_categoria);
        } else {
            out.printf("Modulo Produtos - Prod = %s - %s", nome, id_categoria);
        }
    }
}
