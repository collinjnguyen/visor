package sorting;

import java.util.ArrayList;

import gui.Visualizer;
import utilities.Bar;

public abstract class Sorter {

	Visualizer myVisualizer;
	
	String myName = "MUST ADD SORTER NAME";
	
	Boolean isSorted = false;
	
	int myNumberOfValues;
	
	ArrayList<Bar> myBars;
	
	public Sorter(Visualizer theVisualizer) {
		myVisualizer = theVisualizer;
		myNumberOfValues = myVisualizer.getMyBars().size();
		myBars = myVisualizer.getMyBars();
	}
	
	public abstract void sort();
	
	public abstract void reset();
	
	@Override
	public String toString() {
		return myName;
	}
	
}
