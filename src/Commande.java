import java.io.*;



public class Commande {
	
	

	public static void main(String[] args) {
		
		

	}
	
	public void afficherCommande(String[] Clients, String[] Repas, String[] Commandes) {
		
		String[] CommandeComplet = new String[Commandes.length];
		
		System.out.println("Bienvenue chez Barrette!");
		
		for (int i = 0; i < CommandeComplet.length; i++) {
			System.out.println(CommandeComplet[i] + "$");
		}
		
		
		
	}
	
	public static String[] creerCommandeComplet (String[] Clients, String[] Repas, String[] Commandes) {
		String[] CommandeComplet = new String[Clients.length];
		boolean present = false;
		double prixTotal = 0;
		
		for (int i = 0; i < Clients.length; i++) {
			
			String[] CommandeChoisi = new String[3];
			
			for (int j = 0; j < Commandes.length && present == false; j++) {
				CommandeChoisi = Commandes[j].split(" ", 3);
				
				if (Clients[i].equals(CommandeChoisi[0])) {
					
					//rendu ici
					
					
				}
				
			}
		}
		
		
	}
	
	public static double getPrix(String repasCherche, String[] Repas) {
		
		double prix = 0;
		boolean trouver = false;
		
		
		for (int i = 0; i < Repas.length && trouver == false; i++) {
			if (Repas[i].equals(repasCherche)) {
				
				String[] repasChoisi = Repas[i].split(" ", 2);
				prix = Double.parseDouble(repasChoisi[1]);
				
				trouver = true;
			}
		}
		

		
		return prix;
		
	}
	



}