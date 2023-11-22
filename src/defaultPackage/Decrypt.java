package defaultPackage;

public class Decrypt {

	public String decryptCesar(int clau, String cadena) {
		int lenght = cadena.length();
		String cadenaFinal = "";
		StringBuilder strBuild = new StringBuilder();
		int cont = 0;

		while (lenght > cont) {
			strBuild.append(cadena.charAt(cont));
			int intCadena = deStrBuildAint(strBuild);
			while (intCadena < 32 || intCadena > 126) {
				cont++;
				strBuild.append(cadena.charAt(cont));
				intCadena = deStrBuildAint(strBuild);
			}
			int decryptCesar = verifCesarDecrypt(clau, intCadena);
			cadenaFinal = cadenaFinal + decryptCesar;
			cont++;
			strBuild.setLength(0);

		}

		return cadenaFinal;
	}

	public int verifCesarDecrypt(int clau, int intCadena) {
		int result = 0;
		while (result == 0) {
			if (intCadena - clau >= 32) {
				result = intCadena - clau;
			} else {
				int residu = intCadena - 32;
				clau = clau - residu;
				intCadena = 127;
				while (intCadena - clau < 32) {
					if (127 - clau < 32)
						clau = clau - 95;
					else {
						intCadena = 127 - clau;
						result = intCadena;
					}
				}
			}
		}

		return result;
	}

	public int deStrBuildAint(StringBuilder strBuild) {
		String cadena = strBuild.toString();
		int intCadena = Integer.parseInt(cadena);
		return intCadena;

	}

	public String CesarAchar(String cesar) {
		String resultat = "";
		StringBuilder strBuild = new StringBuilder();

		for (int i = 0; cesar.length() > i; i++) {
			strBuild.append(cesar.charAt(i));
			int numCadena = deStrBuildAint(strBuild);
			while (numCadena < 32 || numCadena > 126) {
				i++;
				strBuild.append(cesar.charAt(i));
				numCadena = deStrBuildAint(strBuild);
			}
			char lletra = (char) numCadena;
			resultat = resultat + lletra;
			strBuild.setLength(0);

		}
		return resultat;
	}

	public String deLletraAnum(String cadena) {
		String resultat = "";
		int num = 0;
		for (int i = 0; cadena.length() > i; i++) {
			char lletra = cadena.charAt(i);
			if (Character.isLetter(lletra)) {
				switch (lletra) {
				case 'p':
					num = 1;
					break;
				case 'a':
					num = 2;
					break;
				case 'k':
					num = 3;
					break;
				case 's':
					num = 4;
					break;
				case 'n':
					num = 5;
					break;
				case 'x':
					num = 6;
					break;
				case 'c':
					num = 7;
					break;
				case 'o':
					num = 8;
					break;
				case 'u':
					num = 9;
					break;
				}
				resultat = resultat + num;
				num = 0;
			} else {
				resultat = resultat + lletra;
			}

		}
		return resultat;
	}

	public String creacioBinari(String cadena) {
		int lenghtBinari = verifLenghtBinari(cadena);
		StringBuilder strBuild = new StringBuilder();
		int i = 1, verif = 1;
		while (lenghtBinari != 0) {
			if (Character.getNumericValue(cadena.charAt(i)) == verif) {
				strBuild.append("1");
				lenghtBinari--;
				i++;
				verif++;
			} else if (Character.getNumericValue(cadena.charAt(i)) != i) {
				strBuild.append("0");
				lenghtBinari--;
				verif++;
			}
		}
		String resultat = strBuild.toString();
		return resultat;

	}

	public int verifLenghtBinari(String cadena) {
		int cont = 0;
		for (int i = cont; cadena.length() > i; i++) {
			if (cadena.charAt(i) == 41) {
				break;
			} else {
				cont++;
			}
		}
		cont += 1;
		int resultat = Character.getNumericValue(cadena.charAt(cont));
		return resultat;

	}

	public char binariDecimal(String cadena) {
		double elevat = 0;
		double resultat = 0;
		double resultatFinal = 0;
		int lenght = cadena.length() - 1;
		for (int i = 0; cadena.length() > i; i++) {
			double num = Character.getNumericValue(cadena.charAt(lenght - i));
			resultat = num * (Math.pow(2, elevat));
			resultatFinal = resultatFinal + resultat;
			elevat += 1;

		}
		int conversioFinal = (int) resultatFinal;
		char lletra = (char) conversioFinal;
		return lletra;
	}

	public String removeLletres(String cadena) {
		StringBuilder strBuild = new StringBuilder();
		strBuild.append(cadena);
		int start = 0, end, cont = 0;
		while (cadena.charAt(cont) != 41) {
			cont++;
		}
		end = cont + 2;
		strBuild.delete(start, end);
		String result = strBuild.toString();
		return result;

	}

}
