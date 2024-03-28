import java.util.Scanner;

public class App{
    public static void main(String args[]) throws Exception { 
        Scanner s = new Scanner(System.in);
        System.out.print("Nome do professor: ");
        String nome  = s.next();
        System.out.print("Quantos anos de experiencia ele tem? R: ");
        int experiencia = s.nextInt();
        Professor p = new Professor(nome, experiencia);
        System.out.println(p);
        System.out.println("Categoria: " + p.classifica());
        s.close();
    }
}
