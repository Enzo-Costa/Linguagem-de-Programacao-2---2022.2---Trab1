import java.util.ArrayList;
import java.util.Scanner;

public class P1nX 
{
    public static Scanner leitor = new Scanner(System.in);

    static boolean ehNome(String n)
    {
        try 
        {
            Long.parseLong(n);

            return false;
        }
        catch(Exception e)
        {
            return true;
        }
    }

    static Pessoa criaPessoa()
    {
        long cpf;

        Pessoa pess = new Pessoa(null, null, 0, 0, 0);

        System.out.println("Por favor digite o nome da pessoa: ");
        String n = leitor.nextLine();
        if (n.equals("") || ehNome(n) == false)
        {
            System.out.println("Nome inválido.");
            return pess;
        }

        System.out.println("Por favor digite o sobrenome da pessoa: ");
        String sn = leitor.nextLine();
        if (sn.equals(""))
        {
            return pess;
        }

        System.out.println("Por favor digite o dia do nascimento da pessoa: ");
        int d = Integer.parseInt(leitor.nextLine());

        if(validadata.isDia(d) == false)
        {
            System.out.println("Dia inválido, por favor digite um dia válido (entre 1 e 30)");
            return null;
        }

        System.out.println("Por favor digite o mês do nascimento da pessoa: ");
        int mes = Integer.parseInt(leitor.nextLine());

        if(validadata.isMes(mes) == false)
        {
            System.out.println("Mês inválido, por favor digite um mês válido (entre 1 e 12)");
            return null;
        }

        System.out.println("Por favor digite o ano do nascimento da pessoa: ");
        int ano = Integer.parseInt(leitor.nextLine());

        if(validadata.isAno(ano) == false)
        {
            System.out.println("Ano inválido, por favor digite um ano válido (entre 0 e 2022)");
            return null;
        }

        System.out.println("Por favor digite o cpf da pessoa: ");
        String c = leitor.nextLine();
        if (c.equals(""))
        {
            return pess;
        }

        long tempcpf = 0;

        if(validacpf.isCPF(c) == false)
        {
            System.out.println("CPF inválido.");
            return null;
        }
        else
        {
            try
            {
                cpf = Long.parseLong(c);
            }
            catch(Exception ex)
            {
                cpf = tempcpf;
            }

        }

        System.out.println("Por favor digite o peso da pessoa: ");
        float p = Float.parseFloat(leitor.nextLine());

        System.out.println("Por favor digite a altura da pessoa: ");
        float a = Float.parseFloat(leitor.nextLine());

        System.out.println("Por favor digite o gênero da pessoa, M para homem (masculino) e F para mulher (faminino): ");
        String genre = leitor.nextLine();
        if (genre.equals(""))
        {
            return pess;
        }

        if (genre.toUpperCase().equals("M"))
        {
            Homem h = new Homem(n, sn, d, mes, ano, cpf, p, a);
            return h;
        }
        if (genre.toUpperCase().equals("F"))
        {
            Mulher m = new Mulher(n, sn, d, mes, ano, cpf, p, a);
            return m;
        }
        else
        {
            System.out.println("Gênero inválido, favor digitar M ou F apenas.");
            return null;
        }
    } 

    public static void main(String[] args) 
    {
        Pessoa p = null;
        Homem h = null;
        Mulher m = null;


        String nome = "", sobreNome = "", genre = "";
        int dia = 0, mes = 0, ano = 0;
        long cpf = 0;
        float peso = 0, altura = 0;

        if (args.length >= 5)
        {
            nome = args[0];
            sobreNome = args[1];
            dia = Integer.parseInt(args[2]);
            mes = Integer.parseInt(args[3]);
            ano = Integer.parseInt(args[4]);
        }

        if (args.length == 8)
        {
            if (validacpf.isCPF(args[5]))
            {
                cpf = Long.parseLong(args[5]);
                peso = Float.parseFloat(args[6]);
                altura = Float.parseFloat(args[7]);
            }
        }

        if (args.length == 9)
        {
            genre = args[8];
        }

        if(validadata.isDia(dia) && validadata.isMes(mes) && validadata.isAno(ano))
        {
            if ((cpf == 0) && (peso == 0) && (altura == 0))
            {
                if (genre == "")
                {
                    p = new Pessoa(nome, sobreNome, dia, mes, ano);
                }
                    
                if(genre.toUpperCase() == "F")
                {
                    m = new Mulher(nome, sobreNome, dia, mes, ano);
                }
                    
                if(genre.toUpperCase() == "M")
                {
                    h = new Homem(nome, sobreNome, dia, mes, ano);
                }
            }
            else
            {            
                if (genre == "")
                {
                    p = new Pessoa(nome, sobreNome, dia, mes, ano, cpf, peso, altura);
                }
                    
                if(genre.toUpperCase() == "F")
                {
                    m = new Mulher(nome, sobreNome, dia, mes, ano, cpf, peso, altura);
                }
                    
                if(genre.toUpperCase() == "M")
                {
                    h = new Homem(nome, sobreNome, dia, mes, ano, cpf, peso, altura);
                }
            }
        }
        else
        {
            System.out.println("Data de nascimento inválida, favor digitar um dia entre 1 e 30, um mês entre 1 e 12 e um ano entre 0 e 2022.");
        }

        System.out.println("Quantas pessoas mais gostaria de cadastrar?");

        int vezes = 0;

        try
        {
            vezes = Integer.parseInt(leitor.nextLine());
        }
        catch(Exception ex)
        {
            System.out.println("Esse número não é valido.");
        }

        ArrayList<Pessoa> pessoas = new ArrayList<>();

        if(p != null)
        {
            pessoas.add(p);
        }

        if(h != null)
        {
            pessoas.add(h);
        } 

        if(m != null)
        {
            pessoas.add(m);
        }

        int cont = 0;

        for(int i = 1; i <= vezes; i++)
        {
            Pessoa p1 = criaPessoa();

            if(p1 == null)
            {
                break;
            }
            else
            {
                pessoas.add(p1);
                cont++;
            }
        }

        Homem temphomem = null;
        Mulher tempmulher = null;

        Pessoa[] vetorPessoas = new Pessoa[pessoas.size()];
        pessoas.toArray(vetorPessoas);

        for(int x = 0; x < cont; x++)
        {
            if(vetorPessoas[x] instanceof Homem)
            {
                temphomem = (Homem) vetorPessoas[x];

                System.out.println(vetorPessoas[x].toString());
            }

            if(vetorPessoas[x] instanceof Mulher)
            {
                tempmulher = (Mulher) vetorPessoas[x];

                System.out.println(vetorPessoas[x].toString());
            }

        }

        int conthomem = 0;
        int contmulher = 0;

        for(int y = 0; y < cont; y++)
        {
            if(vetorPessoas[y] instanceof Homem)
            {
                conthomem++;
            }
            if(vetorPessoas[y] instanceof Mulher)
            {
                contmulher++;
            }
        }

        System.out.println("No array, estão contidos " + conthomem + " homem(ns) e " + contmulher + " mulher(es).");

        leitor.close();
    }
    
}
