package sets.treeSetChallenge;



public class Seat implements Comparable<Seat>{
    private String seatNum;
    private Boolean reserved;

    public Seat(char rowChar, int seatNo) {
        this.seatNum = "%c%03d".formatted(rowChar, seatNo).toUpperCase();
        this.reserved = false;
    }

    public String getSeatNum() {
        return seatNum;
    }
    public boolean isReserved() {
        return reserved;
    }
    public void reserveSeat() {
        reserved = true;
    }

    @Override
    public String toString() {
        return seatNum;
    }

    @Override
    public int compareTo(Seat o) {
        return seatNum.compareTo(o.seatNum);
    }
}
