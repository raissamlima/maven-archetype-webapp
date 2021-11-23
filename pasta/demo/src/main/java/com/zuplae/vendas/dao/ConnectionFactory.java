package com.zuplae.vendas.dao;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

    private DataSource dataSource;

    public ConnectionFactory() {
        ComboPooledDataSource pool = new ComboPooledDataSource();
        try {
            pool.setDriverClass("org.postgresql.Driver"); 
        // Arrumando a questão do tomcat que não estava funcionando e o try/catch para corrigir a exceção
        // que é pedida quando se faz um pool set driver class
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        this.dataSource = pool;
    }

    public Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }
}