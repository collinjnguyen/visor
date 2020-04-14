package utilities;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

public class Bar extends JLabel {

	private static final long serialVersionUID = 1L;
	
	private int myValue;
	
	private boolean isSelected;

	public Bar() {
		super();
		isSelected = false;
		myValue = 0;
		setup();
	}
	
	public Bar(final int theValue) {
		super();
		isSelected = false;
		myValue = theValue;
		setup();
	}
	
	private void setup() {
		setBackground(Color.BLACK);
		setOpaque(true);
		setPreferredSize(new Dimension(3, myValue*2));
		setMinimumSize(new Dimension(3, myValue*2));
		setMaximumSize(new Dimension(3, myValue*2));
		setAlignmentY(Bar.BOTTOM_ALIGNMENT);
	}
	
	public int getValue() {
		return myValue;
	}
	
	public void setValue(final int theValue) {
		myValue = theValue;
	}
	
	public boolean getSelected() {
		return isSelected;
	}
	
	public void setSelected(final boolean theSelected) {
		isSelected = theSelected;
		update();
	}
	
	public void update() {
		if (isSelected) {
			setBackground(Color.GREEN);
		} else {
			setBackground(Color.BLACK);
		}
	}

}
