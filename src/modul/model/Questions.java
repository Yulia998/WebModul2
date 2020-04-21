package modul.model;

public class Questions {
    private int id;
    private String quest;
    private String answ;
    private int point;

    public Questions(int id, String quest, String answ, int point) {
        this.id = id;
        this.quest = quest;
        this.answ = answ;
        this.point = point;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuest() {
        return quest;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }

    public String getAnsw() {
        return answ;
    }

    public void setAnsw(String answ) {
        this.answ = answ;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
