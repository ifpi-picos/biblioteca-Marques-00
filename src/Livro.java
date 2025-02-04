import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String autor;
    private String titulo;
    private String editora;
    private int ano;
    private boolean disponivel;
    private List<Usuario> listaReservas; // Nova linha

    public Livro(String autor, String titulo, String editora, int ano, boolean disponivel) {
        this.autor = autor;
        this.titulo = titulo;
        this.editora = editora;
        this.ano = ano;
        this.disponivel = disponivel;
        this.listaReservas = new ArrayList<>(); // nova linha
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;

    }

    // nova linha
    public void reservarLivro(Usuario usuario) {
        listaReservas.add(usuario);
    }

    public List<Usuario> getReservas() {
        return listaReservas;
    }

    public void limparReservas() {
        listaReservas.clear();
    }

}
