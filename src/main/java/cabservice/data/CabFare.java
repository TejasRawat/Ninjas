package cabservice.data;

public class CabFare {

    private int amount;

    // gst + cgst + etc to be continued
    public CabFare() {

    }

    public CabFare(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
