package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.Timer;

import sorting.BubbleSorter;
import sorting.Sorter;
import utilities.Bar;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Visualizer extends JPanel {
	
	private static final long serialVersionUID = 1L;

	private final ArrayList<Bar> myBars;
	
	private final Timer myTimer;
	
	private final int myTimerDelay = 2;
	
	private final int myNumberOfValues = 200;
	
	private Sorter mySorter;
	
	private int myComparisons = 0;
		
	public Visualizer() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		myBars = new ArrayList<>();
		
		makeBars();
		update();
		
		myTimer = new Timer(myTimerDelay, new TimeListener());
		mySorter = new BubbleSorter(this);
	}
	
	public void update() {
		for (Bar b : myBars) {
			add(b);
			// To add space between bars: 
			// add(Box.createRigidArea(new Dimension(1, 0)));
		}
	}
	
	private void makeBars() {
		for (int x = 1; x < myNumberOfValues; x++) {
			Bar b = new Bar(x);
			myBars.add(b);
		}
		Collections.shuffle(myBars);
	}
	
	public void start() {
		myTimer.start();
	}
	
	public void stop() {
		myTimer.stop();
	}
	
	public void step() {
		mySorter.sort();
		myComparisons++;
		update();
		revalidate();
	}
	
	public void shuffle() {
		Collections.shuffle(myBars);
		mySorter.reset();
		update();
		revalidate();
	}
	
	public void showSelectedValue(int theCurrentBar) {
		for(Bar b : myBars) {
			b.setSelected(false);
		}
		myBars.get(theCurrentBar).setSelected(true);
		repaint();
	}
	
	public ArrayList<Bar> getMyBars() {
		return myBars;
	}
	
	private class TimeListener implements ActionListener {
        public void actionPerformed(final ActionEvent theEvent) {    	
        	mySorter.sort();
        	myComparisons++;
        	update();
            revalidate();
        }
    }
	
}
