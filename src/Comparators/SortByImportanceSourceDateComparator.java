package Comparators;

import Record.Record;

import java.util.Comparator;

public class SortByImportanceSourceDateComparator implements Comparator<Record> {

    @Override
    public int compare(Record r1, Record r2) {
        if (r1.getImportance().compareTo(r2.getImportance()) != 0)
            return r1.getImportance().compareTo(r2.getImportance());
        else if (r1.getSource().compareTo(r2.getSource()) != 0)
            return r1.getSource().compareTo(r2.getSource());
        else
            return r1.getTime().compareTo(r2.getTime());
    }
}
