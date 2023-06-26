package ardoises;

import java.util.*;

import ardoise.Forme;
import ardoise.PointPlan;
import ardoise.Segment;

/*
Quadrilatère.java
SAE S201
Boulangeot Nathan  Meunier Alexandre
*/

//Début classe Quadrilatère

public class Quadrilatère extends Forme{

//	Variables d'instance
	
    private PointPlan p1;
    private PointPlan p2;
    private PointPlan p3;
    private PointPlan p4;

    
//	Constructeurs

	
//		Constructeur par défaut
    
    public Quadrilatère() {
    	
    	super.setNomForme("undefined");
		this.p1 = new PointPlan(0,0);
		this.p2 = new PointPlan(0,0);
		this.p3 = new PointPlan(0,0);
		this.p4 = new PointPlan(0,0);
		
    }

    
//	Constructeur personnalisé
//	On construit le quadrilatère à partir des points
    
    public Quadrilatère(String nom, PointPlan p1, PointPlan p2, PointPlan p3, PointPlan p4) {
    	
    	super(nom);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        
    }

    
//		Constructeur par copie du quadrilatère à partir d'une forme Quadrilatère

    
    public Quadrilatère(String nom, Forme f) throws ClassCastException {
		
//    	Le try-catch sert à vérifier si la forme à copier est bien un quadrilatère
    	
		try {
			Quadrilatère c = ((Quadrilatère)f);
			if(nom != f.getNomForme()) {
				super.setNomForme(nom);
				this.p1 = new PointPlan(c.getPoint(0).getAbscisse(), c.getPoint(0).getOrdonnee());
		        this.p2 = new PointPlan(c.getPoint(1).getAbscisse(), c.getPoint(1).getOrdonnee());
		        this.p3 = new PointPlan(c.getPoint(2).getAbscisse(), c.getPoint(2).getOrdonnee());
		        this.p4 = new PointPlan(c.getPoint(3).getAbscisse(), c.getPoint(3).getOrdonnee());
			}
		} catch(ClassCastException c) {
			System.out.println(c.toString() + "\nVeuillez rappeler le constructeur avec une Forme valide");
		}    
    }
    
//	Fin constructeurs
	
	
	
//	Méthodes d'accès


//		Retourne le point de l'indice donné
    
//		Exceptions:
//			IndexOutOfBoundsException si l'indice i est en dehors de la liste des PointPlans de la classe Quadrilatère

    public PointPlan getPoint(int i) throws IndexOutOfBoundsException{
		try {
			return this.getPoints().get(i);
		}catch(IndexOutOfBoundsException e){
			System.out.println(e.toString() + "\nL'indice est en dehors des points de " + super.getNomForme());
			return new PointPlan(0,0);
		}
	}
	
//		Fin méthode getPoint


//		Retourne la liste des points du quadrilatère (Cette méthode est privée car l'utilisateur de la classe Chapeau n'aura pas besoin de cette méthode qui est juste une question de simplicité pour les développeurs de la classe)

	
	private ArrayList<PointPlan> getPoints(){
		ArrayList<PointPlan> ps = new ArrayList<PointPlan>();
		ps.add(this.p1);
		ps.add(this.p2);
		ps.add(this.p3);
		ps.add(this.p4);
		return ps;
	}

//		Fin méthode getPoints


//		Définit un point avec un indice et ses coordonnées

//		Exceptions:
//			IndexOutOfBoundsException si l'indice i est en dehors de la liste des PointPlans de la classe Quadrilatère

	public void setPoint(int index, int x, int y) throws IndexOutOfBoundsException {
		try {
	        this.getPoint(index).setAbscisse(x);
	        this.getPoint(index).setOrdonnee(y);
		}catch(IndexOutOfBoundsException e) {
			System.out.println(e.toString() + "\nL'indice est en dehors des points de " + super.getNomForme());
		}
    }
	
//		Fin méthode setPoint


//		Retourne le nombre de points
	
	public int nbPoints() {
		return this.getPoints().size();
	}
	
//		Fin méthode nbPoints

	
	
//	Autres méthodes venant des méthodes abstraites de la classe Forme


//		Retourne une liste des segments qui dessinent le quadrilatère
	
	public ArrayList<Segment> dessiner(){
		ArrayList<Segment> list = new ArrayList<Segment>();
		Segment s1 = new Segment(this.p1, this.p2);
		list.add(s1);
		Segment s2 = new Segment(this.p2, this.p3);
		list.add(s2);
		Segment s3 = new Segment(this.p3, this.p4);
		list.add(s3);
		Segment s4 = new Segment(this.p4, this.p1);
		list.add(s4);
		return list;
	}
	
//		Fin de la méthode dessiner


//		Déplace le chapeau aux coordonnées données x et y
	
	public void deplacer(int x, int y) {
		
		System.out.println(" \nDéplacement de " + super.getNomForme());
		
		for(int i=0;i<this.nbPoints();i++){
			PointPlan p = this.getPoint(i);
			int a = p.getAbscisse();
			int o = p.getOrdonnee();
			p.setAbscisse(a+x);
			p.setOrdonnee(o+y);
			
		}
		System.out.println(this.toString());
		System.out.println("Fin du déplacement de " + super.getNomForme() + " \n");
		
	}
	
//		Fin de la méthode deplacer


//		Initialiser un quadrilatère avec le clavier

//		Exceptions:
//			InputMismatchException si ce n'est pas un nombre qui est entré

	
	public void init() throws InputMismatchException {
		
		try {
			Scanner sc = new Scanner(System.in);
	        System.out.println("nom");
	        String s = sc.nextLine();
	        super.setNomForme(s);
	        for(int i=0;i<this.nbPoints();i++) {
	        	System.out.println("point x de p" + (i+1));
	        	int x = sc.nextInt();
	        	System.out.println("point y de p" + (i+1));
	        	int y = sc.nextInt();
	        	this.setPoint(i, x, y);
	        }
	        System.out.println("Création du Chapeau " + super.getNomForme());
	        sc.close();
		}
		catch(InputMismatchException i) {
			System.out.println("Veuillez saisir un nombre");
		}
        
    }
	
//		Fin méthode init


//		Retourne true si la forme référencée est égale à la forme courante
	
	public boolean equals(Object o) {
		for(int i=0;i<this.nbPoints();i++) {
			PointPlan p = ((Chapeau)o).getPoint(i);
			if(!(this.getPoint(i).getAbscisse() == p.getAbscisse() 
				&& this.getPoint(i).getOrdonnee() == p.getOrdonnee())) {
				return false;
			}
		}
		return true;
	}
	
//		Fin méthode equals


//		Retourne une chaine de caracteres qui représente le quadrilatère
    
    public String toString() {
		String res = "";
		for(int i=0;i<this.nbPoints();i++){
			res += " \np" + (i+1) + " : " + this.getPoint(i);
			}
		return ("Nom : " + super.getNomForme() + "\nType : " + this.typeForme() + res);
	}
    
//		Fin de la méthode toString


//		Retourne le type de forme
    
    public String typeForme() {
        return "Q";
    }
    
//		Fin de la méthode typeForme
	
	
}

//Fin classe Quadrilatère