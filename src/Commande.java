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
	
	private static String[] creerCommandeComplet (String[] Clients, String[] Repas, String[] Commandes) {
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
	



}