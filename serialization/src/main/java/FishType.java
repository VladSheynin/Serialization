/**
 * @author Sheynin Vladislav
 * Enum с названиями рыб и переводом на русский язык
 */
public enum FishType {
    PIKE("Щука"), PERCH("Окунь"), SALMON("Лосось"), ZANDER("Судак"), TAIMEN("Таймень");

    private final String title;

    FishType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
