package Journals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

import Comparators.SortByDateComparator;
import Comparators.SortByImportanceDateComparator;
import Comparators.SortByImportanceSourceDateComparator;
import Comparators.SortBySourceDateComparator;
import Errors.IndexOutsideException;
import Record.Record;

public class ArrayJournal implements Journal {
    private Record[] records;
    private int length;

    public ArrayJournal(Journal journal) {
        records = new Record[journal.size()];
        length = 0;
        for (int i = 0; i < journal.size(); i++) {
            records[i] = journal.get(i);
            if (records[i] != null)
                length++;
        }
    }

    public ArrayJournal() {
        length = 0;
        records = new Record[8];
    }

    @Override
    public void add(Record r) {
        if (length < records.length) {
            records[length] = r;
            length++;
        } else {
            newSize();
            add(r);
        }
    }


    @Override
    public void add(Journal j) {
        if (records.length - length >= j.size()) {
            for (int i = 0; i < j.size(); i++) {
                if (j.get(i) != null) {
                    records[length] = j.get(i);
                    length++;
                }
            }
        } else {
            newSize();
            add(j);
        }
    }


    @Override
    public void remove(Record r) {
        for (int i = 0; i < length; i++) {
            if (r.equals(records[i])) {
                System.arraycopy(records, i + 1, records, i, length - i);
                length--;
            }
        }
    }

    @Override
    public Record get(int index) {
        return records[index];
    }

    @Override
    public void set(int index, Record record) {
        records[index] = record;
    }

    /**
     * index should be less than the length
     * if index < length generate {@link IndexOutsideException}
     *
     * @param index  index of element
     * @param record array of records
     */
    @Override
    public void insert(int index, Record record) {
        try {
            if (index > length || index < 0) throw new IndexOutsideException(index, length);
            if (length < records.length) {
                System.arraycopy(records, index, records, index + 1, length + 1 - index);
                records[index] = record;
                length++;
            } else {
                newSize();
                insert(index, record);
            }
        } catch (IndexOutsideException e) {
            System.out.println(e.toString());
            System.out.println("Insert failed");
        }
    }

    /**
     * index should be less than the length
     * if index < length generate {@link IndexOutsideException}
     *
     * @param index index of element
     */
    @Override
    public void remove(int index) {
        try {
            if (index > length || index < 0) throw new IndexOutsideException(index, length);
            for (int i = index; i < length; i++) {
                records[index] = records[index + 1];
            }
            records[length--] = null;
        } catch (IndexOutsideException e) {
            System.out.println(e.toString());
            System.out.println("Remove failed");
        }
    }

    @Override
    public void remove(int fromIndex, int toIndex) {
        for (int i = fromIndex; i < toIndex; i++) {
            records[i] = null;
        }
        for (int i = 0; i < length; i++) {
            records[fromIndex + i] = records[toIndex + i];
            records[toIndex + i] = null;
        }
        length -= toIndex - fromIndex;
    }

    @Override
    public void removeAll() {
        for (int i = 0; i < length; i++)
            records[i] = null;
        length = 0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public Journal filter(String s) {
        Journal journal = new ArrayJournal();
        for (int i = 0; i < length; i++)
            if (Objects.equals(records[i].toString(), s))
                journal.add(records[i]);
        return journal;
    }

    @Override
    public Journal filter(Date fromDate, Date toDate) {
        Journal journal = new ArrayJournal();
        for (int i = 0; i < length; i++)
            if (records[i].getTime().before(toDate) && records[i].getTime().after(fromDate))
                journal.add(records[i]);
        return journal;
    }

    @Override
    public void sortByDate() {
        Record[] r = new Record[length];
        System.arraycopy(records, 0, r, 0, length);
        Arrays.sort(r, Comparator.comparing(Record::getTime));
        System.arraycopy(r, 0, records, 0, length);
    }

    @Override
    public void sortByImportanceDate() {
        Record[] r = new Record[length];
        System.arraycopy(records, 0, r, 0, length);
        Arrays.sort(r, Comparator.comparing(Record::getImportance).thenComparing(Record::getTime));
        System.arraycopy(r, 0, records, 0, length);
    }

    @Override
    public void sortByImportanceSourceDate() {
        Record[] r = new Record[length];
        System.arraycopy(records, 0, r, 0, length);
        Arrays.sort(r, Comparator.comparing(Record::getImportance).thenComparing(Record::getSource).thenComparing(Record::getTime));
        System.arraycopy(r, 0, records, 0, length);
    }

    @Override
    public void sortBySourceDate() {
        Record[] r = new Record[length];
        System.arraycopy(records, 0, r, 0, length);
        Arrays.sort(r, Comparator.comparing(Record::getSource).thenComparing(Record::getTime));
        System.arraycopy(r, 0, records, 0, length);
    }

    @Override
    public void printRecords() {
        for (int i = 0; i < length; i++)
            System.out.println(records[i].toString() + ",");
    }

    private void newSize() {
        Record[] temp = new Record[records.length * 2];
        for (int i = 0; i < records.length; i++) {
            temp[i] = records[i];
            records = temp;
        }
    }
}