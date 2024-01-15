package be.pxl.smarthome.api.respone;

public class ToastrErrorResponse {
    private String message;

    public ToastrErrorResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
