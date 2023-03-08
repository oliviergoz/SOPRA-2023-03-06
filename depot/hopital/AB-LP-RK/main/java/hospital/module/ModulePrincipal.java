package hospital.module;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import hospital.dao.CompteDao;
import hospital.dao.CompteDaoImpl;
import hospital.dao.VisiteDao;
import hospital.model.Compte;
import hospital.model.Patient;
import hospital.model.Visite;

public class ModulePrincipal {
	
	Compte compte = new Compte();
	Set<Visite> visites = new HashSet<>();

	public ModulePrincipal() {
		
	}

	public void menuIdentification() {
		CompteDao compteDao = new CompteDaoImpl();
		String login = null;
		String password = null;
		String typeCompte = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------------Menu principal :--------------------");
		System.out.println("Identification :");
		System.out.println("Saisir login :");
		login = sc.nextLine();
		System.out.println("Saisir password :");
		password = sc.nextLine();
		if ((compteDao.findbyLogin(login).getLogin() == login) and (compteDao.findByPassword(password).getPassword() == password)) {
			compte = compteDao.findByLogin(login);
			System.out.println("Saisir type compte :");
			typeCompte = sc.nextLine();
			compte.setTypeCompte(typeCompte);
			compteDao.update(compte);
			if (typeCompte == "medecin") {
				menuMedecin();
			} else if (typeCompte == "secretaire") {
				menuSecretaire();
			} else {
				System.out.println("Entre un type de compte valide");
				menuIdentification();
			}
		} else {
			System.out.println("saisir un login et un password valide");
			menuIdentification();
		}
	}
	
	public void menuMedecin() {
		int directive = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------------Menu medecin :--------------------");
		System.out.println("");
		System.out.println("Que voulez vous faire ?");
		System.out.println("");
		System.out.println("Rendre la salle disponible : taper 1");
		System.out.println("Afficher la liste d'attente : taper 2");
		System.out.println("Afficher le prochain patient : taper 3");
		System.out.println("Sauvegarder la liste des visites : taper 4");
		System.out.println("Retour à l'identification : taper 5");
		directive = sc.nextInt();
		switch(directive) {
		case 1 : salleDispo(); menuMedecin(); break;
		case 2 : afficherAttente(); menuMedecin(); break;
		case 3 : afficherPatient(); menuMedecin(); break;
		case 4 : sauvegarderListe(); menuMedecin(); break;
		case 5 : menuIdentification(); break;
		default : System.out.println("Entrer une directive valide"); menuMedecin(); break;
		}
	}
	
	public void menuSecretaire() {
		int directive = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------------Menu Secretaire :--------------------");
		System.out.println("");
		System.out.println("Que voulez vous faire ?");
		System.out.println("");
		System.out.println("Ajouter un patient à la file d'attente : taper 1");
		System.out.println("Afficher la liste d'attente : taper 2");
		System.out.println("Partir en pause : taper 3");
		System.out.println("Afficher les visites d'un patient : taper 4");
		System.out.println("Retour à l'identification : taper 5");
		directive = sc.nextInt();
		switch(directive) {
		case 1 : ajouterPatient(); menuSecretaire(); break;
		case 2 : afficherAttente(); menuSecretaire(); break;
		case 3 : pause(); menuSecretaire(); break;
		case 4 : afficherVisites(); menuSecretaire(); break;
		case 5 : menuIdentification(); break;
		default : System.out.println("Entrer une directive valide"); menuSecretaire(); break;
		}
	}
	
	public void ajouterPatient() {
		AttenteDao attenteDao = new AttenteDao();
		String prenom;
		String nom;
		LocalDate date;
		Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("Entrer le nom du patient à ajouter :");
		nom = sc.nextLine();
		System.out.println("Entrer le prenom du patient à ajouter :");
		prenom = sc.nextLine();
		System.out.println("Entrer la date :");
		date = LocalDate.parse(sc.nextLine());
		attenteDao.insert(new Patient(prenom, nom), date);
	}
	
	public void pause() {
		System.out.println("");
		System.out.println("Secrétaire en pause, veuillez patienter.");
	}
	
	public void afficherVisites() {
		VisiteDao visiteDao = new VisiteDaoImpl();
		visiteDao.findByPatient.forEach(visite -> {
			System.out.println("Visite n° : "  + visite.getNumero() + " Coût : " + visite.getCout() + " Salle : " + visite.getSalle() + " Date : " + visite.getDate() + " Medecin : " + visite.getCompte.getPrenom() + " " + visite.getCompte.getNom());
		});
	}
	
	public void salleDispo() {
		AttenteDao attenteDao = new AttenteDao();
		double cout;
		String salle;
		LocalDate date;
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrer la date :");
		date = LocalDate.parse(sc.nextLine());
		System.out.println("Entrer la salle à rendre disponible:");
		salle = sc.nextLine();
		System.out.println("Entrer le coût de la visite :");
		cout = sc.nextDouble();
		visites.add(new Visite(cout, salle, date, attenteDao.getPatient1(), getCompte()));
		delete(attenteDao.getPatient1()); // faire une méthode afficherPatient dans attenteDao qui renvoie le premier de la liste avec order by date et limit 1
		if (visites.size() > 9) {
			sauvegarderListe();
			System.out.println("Dix visites atteintes.");
		}
	}
	
	public void afficherAttente() {
		AttenteDao attenteDao = new AttenteDao();
		attenteDao.findAll().forEach(patient ->{
			System.out.println(patient.getPrenom + " " + patient.getNom);
		});
	}
	
	
	public void afficherPatient() {// faire une méthode getPatient1 dans attenteDao qui renvoie le premier de la liste avec order by date et limit 1
		AttenteDao attenteDao = new AttenteDao();
		System.out.println(attenteDao.getPatient1().getPrenom + " " + attenteDao.getPatient1().getNom());
	}
	
	
	public void sauvegarderListe() {
		VisiteDao visiteDao = new VisiteDaoImpl();
		visites.forEach(visite -> {
			visiteDao.insert(visite);
		});
		System.out.println("La liste des visites à été sauvegardée.");
	}
	
	
	public Compte getCompte() {
		return compte;
	}
	
	
}
