package Errors;

public class IndexOutsideException extends Exception {
    private int index;
    private int length;

    public IndexOutsideException(int index, int length){
        this.index = index;
        this.length = length;
    }

    @Override
    public String toString() {
        return "IndexOutsideException{" +
                "index=" + index +
                ", length=" + length +
                '}';
    }
}
