package com;

public class Personnes {

	  private Long idPersonne;
	  private String prenomPersonne;
	  private String nomPersonne;
	  private String datenaissPersonne;

	  public Personnes(String prenomPersonne, String nomPersonne, String datenaissPersonne) {
	    this.nomPersonne = nomPersonne;
	    this.prenomPersonne = prenomPersonne;
	    this.datenaissPersonne = datenaissPersonne;
	  }
	  
	  

	public void show() {
		
		System.out.println(this.nomPersonne+" "+this.prenomPersonne);
		
	}



	public Personnes() {
	  }

	  public String getDatenaissPersonne() {
	    return datenaissPersonne;
	  }

	  public Long getIdPersonne() {
	    return idPersonne;
	  }

	  public String getNomPersonne() {
	    return nomPersonne;
	  }

	  public String getPrenomPersonne() {
	    return prenomPersonne;
	  }

	  public void setDatenaissPersonne(String date) {
	    datenaissPersonne = date;
	  }

	  public void setIdPersonne(Long integer) {
	    idPersonne = integer;
	  }

	  public void setNomPersonne(String string) {
	    nomPersonne = string;
	  }

	  public void setPrenomPersonne(String string) {
	    prenomPersonne = string;
	  }

}
