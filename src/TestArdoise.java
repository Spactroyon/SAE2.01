import ardoise.*;
import ardoises.*;


public class TestArdoise {

	public static void main(String[] args) throws InterruptedException{
		
		
		Ardoise ardoise = new Ardoise();
		
		// Affichage de l'ardoise
		
		ardoise.dessinerGraphique();
		
		
		
		// Oiseau 1
		
		PointPlan o1p1 = new PointPlan(118,13);
		PointPlan o1p2 = new PointPlan(123,20);
		PointPlan o1p3 = new PointPlan(128,13);
		
		Forme Oiseau1 = new Chapeau("Oiseau 1", o1p1, o1p2, o1p3);
		
		ardoise.ajouterForme(Oiseau1);
		
		
		
		// Oiseau 2
		
		PointPlan o2p1 = new PointPlan(133,30);
		PointPlan o2p2 = new PointPlan(136,32);
		PointPlan o2p3 = new PointPlan(138,30);
		
		Forme Oiseau2 = new Chapeau("Oiseau 2", o2p1, o2p2, o2p3);
		
		ardoise.ajouterForme(Oiseau2);
		
		
		
		// Oiseau 3
		
		PointPlan o3p1 = new PointPlan(142,14);
		PointPlan o3p2 = new PointPlan(144,17);
		PointPlan o3p3 = new PointPlan(146,14);
		
		Forme Oiseau3 = new Chapeau("Oiseau 3", o3p1, o3p2, o3p3);
		
		ardoise.ajouterForme(Oiseau3);
		
		
		
		// Tour
        
        PointPlan tp1 = new PointPlan(9,100);
        PointPlan tp2 = new PointPlan(20,100);
        PointPlan tp3 = new PointPlan(20,198);
        PointPlan tp4 = new PointPlan(9,198);
        
        Forme Tour = new Quadrilatère("Tour",tp1, tp2, tp3, tp4);
        
        ardoise.ajouterForme(Tour);
        
        
        
        // Corps maison
        
        PointPlan cmp1 = new PointPlan(80,140);
        PointPlan cmp2 = new PointPlan(180,140);
        PointPlan cmp3 = new PointPlan(180,198);
        PointPlan cmp4 = new PointPlan(80,198);
        
        Forme CorpsMaison = new Quadrilatère("CorpsMaison",cmp1, cmp2, cmp3, cmp4);
        
        ardoise.ajouterForme(CorpsMaison);
        
        
        
        // Toit maison
        
        PointPlan tmp1 = new PointPlan(80,140);
        PointPlan tmp2 = new PointPlan(130,100);
        PointPlan tmp3 = new PointPlan(180,140);
        
        Forme ToitMaison = new Chapeau("ToitMaison", tmp1, tmp2, tmp3);
            
        ardoise.ajouterForme(ToitMaison);
        

        
        
        // Porte maison
        
        PointPlan pmp1 = new PointPlan(120,170);
        PointPlan pmp2 = new PointPlan(140,170);
        PointPlan pmp3 = new PointPlan(140,198);
        PointPlan pmp4 = new PointPlan(120,198);
        
        Forme PorteMaison = new Quadrilatère("PorteMaison",pmp1, pmp2, pmp3, pmp4);
        
        ardoise.ajouterForme(PorteMaison);
		
                
		
		// Branche 1
		
		PointPlan b1p1 = new PointPlan(170,52);
		PointPlan b1p2 = new PointPlan(173,45);
		PointPlan b1p3 = new PointPlan(177,52);
										
		Forme Branche1 = new Chapeau("Branche 1", b1p1, b1p2, b1p3);
										
		ardoise.ajouterForme(Branche1);
				
				

				
		// Branche 2
				
		PointPlan b2p1 = new PointPlan(177,52);
		PointPlan b2p2 = new PointPlan(184,57);
		PointPlan b2p3 = new PointPlan(177,60);
												
		Forme Branche2 = new Chapeau("Branche 2", b2p1, b2p2, b2p3);
												
		ardoise.ajouterForme(Branche2);
				
				
				
		// Branche 3
				
		PointPlan b3p1 = new PointPlan(177,60);
		PointPlan b3p2 = new PointPlan(174,66);
		PointPlan b3p3 = new PointPlan(170,60);
														
		Forme Branche3 = new Chapeau("Branche 3", b3p1, b3p2, b3p3);
														
		ardoise.ajouterForme(Branche3);
						
					
		// Branche 4
					
		PointPlan b4p1 = new PointPlan(170,60);
		PointPlan b4p2 = new PointPlan(164,57);
		PointPlan b4p3 = new PointPlan(170,52);
														
		Forme Branche4 = new Chapeau("Branche 4", b4p1, b4p2, b4p3);
														
		ardoise.ajouterForme(Branche4);
		
		
		
		// Montagne 1
		
		PointPlan m1p1 = new PointPlan(13,14);
		PointPlan m1p2 = new PointPlan(43,3);
		PointPlan m1p3 = new PointPlan(112,14);
				
		Forme Montagne1 = new Triangle("Montagne 1", m1p1, m1p2, m1p3);
				
		ardoise.ajouterForme(Montagne1);	
		

		// Montagne 2
		
		PointPlan m2p1 = new PointPlan(152,7);
		PointPlan m2p2 = new PointPlan(166,3);
		PointPlan m2p3 = new PointPlan(172,7);
						
		Forme Montagne2 = new Triangle("Montagne 2", m2p1, m2p2, m2p3);
						
		ardoise.ajouterForme(Montagne2);
		
		
		
		
		// Phase 2 question 4 :
			
//		Thread.sleep(1000);
//		ardoise.deplacer("", 0, 0);
//		
//		Oiseau1.deplacer(10, 20);
//		Oiseau2.deplacer(10, 20);
//		Oiseau3.deplacer(10, 20);
		
		
		// Liste de situations pouvant provoquer des erreurs
		
//			Forme f = new Chapeau("ex", Tour); // Tour est un quadrilatère et pas un chapeau
//			
//			((Chapeau)Oiseau1).getPoint(42); // Indice trop grand
//			
//			((Quadrilatère)Tour).setPoint(8, 20, 20); // Indice trop grand
//		
//			Forme TestMaison = new Maison("TestMaison",  ToitMaison, CorpsMaison, PorteMaison);
//			((Maison)TestMaison).setForme(2, Branche1); // L'indice 2 de la maison doit être un quadrilatère
		
		// Tests de méthodes:
		
		
		
			// Constructeur par copie ( Ne pas remettre en commentaire car utile pour la suite sauf les déplacements des oiseaux)
		
//				Forme Oiseau4 = new Chapeau("Oiseau 4", Oiseau1);
//				ardoise.ajouterForme(Oiseau4);
			
//				// Déplacement de l'oiseau 1
//				
//				Thread.sleep(1000);
//				ardoise.deplacer("", 0, 0);
//				Oiseau1.deplacer(-50, 20);
//				
//				// Déplacement de l'oiseau 4
//				
//				Thread.sleep(1000);
//				ardoise.deplacer("", 0, 0);
//				Oiseau4.deplacer(40, 10);
		
		
		
			// getPoint (Regarder dans la console)
				
//				System.out.println("Premier PointPlan de ToitMaison :" + ((Chapeau)ToitMaison).getPoint(1));
//				System.out.println(((Chapeau)ToitMaison).getPoint(15)); // Doit retourner un message d'erreur
	


			// setPoints
	
//				Thread.sleep(1000);
//				ardoise.deplacer("", 0, 0);
//				((Chapeau)ToitMaison).setPoint(0, 80, 80);
//				
//				Thread.sleep(1000);
//				ardoise.deplacer("", 0, 0);
//				((Chapeau)ToitMaison).setPoint(2, 180, 80);
//				
//				Thread.sleep(1000);
//				ardoise.deplacer("", 0, 0);
//				((Chapeau)ToitMaison).setPoint(1, 130, 40);
		
		
		
			// Init :
				
//				// Création d'un Chapeau avec le constructeur vide
//				Forme c = new Chapeau();
//				
//				// Initialisation du Chapeau créée
//				((Chapeau)c).init();
//				
//				ardoise.ajouterForme(c);
				
				

		
			// equals (Regarder dans la console)
			
//				System.out.println(Oiseau1.equals(Oiseau4));
			
		
		
			// Constructeur personnalisé de la classe Maison ( Ne pas remettre en commentaire)
		
//				Forme Maison1 = new Maison("Maison1", ToitMaison, CorpsMaison, PorteMaison);
//				ardoise.ajouterForme(Maison1);
		
		
		
			// Constructeur par copie de la classe Maison ( Ne pas remettre en commentaire)
		
//		        Forme Maison2 = new Maison("Maison2", Maison1);
//				ardoise.ajouterForme(Maison2);
//				
//				// Déplacement n°1 de la maison 1 
//				
//				Thread.sleep(1000);
//				ardoise.deplacer("", 0, 0);
//				Maison1.deplacer(-40, -80);
//				
//				// Déplacement de la maison 2
//				
//				Thread.sleep(1000);
//				ardoise.deplacer("", 0, 0);
//				Maison2.deplacer(30, 0);
//				
//				// Déplacement de la Tour pour la suite
//				
//				Thread.sleep(1000);
//				ardoise.deplacer("", 0, 0);
//				Tour.deplacer(85, 0);
				
		
		
		
			// setForme
			
//				Forme ToitMaison2 = new Chapeau("ToitMaison2", ToitMaison);
//				ardoise.ajouterForme(ToitMaison2);
//				
//				((Maison)Maison1).setForme(0, ToitMaison2);
//				
//				((Maison)Maison2).setForme(0, Maison2); // Doit retourner un message d'erreur
//				
//				
//				// Déplacement n°2 de la maison 1 
//				
//				Thread.sleep(1000);
//				ardoise.deplacer("", 0, 0);
//				Maison1.deplacer(-50, 80);
//				
//				// Déplacement du 2eme toit de la maison 1
//				
//				Thread.sleep(1000);
//				ardoise.deplacer("", 0, 0);
//				ToitMaison2.deplacer(40, -40);
//				
//				// Explication :
//				//		Le toit de la maison 1 a été changé par le 2eme toit instancié
//				// 		Puis le toit d'origine de la maison 1 est resté sur la position du 2eme mouvement de la maison 1 car il a été remplacé par l'autre
//				// 		Puis la maison 1 se deplace en bas à gauche
//				// 		Et enfin le 2eme toit qui appartient à la maison a été déplacé vers le haut ( Le toit vert du bas ). Le toit vert du haut est celui d'origine de la maison 1 qui n'a plus bougé depuis
		
		
		// Fin des tests de méthodes
	}
}

// Fin de la classe TestArdoise
