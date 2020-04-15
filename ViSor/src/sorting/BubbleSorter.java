package sorting;

import java.util.Collections;

import gui.Visualizer;

public class BubbleSorter extends Sorter {

	private int i = 0;
	
	private int j = 0;
	
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
			isSorted = true;
			myVisualizer.sortingDone();
		}
	}
	
	@Override
	public void reset() {
		i = 0;
		j = 0;
		isSorted = false;
		myVisualizer.showSelectedValue(j);
	}
	
}
