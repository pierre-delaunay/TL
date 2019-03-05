package fr.istic.tl.tp2;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.istic.tl.tp2.*;

public class Parseur {

	
	public static File parseHtml(String nomFichier) throws IOException 
	{
		
		BufferedReader br = new BufferedReader(new FileReader(nomFichier));
		String line;
		String actual, dept, arro, canton, type, article, nom, divers;
		
		while ((line = br.readLine()) != null) {
			
			String regexLigne = "<tr>(.*)<\\/tr>";
			
			Pattern p = Pattern.compile(regexLigne);
			Matcher m = p.matcher(line);
			
	
			if (m.matches()) {
				
				System.out.println("Actual : " + m.group(1) );
				System.out.println("Chef lieu" + m.group(2) );
				
				
				
			}
	   
		   
		}
		
		br.close();
		
		return null;
	}
	
	public static File creerFichierSQL(ArrayList<LigneBDD> liste) throws FileNotFoundException, UnsupportedEncodingException {
		
		PrintWriter writer = new PrintWriter("requete.sql", "UTF-8");
		
		for(LigneBDD ligne : liste) {
			
			writer.println(ligne.toSQLrow() + "\r\n");
			
		}
		
		writer.close();	
		
		return null;
		
	}
	
	
	
}
