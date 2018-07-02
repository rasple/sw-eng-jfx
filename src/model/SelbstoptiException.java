package model;

public class SelbstoptiException extends Exception {

    private int reason;
    public SelbstoptiException(String message, int reason){
        super(message);
        this.reason= reason;
    }

}
