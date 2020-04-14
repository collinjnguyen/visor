package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VisualizerGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private VisualizerGUI myFrame;
	
	private JPanel myVisualizerPanel;
	
	private JPanel myControlPanel;
	
	private JPanel myInfoPanel;
	
	private Visualizer myVisualizer;
	
	private final GridBagConstraints gbc;
	
	public VisualizerGUI() {
		super("ViSor v1.0");
		gbc = new GridBagConstraints();
	}
	
	public void start() {
		myFrame = new VisualizerGUI();
		myFrame.setLayout(new GridBagLayout());
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		myVisualizer = new Visualizer();
		
		myVisualizerPanel = createVisualizerPanel();
		myControlPanel = createControlPanel();

		gbc.ipady = 0;
		gbc.gridx = 0;
		gbc.gridy = 0;
		myFrame.add(myVisualizerPanel, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		myFrame.add(Box.createRigidArea(new Dimension(20, 0)));
		gbc.gridx = 2;
		gbc.gridy = 0;
		myFrame.add(myControlPanel, gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		myFrame.add(Box.createRigidArea(new Dimension(20, 0)));
		
		myFrame.pack();
		myFrame.setVisible(true);
		myFrame.setLocationRelativeTo(null);
	}
	
	private JPanel createVisualizerPanel() {
		JPanel panel = new JPanel();
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
		
		gbc.insets = new Insets(5,0,0,0);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.ipady = 30;
		panel.add(startButton, gbc);
		gbc.gridy = 1;
		panel.add(stopButton, gbc);
		gbc.gridy = 2;
		panel.add(stepButton, gbc);
		gbc.gridy = 3;
		panel.add(shuffleButton, gbc);
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
	
}
