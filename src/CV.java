
public class CV {

	private String nom, prenom, formation, attentes;
	private String[] competences;
	private int experience;
	
	public CV(String nom, String prenom, String formation, 
			int experience, String[]competences, String attentes) {
		setNom(nom);
		setPrenom(prenom);
		setFormation(formation);
		setExperience(experience);
		setCompetences(competences);
		setAttentes(attentes);	
	}
	
	public static void afficher(CV cv) {
		System.out.println("\nPrénom : " + cv.getPrenom());
		System.out.println("Nom : " + cv.getNom());
		System.out.println("Formation : " + cv.getFormation());
		System.out.println("Experience (Années) : " + cv.getExperience());
		System.out.print("Competences : ");
		for (int i=0; i < cv.getCompetences().length ;i++) {
			System.out.print(cv.getCompetences()[i] + " / ");
		}
		System.out.println("");
		System.out.println("Attente(s) : " + cv.getAttentes());
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
	
	public void setExperience(int experiences) {
		this.experience = experiences;
	}
	
	public void setCompetences(String[] competences) {
		this.competences = competences;
	}
	
	public void setAttentes(String attentes) {
		this.attentes = attentes;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	
	public String getFormation() {
		return this.formation;
	}
	
	public int getExperience() {
		return this.experience;
	}
	
	public String[] getCompetences() {
		return this.competences;
	}
	
	public String getAttentes() {
		return this.attentes;
	}
}
