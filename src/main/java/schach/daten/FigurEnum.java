package schach.daten;

public enum FigurEnum {
	Koenig,
	Dame,
	Turm,
	Laeufer,
	Springer,
	Bauer;
	
	public static FigurEnum toEnumFromString(String s) {
		if ((s == null) || (s.length() == 0))
			return null;
		return valueOf(s);
	}
	
	public static String toKuerzel(FigurEnum enumeration) {
		switch (enumeration) {
			case Bauer:
				return "B";
			case Dame:
				return "D";
			case Koenig:
				return "K";
			case Laeufer:
				return "L";
			case Springer:
				return "S";
			case Turm:
				return "T";
			default:
				throw new RuntimeException("toKuerzel: Enumeration ungueltig!");
		}
	}
}
