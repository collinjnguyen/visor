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
		if (j == myNumberOfValues - i - 1) {
    		j = 0;
    		i++;
    	} else {
    		if (myBars.get(j).compareTo(myBars.get(j+1)) == 1) {
    			Collections.swap(myBars, j,j+1);
    		}
    		j++;
    	}
		myVisualizer.showSelectedValue(j);
		if (i == myNumberOfValues - 1) {
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
