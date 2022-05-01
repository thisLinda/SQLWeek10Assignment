package entity;

public class Med {

    private int medId;
    private String genericName;

    public Med(int medId, String genericName) {
        this.setMedId(medId);
        this.setGenericName(genericName);
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public int getMedId() {
        return medId;
    }

    public void setMedId(int medId) {
        this.medId = medId;
    }

}
