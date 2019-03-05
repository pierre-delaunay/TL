package fr.istic.tl.tp2;

public class LigneBDD {

	private String actual;
	private String dept;
	private String arro;
	private String canton;
	private String type;
	private String article;
	private String nom;
	private String divers;
	
	public LigneBDD(String actual, String dept, String arro, String canton, String type, String article, String nom, String divers) {
		this.actual = actual;
		this.dept = dept;
		this.arro = arro;
		this.canton = canton;
		this.type = type;
		this.article = article;
		this.nom = nom;
		this.divers = divers;
	}
	
	public String toSQLrow() {
		
		String str = "";
		
		String insee = dept + arro;
		
		str = "INSERT INTO table VALUES (" + insee + ", ";
		str += dept + ", ";
		str += arro + ", ";
		str += canton + ", ";
		str += type + ", ";
		str += article + ", ";
		str += nom + ", ";
		str += divers + ");";
		
		return str;
	}
	
}
