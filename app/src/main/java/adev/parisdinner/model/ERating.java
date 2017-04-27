package adev.parisdinner.model;

/**
 * Created by Aldric ANDRE
 * on 27/04/2017.
 */

public class ERating {

    private float score;
    private int count;

    public ERating() {
    }

    public ERating(int score, int count) {
        this.score = score;
        this.count = count;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
