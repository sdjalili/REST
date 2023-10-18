package SD.Spring.REST.CRUD.Entity;

import java.time.LocalDateTime;
import java.util.Date;

public class EmployeeErrorResponse {
    private int status;
    private String message;
    private long timestampe;

    public EmployeeErrorResponse() {
    }

    public EmployeeErrorResponse(int status, String message, long timestampe) {
        this.status = status;

        this.message = message;
        this.timestampe = timestampe;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestampe() {
        return timestampe;
    }

    public void setTimestampe(long timestampe) {
        this.timestampe = timestampe;
    }
}
