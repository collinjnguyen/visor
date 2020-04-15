package sorting;

import gui.Visualizer;

public class BogoSorter extends Sorter{
	
	public BogoSorter(Visualizer theVisualizer) {
		super(theVisualizer);
		myName = "Bogo Sort";
	}

	@Override
	public void sort() {
		myVisualizer.shuffle();
	}

	@Override
	public void reset() {
		myVisualizer.showSelectedValue(0);
	}

}
