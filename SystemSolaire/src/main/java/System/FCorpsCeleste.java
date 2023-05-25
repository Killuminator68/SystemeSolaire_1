package System;

import org.json.JSONObject;

public class FCorpsCeleste {
	
	public static CorpsCeleste crerCoprsCeleste(ETypeCorpsCeleste type, JSONObject o, SystemeSolaire systemeSolaire) {
	    String nom = o.getString("nom");
	    double taille = o.getInt("taille");
	    double age = 0; // Vous pouvez définir l'âge en fonction de vos besoins
	    double temperature = 0; // Vous pouvez définir la température en fonction de vos besoins
	    String composition = o.getString("composition");

	    switch(type) {
	        case ETOILE -> {
	            int tempsRevolution = o.getInt("tempsRevolution");
	            int orbiteAutour = o.getInt("orbiteAutour");
	            JSONObject position = o.getJSONObject("position");
	            double x = position.getDouble("x");
	            double y = position.getDouble("y");
	            return new Etoile(nom, taille, age, temperature, composition, tempsRevolution, orbiteAutour, systemeSolaire, new Position(x, y));
	        }
	        case PLANETE -> {
	            int tempsRevolution = o.getInt("tempsRevolution");
	            int orbiteAutour = o.getInt("orbiteAutour");
	            JSONObject position = o.getJSONObject("position");
	            double x = position.getDouble("x");
	            double y = position.getDouble("y");
	            return new Planete(nom, taille, tempsRevolution, age, temperature, composition, orbiteAutour, systemeSolaire, new Position(x, y));
	        }
	        case SATELLITE -> {
	            int tempsRevolution = o.getInt("tempsRevolution");
	            int orbiteAutour = o.getInt("orbiteAutour");
	            JSONObject position = o.getJSONObject("position");
	            double x = position.getDouble("x");
	            double y = position.getDouble("y");
	            return new Satellite(nom, taille, tempsRevolution, age, temperature, composition, orbiteAutour, systemeSolaire, new Position(x, y));
	        }
	    }

	    return null;
	}
}