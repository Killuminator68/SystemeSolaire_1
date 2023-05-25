package System;

public abstract class CorpsCeleste {
    private String nom;
    private double taille; // En kilomètres
    private double age; // En milliards d'années
    protected int idOrbiteCorpsCeleste;
    protected SystemeSolaire systemeSolaire;
    protected Position position;

    public CorpsCeleste(String nom, double taille, double age, int idOrbiteCorpsCeleste, SystemeSolaire systemeSolaire, Position position) {
        this.nom = nom;
        this.taille = taille;
        this.age = age;
        this.idOrbiteCorpsCeleste = idOrbiteCorpsCeleste;
        this.systemeSolaire = systemeSolaire;
        this.position = position;
    }
    // Getters et setters
    
    public int getIdOrbiteCorpsCeleste() {
        return idOrbiteCorpsCeleste;
    }

    public void setIdOrbiteCorpsCeleste(int idOrbiteCorpsCeleste) {
        this.idOrbiteCorpsCeleste = idOrbiteCorpsCeleste;
    }

    // ... autres getters et setters ...
    
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Nom: " + nom + "\n" +
               "Taille: " + taille + " km\n" +
               "Age: " + age + " milliards d'années\n";
    }
    
    public Position getPosition() {
        return position;
    }

    public String getNom() {
        return nom;
    }
}
