package code.containers;

import code.class_jerarchi.Shape;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Backpack {
    private List<Shape> items = new ArrayList<>();
    private double packVolume;
    private double summaryFiguresVolume;
    private int siz = 0;

    public Backpack(double packVolume) {
        this.packVolume = packVolume;
        summaryFiguresVolume = 0;
    }

    public void add(Shape figure) {
        summaryFiguresVolume += figure.getVolume();
        if (summaryFiguresVolume > packVolume) {
            throw new IllegalStateException("You can't pack more than volume");
        } else {
            items.add(figure);
            Collections.sort(items);
            siz++;
        }
    }
    public void delete(int index) {
        if (items.size()!=0) {
            summaryFiguresVolume-=items.get(index).getVolume();
            items.remove(index);
            siz--;
        }
    }
    public List<String> getNames() {
        List<String> ans = new ArrayList<String>();
        for (Shape item : items) {
          ans.add(item.getClass().getSimpleName());
        }
        return ans;
    }

    public List<Double> getVolumes() {
        List<Double> ans = new ArrayList<Double>();
        for (Shape item : items) {
            ans.add(Math.round(item.getVolume() * 100.0) / 100.0);
        }
        return ans;
    }

    public int getSize() {
        return siz;
    }
}
