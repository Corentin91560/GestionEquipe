package sample.Class;

public class Equipe {

    int idequipe;
    String nomequipe;
    int idclub;
    int idchampionnat;

    public Equipe(String nomequipe) {
        this.nomequipe = nomequipe;
    }

    public Equipe(int idequipe, String nomequipe) {
        this.idequipe = idequipe;
        this.nomequipe = nomequipe;
    }

    public int getIdequipe() {
        return idequipe;
    }

    public void setIdequipe(int idequipe) {
        this.idequipe = idequipe;
    }

    public String getNomequipe() {
        return nomequipe;
    }

    public void setNomequipe(String nomequipe) {
        this.nomequipe = nomequipe;
    }

    public int getIdclub() {
        return idclub;
    }

    public void setIdclub(int idclub) {
        this.idclub = idclub;
    }

    public int getIdchampionnat() {
        return idchampionnat;
    }

    public void setIdchampionnat(int idchampionnat) {
        this.idchampionnat = idchampionnat;
    }
}
