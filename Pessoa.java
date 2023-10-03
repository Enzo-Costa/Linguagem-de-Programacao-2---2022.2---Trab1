import java.util.GregorianCalendar;

public class Pessoa 
{
    protected int contpessoas = 0;

    protected String nome;
    protected String sobreNome;
    protected GregorianCalendar dataNasc;
    protected long numCPF = 0;
    protected float peso = 0;
    protected float altura = 0;
    protected int dia = 0;
    protected int mes = 0;
    protected int ano = 0;

    public Pessoa(String n, String sN, int diaNasc, int mesNasc, int anoNasc)
    {
        setNome(n);
        setSobreNome(sN);
        dataNasc = setDataNasc(diaNasc, mesNasc, anoNasc);
        IncrementaContador();
    }

    public Pessoa(String n, String sN, int diaNasc, int mesNasc, int anoNasc, Long cpf, float weight, float height)
    {
        setNome(n);
        setSobreNome(sN);
        dataNasc = setDataNasc(diaNasc, mesNasc, anoNasc);
        setCPF(cpf);
        setPeso(weight);
        setAltura(height);
        IncrementaContador();
    }

    private void setNome(String name)
    {
        this.nome = name;
    }

    public String getNome()
    {
        return this.nome;
    }

    private void setSobreNome(String surname)
    {
        this.sobreNome = surname;
    }
    
    public String getSobreNome()
    {
        return this.sobreNome;
    }

    private GregorianCalendar setDataNasc(int d, int m, int a)
    {
        this.dia = d;
        this.mes = m;
        this.ano = a;

        return new GregorianCalendar(d, m, a);
    }

    public GregorianCalendar getDataNasc()
    {
        return this.dataNasc;
    }

    private void setCPF(Long c)
    {
        this.numCPF = c;
    }

    public long getCPF()
    {
        if (this.numCPF == 0)
        {
            System.out.println("CPF não declarado.");
            return 0;
        }

        return this.numCPF;
    }

    private void setPeso(float p)
    {
        this.peso = p;
    }

    public float getPeso()
    {
        if (this.peso == 0)
        {
            System.out.println("Peso não declarado.");
            return 0;
        }

        return this.peso;
    }

    private void setAltura(float alt)
    {
        this.altura = alt;
    }

    public float getAltura()
    {
        if (this.altura == 0)
        {
            System.out.println("Altura não declarada.");
            return 0;
        }

        return this.altura;
    }

    public String toString()
    {
        if (( this.numCPF != 0 )&&( this.peso != 0 )&&( this.altura != 0 ))
        {
            return "Essa pessoa se chama " + nome + " " + sobreNome + " e nasceu na data " + + dia +"/" + mes + "/" + ano;
        }

        return "Essa pessoa se chama " + nome + " " + sobreNome + ", nasceu na data " + dia +"/" + mes + "/" + ano + ", possui CPF de número " + numCPF + ", um peso de " + peso + "kg e uma altura de " + altura + "m.";
    }

    private void IncrementaContador()
    {
        contpessoas += 1;
    }

    public int numPessoas()
    {
        return contpessoas;
    }
}
