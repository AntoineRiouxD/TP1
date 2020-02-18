



public class Commande {
	
	

	public static void main(String[] args) {
		
		String[] Clients = {"Roger", "Céline", "Steve"};
		String[] Repas = {"Poutine 10.5", "Frites 2.5", "Repas_Poulet 12.5"};
		String[] Commandes = {"Roger Poutine 1", "Céline Frites 2", "Céline Repas_Poulet 1"};
		
		afficherCommande(Clients, Repas, Commandes);

	}
	
	public static void afficherCommande(String[] Clients, String[] Repas, String[] Commandes) {
		
		String[] CommandeComplet = creerCommandeComplet(Clients, Repas, Commandes);
		
		System.out.println("Bienvenue chez Barrette!");
		
		for (int i = 0; i < CommandeComplet.length; i++) {
			System.out.println(CommandeComplet[i]);
		}
		
		
		
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
			
			CommandeComplet[i] = Clients[i] + " " +  df.format(prixTotal) + "$";
			
			
		}
		
		return CommandeComplet;
		
		
	}
	
	public static double getPrix(String repasCherche, String[] Repas) {
		
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
	



}