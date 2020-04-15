package sorting;

import java.util.Collections;

import gui.Visualizer;

public class SelectionSorter extends Sorter {

	private int i = 0;
	
	private int j = 0;
	
	private int min = 0;
	
	public SelectionSorter(Visualizer theVisualizer) {
		super(theVisualizer);
		myName = "Selection Sort";
	}

	@Override
	public void sort() {
//		for (int i = 0; i < n-1; i++) 
//        { 
//            // Find the minimum element in unsorted array 
//            int min_idx = i; 
//            for (int j = i+1; j < n; j++) 
//                if (arr[j] < arr[min_idx]) 
//                    min_idx = j; 
//  
//            // Swap the found minimum element with the first 
//            // element 
//            int temp = arr[min_idx]; 
//            arr[min_idx] = arr[i]; 
//            arr[i] = temp; 
//        } 
		if (j == myNumberOfValues - 1) {
			Collections.swap(myBars, min, i);
    		j = 0;
    		i++;
    		min = i;
    	} else {
    		j = i + 1;
    		if (myBars.get(j).compareTo(myBars.get(min)) == -1) {
    			min = j;
    		}
    		j++;
    	}
		myVisualizer.showSelectedValue(j);
		if (i == myNumberOfValues - 2) {
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
