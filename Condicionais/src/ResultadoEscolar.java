public class ResultadoEscolar {
    public static void main(String[] args) {
        double media = 5.9;
        
        if (media>7){
            System.out.println("Aprovado");
        } else if (media >= 5 || media < 6) {
            System.out.println("Recuperação");
        }else {
            System.out.println("Reprovado!");
        }


    }
}
