

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConsultaFutbolistas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session misession=sessionFactory.openSession();
		
		try {
			
			//comenzar sesion
			
			misession.beginTransaction();
			
			//consulta
			
			List<Futbolistas> losFutbolista= misession.createQuery("from Futbolistas").getResultList();
			
			//mostrar futbolistas
			
			recorrefutbolistasconsultados(losFutbolista);
			
			//mostrar un futbolista en concreto
			
			losFutbolista= misession.createQuery("from Futbolistas fb where fb.codDNIoNIE='11111222A'").getResultList();
			
			recorrefutbolistasconsultados(losFutbolista);
			
			//commit 
			misession.getTransaction().commit();
			
			//cerrar sesion 
			
			misession.close();


		}finally {
			
			sessionFactory.close();

		}
	}

	private static void recorrefutbolistasconsultados(List<Futbolistas> losFutbolista) {
		for (Futbolistas unFutbolista:losFutbolista) {
			
			System.out.println(unFutbolista);
		}
	}

}
