package pr4.lysyi.dto;

/**
 *
 * @author Lysyi Anderii
 */
public class Facultet extends Entity {

    private String name;
    private String examenNames;
    private int budgetQuote;
    private String admin;
    private int comerrcialQuote;
    private int minGrade;

    public Facultet() {

    }

    public Facultet(String name, int budgetQuote, String admin, int comerrcialQuote, int minGrade, String examenNames) {
        this.name = name;
        this.budgetQuote = budgetQuote;
        this.admin = admin;
        this.comerrcialQuote = comerrcialQuote;
        this.minGrade = minGrade;
        this.examenNames = examenNames;
    }

    public Facultet(String name, int budgetQuote, String admin, int comerrcialQuote, int minGrade, int id, String examenNames) {
        super(id);
        this.name = name;
        this.budgetQuote = budgetQuote;
        this.admin = admin;
        this.comerrcialQuote = comerrcialQuote;
        this.minGrade = minGrade;
        this.examenNames = examenNames;
    }

    public void add(int id, String name, int budgetQuote, String admin, int comerrcialQuote, int minGrade, String examenNames) {
        super.setId(id);
        this.name = name;
        this.budgetQuote = budgetQuote;
        this.admin = admin;
        this.comerrcialQuote = comerrcialQuote;
        this.minGrade = minGrade;
        this.examenNames = examenNames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBudgetQuote() {
        return budgetQuote;
    }

    public void setBudgetQuote(int budgetQuote) {
        this.budgetQuote = budgetQuote;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public int getComerrcialQuote() {
        return comerrcialQuote;
    }

    public void setComerrcialQuote(int comerrcialQuote) {
        this.comerrcialQuote = comerrcialQuote;
    }

    public int getMinGrade() {
        return minGrade;
    }

    public void setMinGrade(int minGrade) {
        this.minGrade = minGrade;
    }

    public String getExamenNames() {
        return examenNames;
    }

    public void setExamenNames(String examenNames) {
        this.examenNames = examenNames;
    }
    

    @Override
    public String toString() {
        return "Facultet{" + "name=" + name + ", budgetQuote=" + budgetQuote + ", admin=" + admin + ", comerrcialQuote=" + comerrcialQuote + ", minGrade=" + minGrade + '}';
    }

}
