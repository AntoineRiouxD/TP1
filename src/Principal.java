/*
 * Nom de classe : Principal
 *
 * Liste des m�thodes : listToTableau(), lireFichier()
 * 
 * Programmeur     : Simon Nolet et Antoine Rioux-Demers
 */

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Scanner;
import java.util.TimeZone;

public class Principal {

	private static Scanner scanner = new Scanner(System.in);
	private static ArrayList<String> listClients = new ArrayList<String>(); 
	private static ArrayList<String> listRepas = new ArrayList<String>();		
	private static ArrayList<String> listCommandes = new ArrayList<String>();
	
	public static void main(String[] args) {
		lireFichier();
		
		Commande commande = new Commande(listToTableau(listClients), 
				listToTableau(listRepas), listToTableau(listCommandes));
		
		commande.afficherErreurCommande();
		commande.afficherCommande();
		ecrireFichier(commande);
	}
	
	public static String[] listToTableau(ArrayList<String> list) {
		String[] tableauRetour = new String[list.size()];
		
		for (int i = 0; i < list.size(); i++) {
			tableauRetour[i] = list.get(i);
		}
		
		return tableauRetour;
	}
	
	public static void lireFichier() {
		System.out.println(" Entrez votre fichier de commandes! :");
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
					
					if(currentPlat.matches("^[a-zA-Z\\u00C0-\\u017F\\_\\-]+ \\d+.?\\d* *$")) {
						listRepas.add(currentPlat);
					} else if(currentPlat.contains("Commandes :")) {
						currentLine = currentPlat;
					} else {
						throw new EmptyStackException();
					}
				}
				
				while(currentLine.contains("Commandes :")) {
					String currentCommande = fichierBrute.nextLine();
					
					if(currentCommande.matches("^[a-zA-Z\\u00C0-\\u017F]+ [a-zA-Z\\u00C0-\\u017F\\_\\-]+ \\d+ *$")) {
						listCommandes.add(currentCommande);
					}else if(currentCommande.contains("Fin")) {
						currentLine = currentCommande;
					}else {
						throw new EmptyStackException();
					}
				}
			}
		
		} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Le fichier ne respecte pas le format demand� !");
		lireFichier();
		}
	
	}
	
	public static void ecrireFichier(Commande commande) {
		
		List<String> lines = Arrays.asList(commande.CommandetableauFichier());
		DateTimeFormatter timeStampPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH");
		Path file = Paths.get("Facture-du-" + timeStampPattern.format(java.time.LocalDateTime.now()) + "h.txt");
		
		try {
			Files.write(file, lines, StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	

	
}
