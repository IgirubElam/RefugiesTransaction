package com.refugietransaction.exceptions;

public enum ErrorCodes {
	
	  PRODUCT_NOT_FOUND(1000),
	  PRODUCT_NOT_VALID(1001),
	  PRODUCT_ALREADY_IN_USE(1002),

	  CAMP_NOT_FOUND(2000),
	  CAMP_NOT_VALID(2001),
	  CAMP_ALREADY_IN_USE(2002),

	  MENAGE_NOT_FOUND(3000),
	  MENAGE_NOT_VALID(3001),
	  MENAGE_ALREADY_IN_USE(3002),

	  MVT_STK_NOT_FOUND(4000),
	  MVT_STK_NOT_VALID(4001),

	  UTILISATEUR_NOT_FOUND(5000),
	  UTILISATEUR_NOT_VALID(5001),
	  UTILISATEUR_ALREADY_EXISTS(5002),
	  UTILISATEUR_CHANGE_PASSWORD_OBJECT_NOT_VALID(5003),
	  
	  AGENT_NOT_FOUND(6000),
	  AGENT_NOT_VALID(6001),
	  AGENT_ALREADY_EXISTS(6002),

	  BAD_CREDENTIALS(12003),

	 

	  // Liste des exception techniques
	  UNKNOWN_CONTEXT(14001)
	  ;

	  private int code;

	  ErrorCodes(int code) {
	    this.code = code;
	  }

	  public int getCode() {
	    return code;
	  }
}
