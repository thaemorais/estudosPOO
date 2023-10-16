class Golpe {
    private String nomeGolpe;
    private double poderOfensivo;

    public Golpe(String nomeGolpe, double poderOfensivo) {
        this.nomeGolpe = nomeGolpe;
        this.poderOfensivo = poderOfensivo;
    }

    public String getNomeGolpe() {
        return nomeGolpe;
    }

    public double getPoderOfensivo() {
        return poderOfensivo;
    }
}