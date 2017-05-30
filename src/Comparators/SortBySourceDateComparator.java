package Comparators;

import Record.Record;

import java.util.Comparator;

public class SortBySourceDateComparator implements Comparator<Record> {
    @Override
    public int compare(Record r1, Record r2) {
        if (r1.getSource().compareTo(r2.getSource()) != 0)
            return r1.getSource().compareTo(r2.getSource());
        else
            return r1.getTime().compareTo(r2.getTime());
    }
}
