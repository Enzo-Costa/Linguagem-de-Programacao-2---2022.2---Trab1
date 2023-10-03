public class validadata 
{
    static boolean isDia(int d)
    {
        return ((d >= 1) && (d <= 30));
    } 
    
    static boolean isDia(String d)
    {
        try
        {
            int dia = Integer.parseInt(d);

            return ((dia >= 1) && (dia <= 30));
        }
        catch (Exception e)
        {
            System.out.println("Não foi possível converter, por favor digite uma entrada válida para um dia.");
            return false;
        }

    }

    static boolean isMes(int m)
    {
        return ((m >= 1) && (m <= 12));
    }

    static boolean isMes(String m)
    {
        try
        {
            int mes = Integer.parseInt(m);

            return ((mes >= 1) && (mes <= 12));
        }
        catch (Exception e)
        {
            System.out.println("Não foi possível converter, por favor digite uma entrada válida para um mês.");
            return false;
        }

    }

    static boolean isAno(int a)
    {
        return ((a >= 1) && (a <= 2023));
    }

    static boolean isAno(String a)
    {
        try
        {
            int ano = Integer.parseInt(a);

            return ((ano >= 1) && (ano <= 2023));
        }
        catch (Exception e)
        {
            System.out.println("Não foi possível converter, por favor digite uma entrada válida para um ano.");
            return false;
        }

    }
}
