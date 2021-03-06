package Core.Domain;

/**
 *
 * @author Lucas
 */
public class Professor
{

    private String codigoProfessor;
    private String nome;
    private Integer[] disponibilidade;

    public Professor(String codigoProfessor, String nome, Integer[] disponibilidade)
    {
        this.codigoProfessor = codigoProfessor;
        this.nome = nome;
        this.disponibilidade = disponibilidade;
    }

    public Professor()
    {

    }

    public boolean verificarDisponibilidade(Integer index)
    {
        /* Caso professor esteja disponível retorna TRUE, caso contrário FALSE */
        boolean disponivel = this.disponibilidade[index] != 1;
        return disponivel;
    }

    public String getCodigoProfessor()
    {
        return codigoProfessor;
    }

    public void setCodigoProfessor(String codigoProfessor)
    {
        this.codigoProfessor = codigoProfessor;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public Integer[] getDisponibilidade()
    {
        return disponibilidade;
    }

    public void setDisponibilidade(Integer[] disponibilidade)
    {
        this.disponibilidade = disponibilidade;
    }

}
