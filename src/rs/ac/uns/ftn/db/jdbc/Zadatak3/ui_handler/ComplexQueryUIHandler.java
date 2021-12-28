package rs.ac.uns.ftn.db.jdbc.Zadatak3.ui_handler;

import rs.ac.uns.ftn.db.jdbc.Zadatak3.dto.KomponenteAkcijaDTO;
import rs.ac.uns.ftn.db.jdbc.Zadatak3.dto.RacunarskeKomponenteDTO;
import rs.ac.uns.ftn.db.jdbc.Zadatak3.model.model.Akcija;
import rs.ac.uns.ftn.db.jdbc.Zadatak3.service.AkcijaService;
import rs.ac.uns.ftn.db.jdbc.Zadatak3.service.ComplexFuncionalityService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ComplexQueryUIHandler {

	private static final ComplexFuncionalityService complexQueryService = new ComplexFuncionalityService();
	private static final AkcijaService akcijaService = new AkcijaService();


	public void handleComplexQueryMenu() throws SQLException {
		String answer;
		do {
			System.out.println("\nOdaberite funkcionalnost:");
			System.out.println(
					"\n1  - Za Svaku Akciju prikazati komponente koje se nalaze na akciji (3)");
			System.out.println(
					"\n2  - Za Svaki Racunar prikazati komponente koje se nalaze u njemu (4)");
			System.out.println(
					"\n3  - Za Svaku Akciju prikazati komponente koje se nalaze na akciji i njihove cijene sa popustima i prosjecnu cijenu komponenti sa popustom");
			System.out.println(
					"\n4  -X za izlazak ");

			answer = MainUIHandler.sc.nextLine();

			switch (answer) {
			case "1":
				showKomponenteForAkcije();
				break;
			case "2":
				getKomponenteForRacunar();
				break;
			case "3":
				showKomponenteForAkcijeWithPopust();
				break;
			case "4":
				joco();
				break;
			case "5":
				joco();
				break;
			case "6":
				joco();
				break;

			}

		} while (!answer.equalsIgnoreCase("X"));
	}

	public	void joco(){
		System.out.println("ASD");
	}

	public void showKomponenteForAkcije() throws SQLException {
		System.out.println("ID Akcije: ");
		int id = Integer.parseInt(MainUIHandler.sc.nextLine());


		try {
			if (!akcijaService.existsById(id)) {
				System.out.println("Uneta vrijednost Akcije ne postoji!");
				return;
			}

			List<KomponenteAkcijaDTO> komponenteLista = new ArrayList<KomponenteAkcijaDTO>();
			komponenteLista = complexQueryService.getAllKomponenteNaAkciji(id);
			System.out.println("=========================================KOMPONENTE========================================");
			System.out.println(KomponenteAkcijaDTO.getFormattedHeader());
			for(KomponenteAkcijaDTO k: komponenteLista) {
				System.out.println(k);
				System.out.println("------------------------------------------------------------------------------------------");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

	}

	public void getKomponenteForRacunar()throws SQLException {

		List<String> naziviRacunara = new ArrayList<String>();
		List<Integer> ids = new ArrayList<Integer>();
//		List<Integer> brKomponenti = new ArrayList<Integer>();

		try {
			List<RacunarskeKomponenteDTO> komponenteLista = new ArrayList<RacunarskeKomponenteDTO>();
			for (int i = 1; i <= complexQueryService.brojRacunara(); i++) {
				komponenteLista = complexQueryService.GetKomponentaByRacunarId(i);
				naziviRacunara.add(komponenteLista.get(i).getNazivr()); //iz komponente liste [1,2,3] dobaviti naziv i smjestiti u listu
				ids.add(komponenteLista.get(i).getIdr()); // iz komponentne liste [1,2,3] dobaviti idRacunara i smjestiti u ids
			//	brKomponenti.add(komponenteLista.size()); // iz komponentne liste do
		//		System.out.println(komponenteLista.get(i).getNazivr()+" " + komponenteLista.get(i).getIdr()+" "+komponenteLista.size());
			}


			for (int i = 1; i <= complexQueryService.brojRacunara(); i++) {

				komponenteLista = complexQueryService.GetKomponentaByRacunarId(i);
				System.out.println();
				System.out.println("IDR----------NazivR--------------BR_Komponenti-------");
				System.out.println(komponenteLista.get(i).getIdr()+"          " + komponenteLista.get(i).getNazivr()+"              "+komponenteLista.stream().map(k->k.getBrKomponenti()).reduce(0,Integer::sum));
				System.out.println();
				System.out.println("=========================================KOMPONENTE========================================");
				System.out.println(RacunarskeKomponenteDTO.getFormattedHeader());
				for (RacunarskeKomponenteDTO k : komponenteLista) {
					System.out.println("=======================================================================================");
					System.out.print(k.getIdk());
					System.out.print("   |   ");
					System.out.print(k.getNazivk());
					System.out.print("   |   ");
					System.out.print(k.getTip());
					System.out.print("   |   ");
					System.out.print(k.getProizvodjac());
					System.out.print("   |   ");
					if(k.getProizvodjac().equals("MSI") | (k.getProizvodjac().equals("COOLER MASTER"))){
						System.out.print("TWD");
						System.out.print("     |       ");
						System.out.print(k.getCena()*28);
						System.out.print("  |         ");
						System.out.print(k.getAkc());
						System.out.println("  ");
					}
					if(k.getProizvodjac().equals("Samsung")) {
						System.out.print("KRW");
						System.out.print("   |      ");
						System.out.print(k.getCena() * 1.085);
						System.out.print("  |              ");
						System.out.print(k.getAkc());
						System.out.println("  ");
					}
					if((k.getProizvodjac().equals("Samsung")==false)&(k.getProizvodjac().equals("MSI")==false)&(k.getProizvodjac().equals("COOLER MASTER")==false)){
						System.out.print("USD");
						System.out.print("    |  ");
						System.out.print(k.getCena());
						System.out.print(" |             ");
						System.out.print(k.getAkc());
						System.out.println("  ");
					}

				}
			}
		}

		catch(SQLException e) {
		e.printStackTrace();
	}

}
	public void showKomponenteForAkcijeWithPopust() throws SQLException {
		System.out.println("ID Akcije: ");
	int id = Integer.parseInt(MainUIHandler.sc.nextLine());
	Akcija akcija = new Akcija();
		akcija = akcijaService.getById(id);
		double temp = 0;
		double suma = 0;
		int brKomponenti = 0;
		double prosjecnaCijena = 0;
		double a = 0;
		double popust = new Double(akcija.getPopust());
		popust = popust/100;

		try {
		if (!akcijaService.existsById(id)) {
			System.out.println("Uneta vrijednost Akcije ne postoji!");
			return;
		}



		List<KomponenteAkcijaDTO> komponenteLista = new ArrayList<KomponenteAkcijaDTO>();
		komponenteLista = complexQueryService.getAllKomponenteNaAkciji(id);


			for(KomponenteAkcijaDTO k: komponenteLista) {
				temp = k.getCenaKomponente();
				temp = temp*(1-popust);
				suma += temp;
				brKomponenti = komponenteLista.size(); }

			prosjecnaCijena = suma/brKomponenti;
			System.out.println("Prosijecna cijena je "+prosjecnaCijena);

		System.out.println("=========================================KOMPONENTE=================================================================================");
		System.out.println(KomponenteAkcijaDTO.getFormattedHeader()+"    CIJENA SA POPUSTOM");
		for(KomponenteAkcijaDTO k: komponenteLista) {
			temp = k.getCenaKomponente();
			temp = temp*(1-popust);
			suma += temp;
			brKomponenti = komponenteLista.size();
			System.out.println(k+"           "+temp);
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
		}
	}
		catch(SQLException e) {
		e.printStackTrace();
	}

}





}
