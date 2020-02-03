
public class CV {

	private String nom, prenom, formation, attentes;
	private String[] competences;
	private int experiences;
	
	public CV(String nom, String prenom, String formation, 
			int experiences, String[]competences, String attentes) {
		setNom(nom);
		setPrenom(prenom);
	}
	
	public static void main(String[] args) {
		
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public void setFormation(String formation) {
		this.formation = formation;
	}
	
	public void setExperiences(int experiences) {
		this.experiences = experiences;
	}
	
	public void setCompetences(String[] competences) {
		this.competences = competences;
	}
	
	public void setAttentes(String attentes) {
		this.attentes = attentes;
	}
}
