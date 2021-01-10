package com;
import java.util.List;
import org.hibernate.Session;
import util.HibernateUtil;

public class Services {
	
    Session session =  HibernateUtil.getSessionFactory().getCurrentSession();
	
	public void addPersonne(Personnes p){
	
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		
	}
	
	public Personnes getPerson(Long idP){
	
		session.beginTransaction();
		Personnes p = (Personnes) session.load(Personnes.class, idP);
		return p;
	}
        
        public Personnes editePersonne(Personnes pr){
	
		session.beginTransaction();
		Personnes p =(Personnes) session.merge(pr);
		session.getTransaction().commit();
                return p;
		
	}
        
        public List<Personnes> findAll(){
          
       return s.createQuery("select o from Personnes o").list();
       
                   }  
        
        
       Session s = HibernateUtil.openSession();
       
       public Personnes findById(Long id){
           return (Personnes) s.get(Personnes.class, id);
           
       }
       
       public void deletePersonne(Long id){

		session.beginTransaction();
		Personnes p = findById(id);
                session.delete(p);
		session.getTransaction().commit();
       }
	
}
