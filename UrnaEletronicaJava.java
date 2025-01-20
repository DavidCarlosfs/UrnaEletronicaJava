import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Candidato {
    private String _nomeCandidato;
    private int _numeroCandidato;
    private int _votos;
 

    public Candidato(String nomeCandidato, int numeroCandidato) {
        this._nomeCandidato = nomeCandidato;
        this._numeroCandidato = numeroCandidato;
        this._votos = 0;
    }

    public String getNome() {
        return _nomeCandidato;
    }

    public int getNumero() {
        return _numeroCandidato;
    }

    public int getVotos() {
        return _votos;
    }

    public void incrementarVotos() {
        this._votos++;
    }

}

class UrnaEletronicaJava {

    private List<Candidato> candidatos;
    private int votosNulos;

    public UrnaEletronicaJava() {
        this.candidatos = new ArrayList<>();
        this.votosNulos = 0;
        inicializarCandidatos();
            
        }
    
    public void inicializarCandidatos() {
        candidatos.add(new Candidato("Ada Lovelace", 01));
        candidatos.add(new Candidato("Alan Turing", 02));
        candidatos.add(new Candidato("Marie Curie", 03));
        candidatos.add(new Candidato("Albert Einstein", 04));
        candidatos.add(new Candidato("Ludwing van Beethoven", 05));
    }
    
    public void receberVotos(int numero) {
        boolean candidatoEncontrado = false;
        for (Candidato candidato : candidatos) {
            if (candidato.getNumero() == numero) {
                candidato.incrementarVotos();
                candidatoEncontrado = true;
                break;
            }
        }
        if (!candidatoEncontrado) {
            votosNulos++;
        }
    }

    public void apurarResultados() {
        System.out.println("Resultado da votação:");
        int votosValidos = 0;
        for (Candidato candidato : candidatos) {
            votosValidos += candidato.getVotos();
        }

        Candidato vencedor = candidatos.get(0);
        boolean empate = false;

        for (Candidato candidato : candidatos) {
            int votos = candidato.getVotos();
            if (votosValidos > 0) {
                double percentual = votos / votosValidos * 100;
                System.out.println(candidato.getNome() + ": " + votos + " votos (" + percentual + "%)");
            }
            else {
                System.out.println(candidato.getNome() + ": " + votos + " votos (0%)");
            }

            if (vencedor == null || votos > vencedor.getVotos()) {
                vencedor = candidato;
                empate = false;
            } else if (candidato.getVotos() == vencedor.getVotos()) {
                empate = true;
            }
        }
        System.out.println("Votos nulos: " + votosNulos);

        if (empate) {
            System.out.println("Houve um empate entre os candidatos.");
        } else {
            System.out.println("O vencedor é: " + vencedor.getNome());
        }
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

public class UrnaEletronica {
    public static void main(String[] args) {
        UrnaEletronicaJava urna = new UrnaEletronicaJava();
        Scanner input = new Scanner(System.in);

        System.out.println("Bem-vindo à urna eletrônica!");
        System.out.println("Candidatos:");
        for (Candidato candidato : urna.candidatos) {
            System.out.println(candidato.getNumero() + " - " + candidato.getNome());
        }

        int totalVotos = 10;
        for (int contador = 0; contador < totalVotos; contador++) {
            System.out.println("Informe o número do" + (contador + 1) + "º candidato: " + totalVotos);
            
            String votor_eleitor = input.next();
        
            if (votor_eleitor.length() == 2 && Character.isDigit(votor_eleitor.charAt(0)) && Character.isDigit(votor_eleitor.charAt(1))) {
                int numero = Integer.parseInt(votor_eleitor);
                urna.receberVotos(numero);
            } else {
                System.out.println("Número inválido. Tente novamente.");
                contador--;
            }
        }
            input.close();
            urna.apurarResultados();

        }
    }
    
}
