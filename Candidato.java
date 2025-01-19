public class Candidato {
    private String _nomeCandidato;
    private int _numeroCandidato;
    public int votos;
    private char _digito1_candidato, _digito2_candidato;

    public Candidato(String nomeCandidato, int numeroCandidato, char digito1_candidato, char digito2_candidato) {
        this._nomeCandidato = nomeCandidato;
        this._numeroCandidato = numeroCandidato;
        this._digito1_candidato = digito1_candidato;
        this._digito2_candidato = digito2_candidato;

    }

}