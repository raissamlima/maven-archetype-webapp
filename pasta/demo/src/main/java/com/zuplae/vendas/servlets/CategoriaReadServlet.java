package com.zuplae.vendas.servlets;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.ArrayList;

import com.zuplae.vendas.dao.CategoriaDao;
import com.zuplae.vendas.model.Categoria;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/categoria/listar")
public class CategoriaReadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // PrintWriter out = resp.getWriter();
        // for (Categoria model : dao.read()) {
        // out.printf("%d - %s \n", model.getId(), model.getNome());
        // }

        CategoriaDao dao = new CategoriaDao();
        ArrayList<Categoria> categorias;

        String nome = req.getParameter("nome");
        if (nome != null) {
            categorias = dao.read(nome);
        } else {
            categorias = dao.read();
        }

        req.setAttribute("categorias", categorias); // Parametro para salvar as categorias/enviando para o jsp

        RequestDispatcher rd = req.getRequestDispatcher("/categoria-lista.jsp");
        rd.forward(req, resp);
    }
}
