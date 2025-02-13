package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    private static final String URL="jdbc:postgresql://localhost:5432/Biblioteca";
    private static final String USUARIO="postgres";
    private static final String SENHA = "amandabd";
    public static Connection conectar (){
        try {
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (Exception e) {
            throw new RuntimeException ("Erro na conexao" , e);
        }
    }


    
}
