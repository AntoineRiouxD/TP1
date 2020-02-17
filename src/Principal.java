import java.awt.List;
import java.io.File;
import java.util.EmptyStackException;
import java.util.Scanner;

public class Principal {

	private static Scanner scanner = new Scanner(System.in);
	private static List listClients = new List(), 
			listCommandes = new List(), 
			listRepas = new List();
	
	public static void main(String[] args) {
		lireFichier();
	}
	
	public static void lireFichier() {
		System.out.println("Entrez votre fichier de commandes! :");
		String fichierPath = scanner.nextLine();
		try {
			File fichier = new File(fichierPath);
			
			Scanner fichierBrute = new Scanner(fichier);
			
			while (fichierBrute.hasNext()) {
				String currentLine = fichierBrute.nextLine();
				
				while(currentLine.contains("Clients :")) {
					String currentClient = fichierBrute.nextLine();
					
					if(currentClient.matches("^[a-zA-Z\\u00C0-\\u017F]+ *$")) {
						listClients.add(currentClient);
					} else if(currentClient.contains("Plats :")) {
						currentLine = currentClient;
					} else {
						throw new EmptyStackException();
					}
				}
				
				while(currentLine.contains("Plats :")) {
					String currentPlat = fichierBrute.nextLine();
					
					if(currentPlat.matches("^[a-zA-Z\\u00C0-\\u017F]+ \\d+\\.?\\d{0,2} *$")) {
						listRepas.add(currentPlat);
					} else if(currentPlat.contains("Plats :")) {
						currentLine = currentPlat;
					} else {
						throw new EmptyStackException();
					}
				}
				
				while(currentLine.contains("Commandes :")) {
					String currentCommande = fichierBrute.nextLine();
					
					if(currentCommande.matches("^[a-zA-Z\\u00C0-\\u017F]+ [a-zA-Z\\u00C0-\\u017F]+ \\d+ *$")) {
						listCommandes.add(currentCommande);
					} else {
						throw new EmptyStackException();
					}
				}
			}
		
		} catch (Exception e) {
		// TODO: handle exception
			System.out.println(e);
		System.out.println("Le fichier ne respecte pas le format demandé !");
		lireFichier();
		}
	
	}
}
