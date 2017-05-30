package Comparators;

import Record.Record;

import java.util.Comparator;

public class SortByDateComparator implements Comparator<Record> {
    @Override
    public int compare(Record r1, Record r2) {
        return r1.getTime().compareTo(r2.getTime());
    }
}
