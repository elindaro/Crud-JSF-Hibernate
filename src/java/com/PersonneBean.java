package com;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;



 


@ManagedBean(name="Bean1")      
@RequestScoped 
public class PersonneBean {
	 
	 
	
	
//	public Logger log = Logger.getLogger(PersonneBean.class);
	
	private Services s = new Services();
	
	
	private String nom;  
	private String prenom; 
	private String dateN;
        
        private String id;
        private String operation;
        
        private List<Personnes> persList;

    public List<Personnes> getPersList() {
        return persList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setPersList(List<Personnes> persList) {
        this.persList = persList;
    }
	 

	public PersonneBean() {
		// TODO Auto-generated constructor stub
	}
	
	public String getDateN() {
		return dateN;
	}
 
	public void setDateN(String dateN) {
		this.dateN = dateN; 
	}

	@PostConstruct
	public void initBean() { 

        persList = s.findAll();
        
        if("edit".equalsIgnoreCase(getParam("operation"))){           
            setOperation(getParam("operation"));
            Long id =null;
            Personnes pr = null;
            
            try{
                id = Long.valueOf(getParam("id"));
                setId(getParam("id"));
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
            if(id !=null){
               pr =s.findById(id);
               
               if(pr !=null){
                      prenom = pr.getPrenomPersonne();
	             nom =pr.getNomPersonne();
	            dateN = pr.getDatenaissPersonne();
            
               }
            }
                                             
        }
        
	}
	 
	public void Save() {

	System.out.println("hello method 1");
	
        Personnes p =null;
        
        if("edit".equalsIgnoreCase(operation)){
            
            p=s.findById(new Long(id));
            
        }else{
            p=new Personnes();            
                      
        }
          p.setNomPersonne(nom);
     	  p.setPrenomPersonne(prenom);
       	  p.setDatenaissPersonne(dateN); 
	  s.addPersonne(p);
          
          nom="";
          prenom="";
          dateN = "";
          id="";
          operation="";
	}
        
       public void deletePer(){
           FacesContext fc = FacesContext.getCurrentInstance();
           Map<String,String> param = fc.getExternalContext().getRequestParameterMap();
           
           s.deletePersonne(new Long(param.get("id")));
           persList = s.findAll();
       }
        
       public String getParam(String name){
           
           FacesContext fc = FacesContext.getCurrentInstance();
          Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
           return params.get(name);
       }
 
 

	public String getNom() {
		return nom;
	}


	public void setNom(String name) {
		this.nom = name;
	}


	public String getPrenom() {
		return prenom; 
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
