public class Professor {
    private String nome;
    private int anosExperiencia;

    public Professor(String nome, int anosExperiencia) {
        this.nome = nome;
        this.anosExperiencia = anosExperiencia;
    }

    public String getNome() {
        return nome;
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public String classifica() throws Exception {
        // // Nova sintaxe do Java 14-15 em diante
        // return switch(anosExperiencia) {
        //     case 0, 1, 2, 3, 4, 5 -> "Assistente";
        //     case 6, 7, 8, 9, 10 -> "Adjunto";
        //     default -> "Titular";
        // };
        Exception InvalidExperienceYearsCount = new Exception("Invalid Experience Years Count");
        
        boolean invalidExpYears = this.anosExperiencia < 0;
        if (invalidExpYears) {
            throw InvalidExperienceYearsCount;
        }
        
        boolean assistenteExpYears = this.anosExperiencia <= 5;
        if (assistenteExpYears) {
            return "Assistente";
        }

        boolean adjuntoExpYears = this.anosExperiencia <= 10;
        if (adjuntoExpYears) {
            return "Adjunto";
        }
        
        boolean titularExpYears = this.anosExperiencia > 10;
        if (titularExpYears) {
            return "Titular";
        }
        
        throw InvalidExperienceYearsCount;
    }

    @Override
    public String toString() {
        return "Professor: " + nome + ", anos de experiencia: " + anosExperiencia;
    }
}
