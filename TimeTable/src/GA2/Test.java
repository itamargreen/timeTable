package GA2;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class Test {
	static Population pop = new Population(100, true);

	public static void main(String[] args) {
		Const.construct();

		pop = Algorithm2.evolvePopulation(pop);
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					pop = Algorithm2.evolvePopulation(pop);
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					pop = Algorithm2.evolvePopulation(pop);
				}
			}
		});
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					pop = Algorithm2.evolvePopulation(pop);
				}
			}
		});
		Thread t4 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					pop = Algorithm2.evolvePopulation(pop);
				}
			}
		});
		Thread t5 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					pop = Algorithm2.evolvePopulation(pop);
				}
			}
		});
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		Solution sol = pop.getFittest();
		// TimeSlot[] sunday = sol.getSlots()[0];
		// TimeSlot[] Monday = sol.getSlots()[1];
		// TimeSlot[] Tuesday = sol.getSlots()[2];
		// TimeSlot[] Wednesday = sol.getSlots()[3];
		// TimeSlot[] Thursday = sol.getSlots()[4];
		// for (int i = 0; i < sunday.length; i++) {
		// System.out.println(sunday[i]);
		// }

		JFrame frame = new JFrame();
		frame.setSize(500, 700);
		GridLayout layout = new GridLayout(9, 5, 0, 0);

		JPanel panel = new JPanel();
		int borderWidth = 1;
		JLabel[][] labels = new JLabel[5][9];
		// System.out.println("hi");
		for (int i = 0; i < labels.length; i++) {
			for (int j = 0; j < labels[i].length; j++) {
				String text = "";
				Iterator<Lesson> it = sol.getSlots()[i][j].getL().iterator();

				while (sol.getSlots()[i][j].getL().iterator().hasNext()) {
					Lesson l = it.next();
					text += l.getSubject() + " - " + l.getTeacher() + ":" + l.getRoom();
					it.remove();
				}
				labels[i][j] = new JLabel(text);
//				if (i == 0) {
//					if (j == 0) {
//						labels[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
//					} else {
//						labels[i][j].setBorder(
//								BorderFactory.createMatteBorder(borderWidth, 0, borderWidth, borderWidth, Color.BLACK));
//					}
//				} else {
//					if (j == 0) {
//						labels[i][j].setBorder(
//								BorderFactory.createMatteBorder(0, borderWidth, borderWidth, borderWidth, Color.BLACK));
//					} else {
//						labels[i][j].setBorder(
//								BorderFactory.createMatteBorder(0, 0, borderWidth, borderWidth, Color.BLACK));
//					}
//				}
				labels[i][j].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
				layout.addLayoutComponent("" + i, labels[i][j]);
				panel.add(labels[i][j]);
			}
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container cont = frame.getContentPane();
		// Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		SpringLayout l = new SpringLayout();
		// cont.setBounds(20, 20, d.width - 20, d.height - 20);
		cont.setLayout(l);
		cont.add(panel);
		l.putConstraint(SpringLayout.WEST, panel, 50, SpringLayout.WEST, cont);
		l.putConstraint(SpringLayout.NORTH, panel, 50, SpringLayout.NORTH, cont);
		l.putConstraint(SpringLayout.EAST, panel, -50, SpringLayout.EAST, cont);
		l.putConstraint(SpringLayout.SOUTH, panel, -50, SpringLayout.SOUTH, cont);
		panel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		panel.setLayout(layout);
		frame.setVisible(true);

	}

}
