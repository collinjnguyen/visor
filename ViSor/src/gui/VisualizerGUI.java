package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import sorting.BogoSorter;
import sorting.BubbleSorter;
import sorting.SelectionSorter;
import sorting.Sorter;

public class VisualizerGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private VisualizerGUI myFrame;
	
	private JPanel myVisualizerPanel;
	
	private JPanel myControlPanel;
	
	private JPanel myInfoPanel;
	
	private JPanel myRightPanel;
	
	private JPanel myMainPanel = new JPanel();
	
	private Visualizer myVisualizer;
	
	private final GridBagConstraints gbc = new GridBagConstraints();
	
	private JComboBox<Sorter> mySorterBox = new JComboBox<Sorter>();
	
	public VisualizerGUI() {
		super("ViSor v1.0");
	}
	
	public void start() {
		myFrame = new VisualizerGUI();
		myFrame.setLayout(new GridBagLayout());
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setContentPane(myMainPanel);
		
		myVisualizer = new Visualizer();
		generateSorters();
		
		myMainPanel.setLayout(new GridBagLayout());
		myMainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		myRightPanel = new JPanel();
		myRightPanel.setLayout(new BoxLayout(myRightPanel, BoxLayout.Y_AXIS));
		myVisualizerPanel = createVisualizerPanel();
		myControlPanel = createControlPanel();

		gbc.insets = new Insets(0,0,0,0);
		gbc.ipady = 0;
		gbc.gridx = 0;
		gbc.gridy = 0;
		myMainPanel.add(myVisualizerPanel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		myMainPanel.add(Box.createRigidArea(new Dimension(20, 0)));
		gbc.ipady = 40;
		gbc.gridx = 2;
		gbc.gridy = 0;
		myRightPanel.add(myControlPanel);
		myRightPanel.add(myInfoPanel);
		myMainPanel.add(myRightPanel, gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		myMainPanel.add(Box.createRigidArea(new Dimension(20, 0)));
		
		myFrame.pack();
		myFrame.setVisible(true);
		myFrame.setLocationRelativeTo(null);
	}
	
	private JPanel createVisualizerPanel() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.add(myVisualizer);
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		return panel;
	}
	
	private JPanel createControlPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		JButton startButton = new JButton("Start");
		JButton stopButton = new JButton("Stop");
		JButton stepButton = new JButton("Step");
		JButton shuffleButton = new JButton("Shuffle");
		JSlider speedSlider = new JSlider(JSlider.HORIZONTAL, 0, 10, 10);
		speedSlider.setMajorTickSpacing(5);
		speedSlider.setMinorTickSpacing(1);
		speedSlider.setPaintTicks(true);
		speedSlider.setPaintLabels(true);
		
		startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myVisualizer.start();
            }
        });
		
		stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myVisualizer.stop();
            }
        });
		
		stepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myVisualizer.step();
            }
        });
		
		shuffleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myVisualizer.shuffle();
            }
        });
		
		speedSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(final ChangeEvent theEvent) {
				JSlider source = (JSlider) theEvent.getSource();
				int value = source.getValue();
				myVisualizer.setSpeed(value);
			}
		});
		
		gbc.insets = new Insets(5,0,0,0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.ipady = 10;
		panel.add(mySorterBox, gbc);
		gbc.gridy = 1;
		panel.add(startButton, gbc);
		gbc.gridy = 2;
		panel.add(stopButton, gbc);
		gbc.gridy = 3;
		panel.add(stepButton, gbc);
		gbc.gridy = 4;
		panel.add(shuffleButton, gbc);
		gbc.gridy = 5;
		panel.add(speedSlider, gbc);
		gbc.gridy = 6;
		myInfoPanel = createInfoPanel();
		panel.add(myInfoPanel, gbc);
		
		return panel;
	}
	
	private JPanel createInfoPanel() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Made by Collin");
		panel.add(label);
		return panel;
	}
	
	private void generateSorters() {
		
		// Add new sorters here
		mySorterBox.addItem(new BubbleSorter(myVisualizer));
		mySorterBox.addItem(new BogoSorter(myVisualizer));
		mySorterBox.addItem(new SelectionSorter(myVisualizer));
		
		mySorterBox.addActionListener(new ActionListener() {
			 
		    @Override
		    public void actionPerformed(ActionEvent theEvent) {
		        JComboBox<Sorter> combo = (JComboBox<Sorter>) theEvent.getSource();
		        Sorter selectedSorter = (Sorter) combo.getSelectedItem();
		        myVisualizer.setSorter(selectedSorter);
		    }
		});
	}
	
}
