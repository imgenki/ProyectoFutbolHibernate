import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.build.AllowSysOut;
import java.util.Scanner;

public class Main {
	// static Session sesion = HibernateUtil.getSessionFactory().openSession();
	static SessionFactory miFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	static Session sesion = miFactory.openSession();
	static int opcionElegida;

	public static void main(String[] args) {
		boolean continuar = true;

		do {
//		Preguntar opcion
		System.out.println("Escoja una de las siguientes opciones");
		System.out.println("1. Insertar Equipo");
		System.out.println("2. Insertar Equipo con Observación");
		System.out.println("3. Insertar Contrato");
		System.out.println("4. Insertar Liga");
		System.out.println("5. Insertar Futbolista");
		System.out.println("6. Elimina Equipo");
		System.out.println("7. Actualiza Equipo");
		System.out.println("8. Elimina Contrato");
		System.out.println("9. Actualiza Contrato");
		System.out.println("10. Mostrar Equipos");
		System.out.println("11. Mostrar todo");
		System.out.print("Opción:");
		Scanner sc = new Scanner(System.in);
		opcionElegida = sc.nextInt();

		// Arranca la sesion
		switch (opcionElegida) {
		case 1:
			insertarEquipo();
			break;
		case 2:
			insertarEquipoObservacion();
			break;
		case 3:
			insertarContrato();
			break;
		case 4:
			insertarLiga();
			break;
		case 5:
			insertarFutbolista();
			break;
		case 6:
			eliminaEquipo();
			break;
		case 7:
			actualizaEquipo();
			break;
		case 8:
			eliminaContrato();
			break;
		case 9:
			actualizaContrato();
			break;
		case 10:
			mostrarEquipos();
			break;
		case 11:
			mostrarEquiposContratosFutbolistasLigas();
			break;
		default:
			System.out.println("No has introducido una operación válida");
			break;
		}
		
		System.out.println("¿Desea continuar? (true/false)");
		} while (continuar);
	}


	public static void mostrarEquipos() {
		sesion.beginTransaction();
		List<Equipos> eq = sesion.createQuery("from Equipos").getResultList();
		for (Equipos unEquipo : eq) {
			System.out.println(unEquipo);
			if(unEquipo.getEquiposobservacion() != null)
				System.out.println(unEquipo.getEquiposobservacion().toString());
			
			System.out.println();
		}
		sesion.close();
	}

	public static void mostrarEquiposContratosFutbolistasLigas() {
		sesion.beginTransaction();
		List<Equipos> eq = sesion.createQuery("from Equipos").getResultList();
		for (Equipos unEquipo : eq) {
			System.out.println(unEquipo);
			for (Contratos con : unEquipo.getContrato()) {
				System.out.println(con.toString());
				System.out.println(con.getFutbolista().toString());
			}
			System.out.println();
		}
		sesion.close();
	}

	public static void insertarEquipo() {

		Ligas liga = sesion.get(Ligas.class, "PDN");

		Equipos equipo1 = new Equipos("Tigalate", true, "Tamaraceite", liga);
		sesion.beginTransaction();
		sesion.save(equipo1);
		sesion.getTransaction().commit();
		sesion.close();

	}

	public static void insertarEquipoObservacion() {

		Ligas liga = sesion.get(Ligas.class, "PDN");

		Equipos equipo1 = new Equipos("Tigalate", true, "Tamaraceite", liga);

		EquiposObservaciones equiObs = new EquiposObservaciones("Equipazo");

		// equipo1.setEquiposobservacion(equiObs);
		equiObs.setEquipo(equipo1);
		sesion.beginTransaction();
		sesion.save(equipo1);
		sesion.save(equiObs);
		sesion.getTransaction().commit();
		sesion.close();
	}

	public static void insertarLiga() {

		Ligas liga1 = new Ligas("KKK", "Kus Kus Klan");
		sesion.beginTransaction();
		sesion.save(liga1);
		sesion.getTransaction().commit();
		sesion.close();
	}

	public static void insertarContrato() {

		Futbolistas futbolista = sesion.get(Futbolistas.class, "55555555A");
		Equipos equipo = sesion.get(Equipos.class, 2);
		Contratos contrato = new Contratos(futbolista, equipo, new Date(2014, 7, 1),
				new Date(2019, 6, 30), 30000, 50000);
		sesion.beginTransaction();
		sesion.save(contrato);
		sesion.getTransaction().commit();
		sesion.close();
	}

	public static void insertarFutbolista() {

		Futbolistas futbolista = new Futbolistas("45634523X", "Pepsiman", "Pepsiland");
		sesion.beginTransaction();
		sesion.save(futbolista);
		sesion.getTransaction().commit();
		sesion.close();
	}

	public static void eliminaEquipo() {

		Equipos equipo1 = sesion.get(Equipos.class, 1);
		sesion.beginTransaction();
		sesion.delete(equipo1);
		sesion.getTransaction().commit();
		sesion.close();
	}

	public static void actualizaEquipo() {
		Equipos equipo1 = sesion.get(Equipos.class, 1);

		equipo1.setLocalidad("Chipude");

		sesion.beginTransaction();
		// sesion.update(equipo1);
		sesion.getTransaction().commit();
		sesion.close();
	}

	public static void eliminaContrato() {
		Contratos contrato = sesion.get(Contratos.class, 3);

		sesion.beginTransaction();
		sesion.delete(contrato);
		sesion.getTransaction().commit();
		sesion.close();
	}

	public static void actualizaContrato() {

		Contratos contrato = sesion.get(Contratos.class, 1);
		contrato.setFechaFin(new Date(2021, 12, 19));
		sesion.beginTransaction();
		// sesion.update(contrato);
		sesion.getTransaction().commit();
		sesion.close();
	}
}
