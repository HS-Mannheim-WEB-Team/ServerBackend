package schach.daten;

import java.util.Properties;

// Basis-Datencontainer
public class D {
	
	private Properties p = new Properties();
	
	public D() {
		addString("klasse", "" + this.getClass().getSimpleName());
	}
	
	public void addString(String name, String wert) {
		if (wert == null)
			wert = "";
		p.setProperty(name, wert);
	}
	
	public void addInt(String name, int wert) {
		p.setProperty(name, "" + wert);
	}
	
	public void addBool(String name, boolean wert) {
		p.setProperty(name, "" + wert);
	}
	
	public void setString(String name, String wert) {
		if (wert == null)
			wert = "";
		p.setProperty(name, wert);
	}
	
	public void setInt(String name, int wert) {
		p.setProperty(name, "" + wert);
	}
	
	public void incInt(String name) {
		if (!existKey(name))
			throw new RuntimeException("Daten incInt: Attribut existiert nicht!");
		int wert = Integer.parseInt(p.getProperty(name));
		wert++;
		p.setProperty(name, "" + wert);
	}
	
	public void decInt(String name) {
		if (!existKey(name))
			throw new RuntimeException("Daten decInt: Attribut existiert nicht!");
		int wert = Integer.parseInt(p.getProperty(name));
		wert--;
		p.setProperty(name, "" + wert);
	}
	
	public void setBool(String name, boolean wert) {
		p.setProperty(name, "" + wert);
	}
	
	public boolean existKey(String name) {
		return p.containsKey("" + name);
	}
	
	public String getString(String name) {
		return p.getProperty(name);
	}
	
	public int getInt(String name) {
		int ergebnis = 0;
		try {
			ergebnis = Integer.parseInt(p.getProperty(name));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Daten getInt: " + e.getMessage());
		}
		return ergebnis;
	}
	
	public boolean getBool(String name) {
		boolean ergebnis = false;
		try {
			ergebnis = Boolean.parseBoolean(p.getProperty(name));
		} catch (Exception e) {
			throw new RuntimeException("Daten getBool: " + e.getMessage());
		}
		return ergebnis;
	}
	
	public void setProperties(Properties p) {
		if (p == null)
			throw new RuntimeException("D Konstruktor: Properties duerfen nicht NULL sein!");
		this.p = p;
	}
	
	public Properties getProperties() {
		return p;
	}
	
	@Override
	public String toString() {
		return p.toString();
	}
	
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (!this.getClass().getSimpleName().equals(o.getClass().getSimpleName()))
			return false;
		D d = (D) o;
		return this.p.equals(d.p);
	}
	
	@Override
	public D clone() {
		try {
			@SuppressWarnings("unchecked")
			Class<D> c = (Class<D>) Class.forName(this.getClass().getName());
			D d = (D) c.newInstance();
			d.p = (Properties) this.p.clone();
			return d;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Daten clone: " + e.getMessage());
		}
	}
	
	public String toXml() {
		return (Xml.fromD(this));
	}
}
