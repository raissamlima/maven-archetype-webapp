package com.zuplae.vendas.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.zuplae.vendas.dao.CategoriaDao;
import com.zuplae.vendas.model.Categoria;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/categoria")
public class CategoriaSevlet extends HttpServlet { 

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // protocolo HTTP/HTTPS 
            // request - solicitacao do usuario - ex. o usuario acessando end. via chrome
            // response - resposta do servidor ao usuario - ex, carregar a pag web no chrome
        
            // CRIAR UMA CATEGORIA DAO AQUI
        CategoriaDao dao = new CategoriaDao();
        Categoria model = new Categoria();

        model.setNome(req.getParameter("nome"));
        model.setDescricao(req.getParameter("descricao"));

        model.setId(dao.insert(model));

        PrintWriter out = resp.getWriter();
        out.printf("Modulo Categoria -- cat = %s - %s", model.getNome(), model.getDescricao());
    } 
}
