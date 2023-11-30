import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.undo.UndoManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
class exercice1 extends JFrame{
	JButton button;
	JTextField nombre;
	JTextArea resultat;
	JTextArea resutat_Factoriel;
    JTextArea resultat_Moyenne;
	JTextArea inputTextArea_Factoriel;
	JTextField inputTextArea_Moyenne;
	UndoManager undoManager;

	exercice1(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new java.awt.FlowLayout());

		JTabbedPane tabbedPane = new JTabbedPane();
		JPanel factorielPanel = new JPanel();
		JPanel moyennePanel = new JPanel();
		nombre = new JTextField(20);
		inputTextArea_Factoriel = new JTextArea(20, 20);
		inputTextArea_Moyenne = new JTextField(20);
		undoManager = new UndoManager(); 
        Document doc = nombre.getDocument();
		Document doc1 = inputTextArea_Moyenne.getDocument();
        doc.addUndoableEditListener(undoManager); 
		doc1.addUndoableEditListener(undoManager); 

        nombre.addKeyListener(new KeyListener() { 
            public void keyTyped(KeyEvent e) {}
            public void keyPressed(KeyEvent e) {
                if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z) {
                    if (undoManager.canUndo()) {
                        undoManager.undo();
                    }
                }
            }
            public void keyReleased(KeyEvent e) {}
        });
		inputTextArea_Moyenne.addKeyListener(new KeyListener() { 
            public void keyTyped(KeyEvent e) {}
            public void keyPressed(KeyEvent e) {
                if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z) {
                    if (undoManager.canUndo()) {
                        undoManager.undo();
                    }
                }
            }
            public void keyReleased(KeyEvent e) {}
        });
		nombre.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e){
				updateTextArea_Factoriel();
			}
			public void removeUpdate(DocumentEvent e){
				updateTextArea_Factoriel();
			}
			public void changedUpdate(DocumentEvent e){
				updateTextArea_Factoriel();
			}
		});

		nombre.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e){
				updateTextArea_Factoriel();
			}
			public void removeUpdate(DocumentEvent e){
				updateTextArea_Factoriel();
			}
			public void changedUpdate(DocumentEvent e){
				updateTextArea_Factoriel();
			}
		});

		resultat = new JTextArea(5, 20);
		resultat.setEditable(false);
		factorielPanel.add(nombre);
		factorielPanel.add(new JScrollPane(resultat));
		tabbedPane.addTab("Factoriel", factorielPanel);
		

		resultat_Moyenne = new JTextArea(5, 20);
		resultat_Moyenne.setEditable(false);
		moyennePanel.add(new JScrollPane(inputTextArea_Moyenne));
		moyennePanel.add(new JScrollPane(resultat_Moyenne));
		tabbedPane.addTab("Moyenne", moyennePanel);


		this.add(tabbedPane);

		this.pack();
		this.setVisible(true);
	}

	private void updateTextArea_Factoriel(){
		try{
			String inputTextArea = nombre.getText();
			int n = Integer.parseInt(inputTextArea);
			int factorial = calculFactoriel(n);
			resultat.setText("Factorial: "+factorial);
		}catch(IllegalArgumentException ex){
			resultat.setText("Invalid input: "+ex.getMessage());
		}
	}

	private void updateTextArea_Moyenne() {
        try {
            String inputText = inputTextArea_Moyenne.getText();
            String[] nbr = inputText.split("\\s+");
            ArrayList<Integer> nbrList = new ArrayList<>();
            for (String string : nbr) {
                nbrList.add(Integer.parseInt(string));
            }
            double average = calculateAverage(nbrList);
            resultat_Moyenne.setText("Moyenne: " + average);
        } catch (IllegalArgumentException ex) {
            resultat_Moyenne.setText("Invalid input: " + ex.getMessage());
        }
    }

	public int calculFactoriel(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("Le nombre doit être positif ou nul pour calculer la factorielle.");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * calculFactoriel(n - 1);
    }
	double calculateAverage(ArrayList<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("ArrayList est vide.");
        }
		else if (numbers.size() > 4) {
			throw new IllegalArgumentException("La longueur du tableau est supérieure à 4.");
		}
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return (double) sum / numbers.size();
    }
	
	public static void main(String[] a) {
		SwingUtilities.invokeLater(() -> {
			exercice1 me = new exercice1();
		});
	}
}


