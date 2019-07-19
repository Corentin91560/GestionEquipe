package sample.Class;

import java.util.ArrayList;

public class Championnat {

    String division;
    String niveau;
    String nomdepreg;
    int idsport;
    int idchampionnat;
    ArrayList<Equipe> equipes;

    public Championnat() {
    }

    public Championnat(String niveau,String nomdepreg) {
        this.niveau = niveau;
        this.nomdepreg=nomdepreg;
    }

    public Championnat(String niveau, String nomdepreg, int idchampionnat) {
        this.niveau = niveau;
        this.nomdepreg = nomdepreg;
        this.idchampionnat = idchampionnat;
    }

    public Championnat(String division, String niveau, String nomdepreg, int idsport, int idchampionnat) {
        this.division = division;
        this.niveau = niveau;
        this.nomdepreg= nomdepreg;
        this.idsport = idsport;
        this.idchampionnat = idchampionnat;
    }

    @Override
    public String toString() {
        return "Championnat{" +
                "division='" + division + '\'' +
                ", niveau='" + niveau + '\'' +
                ", idsport=" + idsport +
                ", idchampionnat=" + idchampionnat +
                '}';
    }

    public ArrayList<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(ArrayList<Equipe> equipes) {
        this.equipes = equipes;
    }

    public String getNomdepreg() {
        return nomdepreg;
    }

    public void setNomdepreg(String nomdepreg) {
        this.nomdepreg = nomdepreg;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public int getIdsport() {
        return idsport;
    }

    public void setIdsport(int idsport) {
        this.idsport = idsport;
    }

    public int getIdchampionnat() {
        return idchampionnat;
    }

    public void setIdchampionnat(int idchampionnat) {
        this.idchampionnat = idchampionnat;
    }
}
