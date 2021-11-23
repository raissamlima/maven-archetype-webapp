package com.zuplae.vendas.servlets;

import java.io.IOException;
//import java.io.PrintWriter; não está sendo usado no momento

import com.zuplae.vendas.dao.CategoriaDao;
import com.zuplae.vendas.model.Categoria;

import jakarta.servlet.RequestDispatcher;
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
        
        CategoriaDao dao = new CategoriaDao();
        Categoria model = new Categoria();

        model.setNome(req.getParameter("nome"));
        model.setDescricao(req.getParameter("descricao"));
        int id = dao.insert(model);

        model.setId(id);
        req.setAttribute("id", model.getId());

        RequestDispatcher rd = req.getRequestDispatcher("categoria-sucesso.jsp");
        rd.forward(req, resp); // Estou encaminhando isso para que outro lugar dê a resposta
        // Antes estava printando, mostrando o resultado na tela, agora ele só diz a
        // seguinte msg "Sucesso"
        // e foi adicionado em webapp a "categoria-sucesso" e lá foi colocado um link
        // que acessa a listagem.

        // PrintWriter out = resp.getWriter();
        // out.printf("Modulo Categoria -- cat = %s - %s", model.getNome(),
        // model.getDescricao());

    }
}
