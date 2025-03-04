package ex3;

import java.util.*;
public class Livre {
	
	private String _titre;
	private String _auteurs[];
	private String _ISBN;
	private double _prix;
	
	Livre(String titre,String auteurs[],String ISBN,double prix)
	{
			_titre = titre;
			_auteurs = auteurs;
			_ISBN = ISBN;
			_prix = prix;
	}
	
	Livre(Livre livre)
	{
		_titre = livre._titre;
		_auteurs = livre._auteurs;
		_ISBN= livre._ISBN;
		_prix = livre._prix;
	}
	
	public String toString()
	{
		return _titre + " " + Arrays.toString(_auteurs) + " " + _ISBN+ " " + _prix ;
	}
	public boolean containsAuthor(String auteur) {
		//Si l'auteur ou le début de l'auteur est trouvé dans les auteurs du livre
		for(String a : _auteurs) {
			if(a.startsWith(auteur))
				return true;
		}
		return false;
	}
	
}
