/*
 * Nom de classe : Commande
 *
 * Liste des méthodes : afficherCommande(), creerCommandeComplet(), getPrix()
 * 
 * Programmeur     : Simon Nolet et Antoine Rioux-Demers
 */

public class Commande {
	
	private String[] clients, repas, commandes;
	
	public Commande(String[] clients, String[] repas, String[] commandes) {
		
		this.clients = clients;
		this.repas = repas;
		this.commandes = commandes;
	}
	
	public void afficherCommande() {
		
		String[] CommandeComplet = creerCommandeComplet(this.clients, this.repas, this.commandes);
		
		System.out.println("Bienvenue chez Barrette!\nFactures:");
		
		for (int i = 0; i < CommandeComplet.length; i++) {
			System.out.println(CommandeComplet[i]);
		}
	}
	
	public void afficherErreurCommande() {
		
		
		
		System.out.println("Voici les erreurs du fichiers:");
		
		TrouverErreur(this.clients, this.repas, this.commandes);
	}
	
	public String[] CommandetableauFichier() {
		
		String[] CommandeComplet = creerCommandeComplet(this.clients, this.repas, this.commandes);
		
		return CommandeComplet;
	}
	
	public String[] TrouverErreur(String[] Clients, String[] Repas, String[] Commandes) {
		
		boolean ClientIncorrect;
		boolean PlatIncorrect;
		String[] TabErreurs = new String[Clients.length + Repas.length];
		
		for (int i = 0; i < Clients.length; i++) {			
			String[] CommandeChoisi = new String[3];
			ClientIncorrect = true;
			
			for (int j = 0; j < Commandes.length && ClientIncorrect; j++) {
				
				CommandeChoisi = Commandes[j].split(" ", 3);
				
				if (CommandeChoisi[0].contains(Clients[i])) {			
						ClientIncorrect = false;						
				}			
			}
			
			if (ClientIncorrect) {
				System.out.println("Le client " + CommandeChoisi[0] + " n'existe pas" );
				
			}
					
		}
		
		String[] RepasChoisi;
		for (int i = 0; i < Repas.length; i++) {			
			String[] CommandeChoisi = new String[3];
			RepasChoisi = Repas[i].split(" ", 2);
			PlatIncorrect = true;
			
			for (int j = 0; j < Commandes.length && PlatIncorrect; j++) {
				CommandeChoisi = Commandes[j].split(" ", 3);
				
				if (CommandeChoisi[1].contains(RepasChoisi[0])) {			
						PlatIncorrect = false;						
				}			
			}
			
			if (PlatIncorrect) {
				System.out.println("Le repas " + CommandeChoisi[1] + " n'existe pas" );
				
			}
					
		}
		
		return TabErreurs;
	}
	
	public static String[] creerCommandeComplet (String[] Clients, String[] Repas, String[] Commandes) {
		String[] CommandeComplet = new String[Clients.length];
		java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
		double prixTotal;
		
		for (int i = 0; i < Clients.length; i++) {			
			String[] CommandeChoisi = new String[3];
			prixTotal = 0;
			
			for (int j = 0; j < Commandes.length; j++) {
				CommandeChoisi = Commandes[j].split(" ", 3);
				
				if (Clients[i].contains(CommandeChoisi[0])) {			
					prixTotal += getPrix(CommandeChoisi[1], Repas) * Integer.parseInt(CommandeChoisi[2]);							
				}			
			}		
			CommandeComplet[i] = Clients[i] + " " +  df.format(ajoutTaxes(prixTotal)) + "$";		
		}		
		return CommandeComplet;		
	}
	
	private static double getPrix(String repasCherche, String[] Repas) {	
		double prix = 0;
		boolean trouver = false;
				
		for (int i = 0; i < Repas.length && trouver == false; i++) {
			if (Repas[i].contains(repasCherche)) {				
				String[] repasChoisi = Repas[i].split(" ", 2);
				prix = Double.parseDouble(repasChoisi[1]);
				
				trouver = true;
			}
		}
		return prix;	
	}
	
	private static double ajoutTaxes(double prixTotal) {	
		
		double prixTaxes;
		double TPS;
		double TVQ;
		
				
		TPS = (prixTotal * 5) / 100;
		TVQ = (prixTotal * 9.975) / 100;
		prixTaxes = prixTotal + TPS + TVQ;
		
		return prixTaxes;	
	}
	



}