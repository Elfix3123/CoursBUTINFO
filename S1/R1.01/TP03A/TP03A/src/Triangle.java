import java.lang.Math;

public class Triangle {
	// un triangle est défini par la longueur de chacun de ses côtés
	// Attributs
	float cote1; // longueur d'un côté
	float cote2; // longueur d'un autre côté
	float cote3; // longueur du troisième côté
	
	// Constructeur
	
	public Triangle(float cote1, float cote2, float cote3) {
		this.cote1 = cote1;
		this.cote2 = cote2;
		this.cote3 = cote3;
	}
	
	// méthodes
	// 1 - getters
	// 1.1 - Valeur de cote1
	public float getCote1() {
		return this.cote1;
	}
	// 1.2 - Valeur de cote2  - À DÉCOMMENTER ET COMPLÉTER
	
	public float getCote2() {
		return this.cote2;
	}
	
	// 1.3 - Valeur de cote3  - À DÉCOMMENTER ET COMPLÉTER
	public float getCote3() {
		return this.cote3;
	}
	
	// 2 - périmètre - À DÉCOMMENTER ET COMPLÉTER
	public float getPerimetre() {
		// { } => { résultat = périmètre de ce Triangle }
		return this.cote1 + this.cote2 + this.cote3;
	}
	
	//3 - surface - À DÉCOMMENTER ET COMPLÉTER
	public float getSurface() {
		// { } => { résultat = surface de ce Triangle }
		float p = (this.cote1 + this.cote2 + this.cote3)/2;
		return (float)Math.sqrt(p * (p - this.cote1) * (p - this.cote2) * (p - this.cote3));
	}
	
	//4 - nature - À DÉCOMMENTER ET COMPLÉTER
	public String getNature() {
		// { } => { résultat = nature de ce Triangle
			//           * rectangle si la somme des carrés de 2 côtés est égale au
			//             carré du 3ème côté
			//           * rectangle et isocèle s'il est rectangle et a deux côtés égaux
			//           * équilatéral si ses 3 côtés sont égaux
			//           * isocèle si 2 (et seulement 2) de ses côtés sont égaux
			//           * quelconque s'il n'est ni équilatéral, ni isocèle, ni rectangle }
			// NOTE : dans un plan, un triangle équilatéral ne peut pas être rectangle
			String nature = "";
			if ((this.cote1 == this.cote2)&(this.cote2 == this.cote3)){
				nature = " équilatéral";
			}
			else {
				if ((this.cote1 == this.cote2)|(this.cote2 == this.cote3)|(this.cote3 == this.cote1)){
					nature = " isocèle";
				}
				if((Math.pow(this.cote1, 2) + Math.pow(this.cote2, 2) == Math.pow(this.cote3, 2))|
				(Math.pow(this.cote2, 2) + Math.pow(this.cote3, 2) == Math.pow(this.cote1, 2))|
				(Math.pow(this.cote3, 2) + Math.pow(this.cote1, 2) == Math.pow(this.cote2, 2))){
					nature += " réctangle";
				}
			}
			if (nature.isEmpty()){
				nature = " quelconque";
			}
			return nature;
		}
		
		// Pour l'affichage des cotés, du périmètre et de la surface de ce Triangle
		// À DÉCOMMENTER ET NE PAS MODIFIER !!!
		public String toString() {
			return "Cotés : (" + cote1 + ", " + cote2 + ", " + cote3 + ") | Périmètre : " + getPerimetre() + " | Surface : " + getSurface() + " | Nature :" + getNature();
		}
	}
	