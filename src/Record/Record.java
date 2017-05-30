package Record;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Record {
    private final Date time;
    private final Importance importance;
    private final String source;
    private final String message;

    public Record(Date time, Importance importance, String source, String message) {
        this.time = time;
        this.importance = importance;
        this.source = source;
        this.message = message;
    }

    @Override
    public String toString() {
        return new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(time) + " " + String.format("%5s", importance)
                + " " + source + " " + message;

    }

    public Date getTime() {
        return time;
    }

    public Importance getImportance() {
        return importance;
    }

    public String getSource() {
        return source;
    }

    public String getMessage() {
        return message;
    }
}
