package adev.parisdinner.utils;

import java.util.Comparator;

import adev.parisdinner.model.Food;

/**
 * Created by Aldric ANDRE
 * on 28/04/2017.
 */

public class FoodDescComparator implements Comparator<Food> {
    @Override
    public int compare(Food o1, Food o2) {
        return o2.getTitle().compareToIgnoreCase(o1.getTitle());
    }
}
