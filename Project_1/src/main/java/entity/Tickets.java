package entity;


import java.util.Objects;

public class Tickets {
    private int id;
    private float amount;
    private String descriptions;
    Status status = Status.PENDING;
    private String rtypes = "Other";

    private int ukey;

    public Tickets() {

    }

    public Tickets(int id, float amount, String descriptions, int ukey, Status status) {
        this.id = id;
        this.amount = amount;
        this.descriptions = descriptions;
        this.ukey = ukey;
        this.status = status;
    }
    public String getrtypes(){
        return rtypes;
    }

    public void setrtypes(String rtypes){

        this.rtypes = rtypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tickets)) return false;
        Tickets tickets = (Tickets) o;
        return id == tickets.id && Float.compare(tickets.amount, amount) == 0 && ukey == tickets.ukey && Objects.equals(descriptions, tickets.descriptions) && Objects.equals(rtypes,tickets.rtypes) && status == tickets.status;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, amount, descriptions, rtypes, status, ukey);
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "id=" + id +
                ", amount=" + amount +
                ", descriptions='" + descriptions + '\'' +
                ",types='"+rtypes +'\''+
                ", ukey=" + ukey +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getUkey() {
        return ukey;
    }

    public void setUkey(int ukey) {
        this.ukey = ukey;
    }

 //   public void setStatus(com.sun.org.apache.xerces.internal.util.Status status) {
    }



