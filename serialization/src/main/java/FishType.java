public enum FishType {
    PIKE("Щука"), PERCH("Окунь"), SALMON("Лосось"), ZANDER("Судак"), TAIMEN("Таймень");

    private final String title;

    FishType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return this.getTitle();
    }
}
