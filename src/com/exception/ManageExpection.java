package com.exception;

public class ManageExpection extends RuntimeException {
    private static final long serialVersionUID = -2780524204761062576L;

    public ManageExpection() {
        super();
    }

    public ManageExpection(String msg, Throwable t) {
        super( msg, t );
    }

    public ManageExpection(String msg) {
        super( msg );
    }

    public ManageExpection(Throwable t) {
        super( t );
    }
}
