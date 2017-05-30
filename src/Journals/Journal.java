package Journals;

import java.util.Date;

import Errors.IndexOutsideException;
import Record.Record;

interface Journal {
    void add(Record r);

    void add(Journal j);

    void remove(Record r);

    Record get(int index);

    void set(int index, Record record);

    void insert(int index, Record record) throws IndexOutsideException;

    void remove(int index) throws IndexOutsideException;

    void remove(int fromIndex, int toIndex);

    void removeAll();

    int size();

    Journal filter(String s);

    Journal filter(Date fromDate, Date toDate);

    void sortByDate();

    void sortByImportanceDate();

    void sortByImportanceSourceDate();

    void sortBySourceDate();

    void printRecords();
}