import Journals.ArrayJournal;
import Journals.CollectionJournal;
import Record.Importance;
import Record.Record;
import java.text.ParseException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException{
        CollectionJournal collectionJournal = new CollectionJournal();
        ArrayJournal arrayJournal = new ArrayJournal();
        Record record = new Record(new Date(119,1,1,12,12,12), Importance.Recovery_Normal,"1","asdf");
        Record record1 = new Record(new Date(110,1,1,12,12,12), Importance.Recovery_Normal,"1","qwer");
        arrayJournal.add(record);
        arrayJournal.add(record1);
        System.out.println();
        collectionJournal.add(arrayJournal);
        collectionJournal.printRecords();
        collectionJournal.sortByDate();
        System.out.println();
        collectionJournal.printRecords();
        System.out.println();
    }
}
