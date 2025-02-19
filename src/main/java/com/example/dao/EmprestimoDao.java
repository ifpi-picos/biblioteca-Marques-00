
package com.example.dao;

import com.example.entity.Emprestimo;
import com.example.entity.Usuario;
import com.example.entity.Livro;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoDao {
    private Connection conexao;

    public EmprestimoDao(Connection conexao) {
        this.conexao = conexao;
    }

    public void adicionar(Emprestimo emprestimo) {
        String sql = "INSERT INTO emprestimos (data_emprestimo, data_devolucao, usuario_id, livro_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setDate(1, Date.valueOf(emprestimo.getDataEmprestimo()));
            stmt.setDate(2, Date.valueOf(emprestimo.getDataDevolucao()));
            stmt.setInt(3, emprestimo.getUsuario().getId()); // Usa o ID do usuário (inteiro)
            stmt.setInt(4, emprestimo.getLivro().getId()); // Usa o ID do livro (inteiro)
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public List<Emprestimo> consultar() {
        List<Emprestimo> emprestimos = new ArrayList<>();
        String sql = "SELECT e.data_emprestimo, e.data_devolucao, " +
                     "u.id AS usuario_id, u.nome AS usuario_nome, " +
                     "l.id AS livro_id, l.titulo AS livro_titulo " +
                     "FROM emprestimos e " +
                     "JOIN usuarios u ON e.usuario_id = u.id " +
                     "JOIN livros l ON e.livro_id = l.id";
        try (Statement stm = conexao.createStatement(); ResultSet result = stm.executeQuery(sql)) {
            while (result.next()) {
                // Cria um objeto Usuario com ID e nome
                Usuario usuario = new Usuario(
                    result.getInt("usuario_id"),
                    result.getString("usuario_nome"),
                    "", "", ""
                );
                // Cria um objeto Livro com ID e título
                Livro livro = new Livro(
                    result.getInt("livro_id"),
                    result.getString("livro_titulo"),
                    "", "", 0, true
                );
                // Adiciona o empréstimo com usuário e livro completos
                emprestimos.add(new Emprestimo(
                    result.getDate("data_emprestimo").toLocalDate(),
                    result.getDate("data_devolucao").toLocalDate(),
                    usuario,
                    livro
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emprestimos;
    }
    
    
    public void remover(int usuarioId, int livroId) { // Usa IDs (inteiros)
        String sql = "DELETE FROM emprestimos WHERE usuario_id = ? AND livro_id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, usuarioId);
            stmt.setInt(2, livroId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}