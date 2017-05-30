package Comparators;

import Record.Record;

import java.util.Comparator;

public class SortByImportanceDateComparator implements Comparator<Record> {
    @Override
    public int compare(Record r1, Record r2) {
        if (r1.getImportance().compareTo(r2.getImportance()) != 0)
            return r1.getImportance().compareTo(r2.getImportance());
        else
            return r1.getTime().compareTo(r2.getTime());
    }
}
