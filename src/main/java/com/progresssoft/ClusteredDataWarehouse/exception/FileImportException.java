package com.progresssoft.ClusteredDataWarehouse.exception;

public class FileImportException extends RuntimeException{

	private static final long serialVersionUID = -613412324345488448L;

    public FileImportException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
    public FileImportException( String message ){
    	super(message);
    }
}