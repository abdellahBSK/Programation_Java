package ex3;

import java.util.*;

import tp1.Livre;

public class Bibliotheque {
    private int _maxLivre;
    private Livre[] _bibliotheque;
    private int _currentCount; 

    public Bibliotheque(int maxLivre) {
        _maxLivre = maxLivre;
        _bibliotheque = new Livre[maxLivre]; 
        _currentCount = 0; 
    }

    public int capacite() {
        return _maxLivre;
    }

    public boolean ajouteLivre(Livre livre) {
        if (_currentCount < _maxLivre) {
            _bibliotheque[_currentCount] = livre;
            _currentCount++; 
            return true;
        } else {
            return false; 
        }
    }
    
    public int size()
    {
    	return _currentCount;
    }
    
    public String toString()
    {
    	String str="";
    	for (Livre livre: _bibliotheque)
    	{
    		str += livre.toString() + "\n";
    	}
    	return str;
    }
    
    public Enumeration<Livre> cherche(String auteur) {
        Vector<Livre> v = new Vector<>();
        for (int i = 0; i < _currentCount; i++) {
            if (_bibliotheque[i].containsAuthor(auteur)) {
                v.addElement(_bibliotheque[i]);
            }
        }
        return v.elements();
    }
}













