import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextArea;
class exercice1 {
	void button() {
		Frame f = new Frame();
		Button factoriButton = new Button("factoriel");
		factoriButton.setBounds(100, 50, 50, 50);
		f.add(factoriButton);
		Button moyenneButton = new Button("moyenneButton");
		moyenneButton.setBounds(100, 101, 50, 50);
		f.add(moyenneButton);
		Button cancelButton = new Button("CANCLE");
		cancelButton.setBounds(100, 150, 80, 50);
		f.add(cancelButton);
		f.setSize(500, 500);
		f.setLayout(null);
		f.setVisible(true);
	}
	JTextArea styledTextArea = StylePage.createStyledTextArea();
	frame.add(styledTextArea);
	JTextArea styledTextArea1 = StylePage.createStyledTextArea();
	frame.add(styledTextArea1);
	public int calculateFactorial(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("Le nombre doit être positif ou nul pour calculer la factorielle.");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * calculateFactorial(n - 1);
    }
	double calculateAverage(ArrayList<Integer> numbers) {
        if (numbers.isEmpty()) {
            return 0.0; // Handle the case where the ArrayList is empty to avoid division by zero
        }
		else if (numbers.size() > 4) {
			throw new Exception("La longueur du tableau est supérieure à 4.");
		}
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return (double) sum / numbers.size();
    }

	public static void main(String a[]) {
		exercice1 obj = new exercice1();
        obj.button();

		int result = obj.calculateFactorial(5);
        System.out.println("Factorial of 5: " + result);
		ArrayList<Integer> numberList = new ArrayList<>();
        numberList.add(10);
        numberList.add(20);
        numberList.add(30);
	}
}


