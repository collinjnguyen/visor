package sorting;

import java.util.Collections;

import gui.Visualizer;

public class BubbleSorter extends Sorter {

	private int i;
	
	private int j;
	
	public BubbleSorter(Visualizer theVisualizer) {
		super(theVisualizer);
		myName = "Bubble Sort";
	}
	
	@Override
	public void sort() {
		if (j == myVisualizer.getMyBars().size() - i - 1) {
    		j = 0;
    		i++;
    	} else {
    		if (myVisualizer.getMyBars().get(j).getValue() > myVisualizer.getMyBars().get(j+1).getValue()) {
    			Collections.swap(myVisualizer.getMyBars(), j,j+1);
    		}
    		j++;
    	}
		myVisualizer.showSelectedValue(j);
		if (i == myVisualizer.getMyBars().size() - 1) {
			myVisualizer.stop();
		}
	}
	
	public void reset() {
		i = 0;
		j = 0;
		myVisualizer.showSelectedValue(j);
	}
	
}
