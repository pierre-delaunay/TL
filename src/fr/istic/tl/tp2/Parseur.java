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

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import fr.istic.tl.tp2.*;

public class Parseur {

	
	public static void parseHtml(String nomFichier) throws IOException 
	{
		BufferedReader br = new BufferedReader(new FileReader(nomFichier));
		String line;
		String actual, dept, arro, canton, type, article, nom, divers;
		
		final ArrayList<String> tagValues = new ArrayList<String>();
		
		while ((line = br.readLine()) != null) {
			
			// &eacute; = é
			// &nbsp; = espace
			
			String regexLigne = "<td>(.+?)<\\/td>";
			Pattern p = Pattern.compile(regexLigne);
			Matcher m = p.matcher(line);
			String concatTags = "";
			
			while (m.find()) {
				tagValues.add(m.group(1));
			} 
		}
		
		System.out.println(tagValues);
		
		br.close();
		
		//creerFichierSQL(tagValues);
	}
	
	public static void creerFichierSQL(ArrayList<LigneBDD> liste) throws FileNotFoundException, UnsupportedEncodingException {
		
		PrintWriter writer = new PrintWriter("requete.sql", "UTF-8");
		
		for(LigneBDD ligne : liste) {
			
			writer.println(ligne.toSQLrow() + "\r\n");
			
		}
		
		writer.close();	
		
	}
	
	
	
}
