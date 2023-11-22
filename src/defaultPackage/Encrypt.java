package defaultPackage;

public class Encrypt {

	public String decimalBinari(int valorChar) {
		String binari = "";
		StringBuilder buildBinari = new StringBuilder();
		while (valorChar > 0) {
			int residu = valorChar % 2;
			buildBinari.insert(0, residu);
			valorChar = valorChar / 2;

		}
		binari = buildBinari.toString();

		String binariPos = "(";
		for (int i = 0; binari.length() > i; i++) {
			if (binari.charAt(i) == '1') {
				binariPos = binariPos + convertLletres(i);
			}
		}
		binariPos = binariPos + ")";
		int lenght = binari.length() - 1;
		binariPos = binariPos + convertLletres(lenght);
		return binariPos;
	}

	public char convertLletres(int i) {
		char lletra = 0;

		switch (i + 1) {
		case 1:
			lletra = 'p';
			break;
		case 2:
			lletra = 'a';
			break;
		case 3:
			lletra = 'k';
			break;
		case 4:
			lletra = 's';
			break;
		case 5:
			lletra = 'n';
			break;
		case 6:
			lletra = 'x';
			break;
		case 7:
			lletra = 'c';
			break;
		case 8:
			lletra = 'o';
			break;
		case 9:
			lletra = 'u';
			break;
		}
		return lletra;
	}

	public String encryptCesar(int clau, int valorChar) {
		String cadenaDesc = decimalBinari(valorChar);
		StringBuilder strBuild = new StringBuilder();
		int lenght = cadenaDesc.length();

		for (int i = 0; lenght > i; i++) {
			int valorChar1 = (int) cadenaDesc.charAt(i);
			valorChar1 = verifCesar(clau, valorChar1);
			strBuild.append(valorChar1);

		}
		String cadenaCod = strBuild.toString();
		return cadenaCod;

	}

	public int verifCesar(int clau, int valorChar1) {
		int result = 0;
		while (result == 0) {
			if (valorChar1 + clau <= 126) {
				result = valorChar1 + clau;
			} else {
				int residu = 126 - valorChar1;
				clau = clau - residu;
				valorChar1 = 31;
				while (valorChar1 + clau > 126) {
					if (31 + clau > 126)
						clau = clau - 95;
					else {
						valorChar1 = 31 + clau;
						result = valorChar1;
					}
				}
			}
		}

		return result;

	}

}
