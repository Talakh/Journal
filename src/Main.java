import Journals.ArrayJournal;
import Journals.CollectionJournal;
import Record.Importance;
import Record.Record;
import java.text.ParseException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException{
        CollectionJournal arrayJournal = new CollectionJournal();
        ArrayJournal betta = new ArrayJournal();
        Record record = new Record(new Date(119,1,1,12,12,12), Importance.Recovery_Normal,"1","bla");
        Record record1 = new Record(new Date(110,1,1,12,12,12), Importance.Recovery_Normal,"1","bla");
        betta.add(record);
        betta.add(record1);
        System.out.println();
        arrayJournal.add(betta);
        arrayJournal.printRecords();
        arrayJournal.sortByDate();
        System.out.println();
        arrayJournal.printRecords();
        System.out.println();
    }
}
