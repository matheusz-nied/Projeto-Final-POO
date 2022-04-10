import java.io.*;
import java.util.ArrayList;

public final class FileUtil {
	
	static String pathDAT = "/home/sehmer/Documents/EMC/Orientacao_Objetos/Projeto_Final/praticantes_jiu_jitsu.dat";

	public static void criaArquivosSeNaoExistem() throws IOException {

		File arquivoDAT = new File(pathDAT);

		if (arquivoDAT.exists()) {
			return;
		} else {
			arquivoDAT.createNewFile();

			ArrayList<Praticante_Jiu_Jitsu> listaPraticantes_Jiu_Jitsu = new ArrayList<Praticante_Jiu_Jitsu>();

			listaPraticantes_Jiu_Jitsu.add(new Professor("Mestre Pimenta", "Preta", 4, 500.0));

			FileOutputStream arquivoGrava = new FileOutputStream(pathDAT);
			ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrava);

			objGravar.writeObject(listaPraticantes_Jiu_Jitsu);

			objGravar.writeObject(listaPraticantes_Jiu_Jitsu);
			objGravar.flush();
			objGravar.close();
			arquivoGrava.flush();
			arquivoGrava.close();
		}

	}

	public static void readArquivoDAT() throws IOException, ClassNotFoundException {
		
		FileInputStream arquivoLeitura = new FileInputStream(pathDAT);
		ObjectInputStream objLeitura = new ObjectInputStream(arquivoLeitura);
		System.out.println(objLeitura.readObject());
		objLeitura.close();
		arquivoLeitura.close();
	}

	public static ArrayList<Praticante_Jiu_Jitsu> getDataArquivoDAT() throws IOException, ClassNotFoundException {
		ArrayList<Praticante_Jiu_Jitsu> listaPraticantes_Jiu_Jitsu = new ArrayList<Praticante_Jiu_Jitsu>();
		FileInputStream arquivoLeitura = new FileInputStream(pathDAT);
		ObjectInputStream objLeitura = new ObjectInputStream(arquivoLeitura);

		listaPraticantes_Jiu_Jitsu.addAll((ArrayList<Praticante_Jiu_Jitsu>) objLeitura.readObject());
		objLeitura.close();
		arquivoLeitura.close();
		;

		return listaPraticantes_Jiu_Jitsu;

	}

	public static void writeArquivoDAT(Praticante_Jiu_Jitsu jiu_jiteiro) throws IOException, ClassNotFoundException, PraticanteNotFoundException, PraticanteJaCadastradoException {

		
		ArrayList<Praticante_Jiu_Jitsu> listaPraticantes_Jiu_Jitsu = new ArrayList<Praticante_Jiu_Jitsu>();

		listaPraticantes_Jiu_Jitsu.addAll(getDataArquivoDAT());

		listaPraticantes_Jiu_Jitsu.add(jiu_jiteiro);

		FileOutputStream arquivoGrava = new FileOutputStream(pathDAT);
		ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrava);

		objGravar.writeObject(listaPraticantes_Jiu_Jitsu);

		objGravar.writeObject(listaPraticantes_Jiu_Jitsu);
		objGravar.flush();
		objGravar.close();
		arquivoGrava.flush();
		arquivoGrava.close();
		System.out.println("Objeto gravado com sucesso!");
	}

	public static Praticante_Jiu_Jitsu consultaPraticante_Jiu_Jitsu(String nome)
			throws ClassNotFoundException, IOException, PraticanteNotFoundException {
		ArrayList<Praticante_Jiu_Jitsu> listaPraticantes_Jiu_Jitsu = new ArrayList<Praticante_Jiu_Jitsu>();

		listaPraticantes_Jiu_Jitsu.addAll(getDataArquivoDAT());

		boolean encontrado = false;

		Praticante_Jiu_Jitsu jiu_jiteiro = null;
		for (Praticante_Jiu_Jitsu j : listaPraticantes_Jiu_Jitsu) {
			if (nome.contains(j.nome)) {
				jiu_jiteiro = j;
				encontrado = true;
			}

		}

		if (encontrado) {
			return jiu_jiteiro;
		} else {
			throw new PraticanteNotFoundException("Usuario não encontrado!");
		}
	}

	public static void excluiPraticante_Jiu_Jitsu(String nome)
			throws ClassNotFoundException, IOException, PraticanteNotFoundException {

		ArrayList<Praticante_Jiu_Jitsu> listaPraticantes_Jiu_Jitsu = new ArrayList<Praticante_Jiu_Jitsu>();

		listaPraticantes_Jiu_Jitsu.addAll(getDataArquivoDAT());

		boolean removido = false;
		Praticante_Jiu_Jitsu jiu_jiteiro = null;

		
		for (Praticante_Jiu_Jitsu j : listaPraticantes_Jiu_Jitsu) {
			if (nome.contains(j.nome)) {
				jiu_jiteiro = j;
			}

		}
		removido = listaPraticantes_Jiu_Jitsu.remove(jiu_jiteiro);
		
		FileOutputStream arquivoGrava = new FileOutputStream(pathDAT);
		ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrava);

		objGravar.writeObject(listaPraticantes_Jiu_Jitsu);

		objGravar.writeObject(listaPraticantes_Jiu_Jitsu);
		objGravar.flush();
		objGravar.close();
		arquivoGrava.flush();
		arquivoGrava.close();

		if (removido) {
			System.out.println("Usuario removido com sucesso");
		} else {
			System.out.println("Usuario não removido");

		}

	}

	public static void updatePraticante_Jiu_Jitsu(String nome, Praticante_Jiu_Jitsu newJ) throws IOException, ClassNotFoundException {
		
		ArrayList<Praticante_Jiu_Jitsu> listaPraticantes_Jiu_Jitsu = new ArrayList<Praticante_Jiu_Jitsu>();

		listaPraticantes_Jiu_Jitsu.addAll(getDataArquivoDAT());

		boolean alterado = false;
		int indexJ = 0;
		
		for (Praticante_Jiu_Jitsu j : listaPraticantes_Jiu_Jitsu) {
			if (nome.contains(j.nome)) {
				indexJ = listaPraticantes_Jiu_Jitsu.indexOf(j);
				
				listaPraticantes_Jiu_Jitsu.set(indexJ ,newJ);
				alterado = true;

			}

		}
		
		FileOutputStream arquivoGrava = new FileOutputStream(pathDAT);
		ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrava);

		objGravar.writeObject(listaPraticantes_Jiu_Jitsu);

		objGravar.writeObject(listaPraticantes_Jiu_Jitsu);
		objGravar.flush();
		objGravar.close();
		arquivoGrava.flush();
		arquivoGrava.close();

		if (alterado) {
			System.out.println("Usuario alterado com sucesso");
		} else {
			System.out.println("Usuario não alterado");

		}
	}
}
