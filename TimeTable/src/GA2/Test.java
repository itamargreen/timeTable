package GA2;

import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test {
	static Population pop = new Population(100, true);
	static String[] notLearn = { "Bible" };

	public static void main(String[] args) {
		Const.construct();

		pop = Algorithm2.evolvePopulation(pop);
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					pop = Algorithm2.evolvePopulation(pop);
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					pop = Algorithm2.evolvePopulation(pop);
				}
			}
		});
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					pop = Algorithm2.evolvePopulation(pop);
				}
			}
		});
		t1.start();
		t2.start();
		t3.start();
		System.out.println("1");
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
				layout.addLayoutComponent("" + i, labels[i][j]);
				panel.add(labels[i][j]);
			}
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println("hi");
		frame.getContentPane().add(panel);
		panel.setLayout(layout);
		frame.setVisible(true);

	}

}
