public class Homem 
extends Pessoa
{
    private String genero = "M";
    private int idade = 0;
    
    public Homem(String n, String sN, int diaNasc, int mesNasc, int anoNasc) 
    {
        super(n, sN, diaNasc, mesNasc, anoNasc);
        setIdade(anoNasc);
    }

    public Homem(String n, String sN, int diaNasc, int mesNasc, int anoNasc, Long cpf, float weight, float height)
    {
        super(n, sN, diaNasc, mesNasc, anoNasc, cpf, weight, height);
        setIdade(anoNasc);
    }

    private void setIdade(int ano)
    {
        this.idade = 2022 - ano;
    }

    public int getIdade()
    {
        return this.idade;
    }

    public String getGenero()
    {
        return "Essa pessoa é do gênero masculino ( " + genero + " ).";
    }

    public String toString()
    {
        if (( this.numCPF != 0 ) && ( this.peso != 0 ) && ( this.altura != 0 ))
        {
            return "Essa pessoa se chama " + nome + " " + sobreNome + ", nasceu na data " + dia +"/" + mes + "/" + ano + ", tem " + idade + " anos e é do gênero masculino.";
        }

        return "Essa pessoa se chama " + nome + " " + sobreNome + ", nasceu na data " + dia +"/" + mes + "/" + ano + ", possui CPF de número " + numCPF + ", um peso de " + peso + "kg, uma altura de " + altura + "m, tem " + idade + " anos e é do gênero masculino.";
    }
}
