package ardoises;

import java.util.*;

import ardoise.Forme;
import ardoise.PointPlan;
import ardoise.Segment;

/*
Maison.java
SAE S201
Boulangeot Nathan  Meunier Alexandre
*/

//Début classe Maison

public class Maison extends Forme{
	
//	Variables d'instance
	
	private Forme toit;
	private Forme corps;
	private Forme porte;
	
	
//	Constructeurs

	
//		Constructeur par défaut
	
	public Maison() {
		
		super.setNomForme("undefined");
		this.toit = new Chapeau();
		this.corps = new Quadrilatère();
		this.porte = new Quadrilatère();
	}
	
//	Constructeur personnalisé
//	On construit la maison à partir des formes
	
	public Maison(String nom, Forme toit, Forme corps, Forme porte) {
		
		super(nom);
		this.toit = toit;
		this.corps = corps;
		this.porte = porte;
	}
	
//	Constructeur par copie de la maison à partir d'une forme Maison


	public Maison(String nom, Forme m) {
		
		super(nom);
		Maison ma = ((Maison)m);	// Caste la maison en paramètre
		
		
		// Copie du toit
		
		Chapeau toitm = (Chapeau) ma.getForme(0);	// Caste le toit en Chapeau de la maison en paramètre
		Chapeau toitTemp = ((Chapeau) new Chapeau());  // Création d'un toit temporaire d'un chapeau
		
		for(int i=0;i<toitm.nbPoints();i++) {
			PointPlan pointm = toitm.getPoint(i);  // On prend le PointPlan i de la maison en paramètre
			toitTemp.setPoint(i, pointm.getAbscisse(), pointm.getOrdonnee());  // Pour copier l'abscisse et l'ordonnée du PointPlan i dans le toit temporaire
		}
		this.toit = new Chapeau(toitm.getNomForme(), toitTemp);  // On utilisera un constructeur par copie en mettant le toit temporaire
		
		 
		// Copie du corps
		
		Quadrilatère corpsm = (Quadrilatère) ma.getForme(1);
		Quadrilatère corpsTemp = ((Quadrilatère) new Quadrilatère());
		
		for(int i=0;i<corpsm.nbPoints();i++) {
			PointPlan pointm = corpsm.getPoint(i);
			corpsTemp.setPoint(i, pointm.getAbscisse(), pointm.getOrdonnee());
		}
		this.corps = new Quadrilatère(corpsm.getNomForme(), corpsTemp);
		
		
		// Copie de la porte
		
		Quadrilatère portem = (Quadrilatère) ma.getForme(2);
		Quadrilatère porteTemp = ((Quadrilatère) new Quadrilatère());
		
		for(int i=0;i<portem.nbPoints();i++) {
			PointPlan pointm = portem.getPoint(i);
			porteTemp.setPoint(i, pointm.getAbscisse(), pointm.getOrdonnee());
		}
		this.porte = new Quadrilatère(portem.getNomForme(), porteTemp);
	}
	
//	Fin constructeurs
	
	
	
//	Méthodes d'accès


//		Retourne la forme de l'indice donné
	
//		Exceptions:
//			IndexOutOfBoundsException si l'indice i est en dehors de la liste des Formes de la classe Maison

	public Forme getForme(int i) throws IndexOutOfBoundsException{
		try {
			return this.getFormes().get(i);
		}catch(IndexOutOfBoundsException e){
			System.out.println(e.toString() + "\nL'indice est en dehors des points de " + super.getNomForme());
			return null;
		}
		
	}
	
//		Fin méthode getForme

	
//		Retourne la liste des formes de la maison (Cette méthode est privée car l'utilisateur de la classe Chapeau n'aura pas besoin de cette méthode qui est juste une question de simplicité pour les développeurs de la classe)
	
	private ArrayList<Forme> getFormes(){
		
		ArrayList<Forme> ps = new ArrayList<Forme>();
		ps.add(this.toit);
		ps.add(this.corps);
		ps.add(this.porte);
		return ps;
	}

//		Fin méthode getFormes
	
	
//		Retourne la liste des formes de la maison
	
//		Exceptions:
//			IndexOutOfBoundsException si l'indice i est en dehors de la liste des Formes de la classe Maison
//			ClassCastException si la forme passé en paramètre n'est ni un Chapeau ni un Quadrilatère
	
	public void setForme(int i, Forme f) throws ClassCastException, IndexOutOfBoundsException {
		
		String s = f.typeForme();
		
		// On vérifie 
		
		if (i < 0 || i >= this.nbFormes()) {
            throw new IndexOutOfBoundsException("L'indice est en dehors des formes de " + super.getNomForme());
        }
		try {
			
			if(s== "T" || s== "GF") { 
				throw new ClassCastException();
			}
			if(i == 0 && f.typeForme() == "C") {
				this.toit = f;
			}
			else if(f.typeForme()=="Q"){
				if(i == 1) {
					this.corps = f;
				}
				else{
					this.porte = f;
				}
			}
			else {
				throw new ClassCastException();
			}
			
		}catch(ClassCastException e) {
			
			// Pour signaler qu'il y a une erreur
			
			System.out.println("!?!?!?!?!?!?!?!?!?!?!?! ERROR ?!?!?!?!?!?!?!?!?!?!");
		
			// Si ce n'est pas de la bonne forme
			
			String sfinal = "La forme maison ne contient pas de";
			
			if(s== "T") {
				System.out.println(sfinal + "triangle.");
			}
			else if(s== "GF"){
				System.out.println("La forme maison ne peut pas contenir elle-même une maison.");
			}
			
			// Si c'est la bonne forme mais pas du bon indice
			
			else {
				String stemp;
				if(s== "C") {
					stemp = "chapeau";
				}
				else {
					stemp = "Quadrilatère";
				}
				
				System.out.println(e + sfinal + stemp +  " sur la variable d'instance " + i + ".");
			}
		}
	}
	
//		Fin méthode setForme


//		Retourne le nombre de formes
	
	public int nbFormes() {
		return this.getFormes().size();
	}
	
//		Fin méthode nbPoints

	
	
//	Autres méthodes venant des méthodes abstraites de la classe Forme


//		Retourne une liste des segments qui dessinent la maison
	
	public ArrayList<Segment> dessiner() {
		
		ArrayList<Segment> list = new ArrayList<Segment>();
		for(int i=0;i<this.nbFormes();i++) {
			Forme f = this.getForme(i);
			ArrayList<Segment> d = f.dessiner();
			for(int e=0;e<d.size();e++) {
				list.add(d.get(e));
			}
		}
		
		return list;
	}
	
//		Fin de la méthode dessiner


//		Déplace le chapeau aux coordonnées données x et y
	
	public void deplacer(int x, int y) {
		
		System.out.println(" \nDéplacement de " + super.getNomForme() + "\n----------------------------->");
		
		this.toit.deplacer(x, y);
		this.corps.deplacer(x, y);
		this.porte.deplacer(x, y);
		
		System.out.println("<-----------------------------\n" + "Fin du déplacement de " + super.getNomForme() + " \n");
	}
	
//		Fin de la méthode deplacer


//		Retourne une chaine de caracteres qui représente le chapeau
	
	public String toString() {
		String res = "";
		for(int i=0;i<this.nbFormes();i++) {
			res += "\n" + this.getForme(i).toString() + "\n";
		}
		return ("Nom : " + super.getNomForme() + "\nType : " + this.typeForme() + "\n" + super.getNomForme() + " contient les formes suivantes:" + "\n-----------------------------" + res + "-----------------------------\n");
	}
	
//		Fin de la méthode toString


//		Retourne le type de forme
	
	public String typeForme() {
		return "GF";
	}
	
//		Fin de la méthode typeForme
	
	
}

//Fin classe Maison