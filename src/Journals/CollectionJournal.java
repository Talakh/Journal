package Journals;

import java.util.*;

import Comparators.SortByDateComparator;
import Comparators.SortByImportanceDateComparator;
import Comparators.SortByImportanceSourceDateComparator;
import Comparators.SortBySourceDateComparator;
import Record.Record;

public class CollectionJournal implements Journal {
    private List<Record> list;

    public CollectionJournal(Journal journal) {
        list = new ArrayList<>();
        for (int i = 0; i < journal.size(); i++) {
            list.add(journal.get(i));
        }
    }

    public CollectionJournal() {
        list = new ArrayList<>();
    }

    @Override
    public void add(Record r) {
        list.add(r);
    }

    @Override
    public void add(Journal j) {
        for (int i = 0; i < j.size(); i++)
            list.add(j.get(i));
    }

    @Override
    public void remove(Record r) {
        list.remove(r);
    }

    @Override
    public Record get(int index) {
        return list.get(index);
    }

    @Override
    public void set(int index, Record record) {
        list.set(index, record);
    }

    @Override
    public void insert(int index, Record record) {
        list.add(index, record);
    }

    @Override
    public void remove(int index) {
        list.remove(index);
    }

    @Override
    public void remove(int fromIndex, int toIndex) {
        for (int i = fromIndex; i < toIndex; i++)
            list.remove(fromIndex);
    }

    @Override
    public void removeAll() {
        remove(0, list.size());
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Journal filter(String s) {
        Journal journal = new ArrayJournal();
        for (Record r : list) {
            if (r.toString().equals(s))
                journal.add(r);
        }
        return journal;
    }

    @Override
    public Journal filter(Date fromDate, Date toDate) {
        Journal journal = new ArrayJournal();
        for (Record r : list) {
            if (r.getTime().before(toDate) && r.getTime().after(fromDate))
                journal.add(r);
        }
        return journal;
    }

    @Override
    public void sortByDate() {
        Record[] rec = list.toArray(new Record[list.size()]);
        Arrays.sort(rec, Comparator.comparing(Record::getTime));
        list = Arrays.asList(rec);
    }

    @Override
    public void sortByImportanceDate() {
        Record[] rec = list.toArray(new Record[list.size()]);
        Arrays.sort(rec, Comparator.comparing(Record::getImportance).thenComparing(Record::getTime));
        list = Arrays.asList(rec);
    }

    @Override
    public void sortByImportanceSourceDate() {
        Record[] rec = list.toArray(new Record[list.size()]);
        Arrays.sort(rec, Comparator.comparing(Record::getImportance).thenComparing(Record::getSource).thenComparing(Record::getTime));
        list = Arrays.asList(rec);
    }

    @Override
    public void sortBySourceDate() {
        Record[] rec = list.toArray(new Record[list.size()]);
        Arrays.sort(rec, Comparator.comparing(Record::getSource).thenComparing(Record::getTime));
        list = Arrays.asList(rec);
    }

    @Override
    public void printRecords() {
        for (Record r : list) {
            System.out.println(r);
        }
    }
}