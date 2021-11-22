package com.zuplae.vendas.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.zuplae.vendas.model.Produto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/produto")
public class ProdutoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Produto prod1 = new Produto();

        String nome = req.getParameter("nome");
        String paramValor = req.getParameter("valor");
        String id_categoria = req.getParameter("id_categoria");

        prod1.setNome(nome);
        prod1.setNome(id_categoria);

        if (paramValor != null) {
            prod1.setValor(Float.parseFloat(paramValor));
            out.printf("Modulo Produtos - Prod = %s - %f - %s", prod1.getNome(), prod1.getValor(), prod1.getId_categoria());
        } else {
            out.printf("Modulo Produtos - Prod = %s - %s", nome, id_categoria);
        }
    }
}
