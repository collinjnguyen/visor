package gui;

import java.awt.EventQueue;

public class VisualizerMain {

	private VisualizerMain() {
		throw new IllegalStateException();
	}
	
	public static void main(final String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VisualizerGUI().start();
            }
        });
    }
	
}
