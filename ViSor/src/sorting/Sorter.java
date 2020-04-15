package sorting;

import gui.Visualizer;

public abstract class Sorter {

	Visualizer myVisualizer;
	
	String myName;
	
	public Sorter(Visualizer theVisualizer) {
		myVisualizer = theVisualizer;
	}
	
	public abstract void sort();
	
	public abstract void reset();
	
	@Override
	public String toString() {
		return myName;
	}
	
}
