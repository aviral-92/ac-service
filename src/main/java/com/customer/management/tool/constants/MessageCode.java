package com.customer.management.tool.constants;


public enum MessageCode  implements java.io.Serializable {

	ADD_CUSTOMER("addcustomer") ;
	
	
	
	

    // String that represents a property
    private String property = null;

    /**
     * Enum constructor
     */
    MessageCode(String property) {
        this.property = property;
    }

    /**
     * Return the enumeration from the String
     * 
     * @link MessageCode
     */
    public static MessageCode fromValue(String value) {
        return valueOf(value);
    }

    /**
     * Return the value of enumeration
     * 
     * @return enumerationValue {@link String}
     */
    public String getValue() {
        return property;
    }
}
