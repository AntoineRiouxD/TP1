
public class CV {

	private String nom, prenom, formation, attentes;
	private String[] competences;
	private int experiences;
	
	public CV(String nom, String prenom, String formation, 
			int experiences, String[]competences, String attentes) {
		setNom(nom);
		setPrenom(prenom);
	}
	
	public static void afficher(CV cv) {
		
	}
	public static void main(String[] args) {
		System.out.println("Bienvenue chez Barrette!");
		
		String[] competencesAntoine = {"Programmation"};
		CV cvAntoine = new CV("Rioux", "Antoine", "DEP", '1' , competencesAntoine, "Aucune attentes");
		String[] competenceSimon = {"Programmation", "Soutiens informatique"};
		CV cvSimon = new CV("Nolet", "Simon", "DEP", '1', competenceSimon, "Souhaite apprendre");
		
		afficher(cvAntoine);
		afficher(cvSimon);
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
