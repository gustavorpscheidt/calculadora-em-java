package avaliativo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private static JTextField textField;/**/
	/**
	 * Launch the application.
	 */
	private static JTextArea historico = new JTextArea();
	private static String numeros[] = new String[2];
	private static char operacao;
	private static char pos=0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					numeros[0]="0";
					numeros[1]="0";
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setTitle("Calculadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setText("0");
		textField.setBounds(10, 11, 173, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		historico.setEnabled(false);
		historico.setBounds(269, 13, 159, 201);
		contentPane.add(historico);
		
		JLabel lblNewLabel = new JLabel("Histórico");
		lblNewLabel.setBounds(270, 0, 75, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Limpar histórico");
		btnNewButton.setBounds(279, 227, 149, 23);
		contentPane.add(btnNewButton);
		
		JButton apagar = new JButton("AC");
		apagar.setBounds(193, 12, 58, 26);
		contentPane.add(apagar);
		
		JPanel panel = new JPanel();
		panel.setBounds(9, 54, 260, 220);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton inverso = new JButton("1/X");
		
		
		inverso.setBounds(0, 0, 59, 34);
		panel.add(inverso);
		
		JButton elevado = new JButton("X^Y");
		elevado.setBounds(65, 0, 59, 34);
		panel.add(elevado);
		
		JButton fatorial = new JButton("X!");
		fatorial.setBounds(130, 0, 59, 34);
		panel.add(fatorial);
		
		JButton dividir = new JButton("/");
		dividir.setBounds(190, 0, 59, 34);
		panel.add(dividir);
		
		JButton b7 = new JButton("7");
		b7.setBounds(0, 45, 59, 34);
		panel.add(b7);
		
		JButton b4 = new JButton("4");
		b4.setBounds(0, 90, 59, 34);
		panel.add(b4);
		
		JButton b8 = new JButton("8");
		b8.setBounds(65, 45, 59, 34);
		panel.add(b8);
		
		JButton b9 = new JButton("9");
		b9.setBounds(130, 45, 59, 34);
		panel.add(b9);
		
		JButton vezes = new JButton("*");
		vezes.setBounds(190, 45, 59, 34);
		panel.add(vezes);
		
		JButton b5 = new JButton("5");
	
		b5.setBounds(65, 90, 59, 34);
		panel.add(b5);
		
		JButton b6 = new JButton("6");
		b6.setBounds(130, 90, 59, 34);
		panel.add(b6);
		
		JButton menos = new JButton("-");
		menos.setBounds(190, 90, 59, 34);
		panel.add(menos);
		
		JButton inverter = new JButton("√X");
		inverter.addActionListener(new ListenerBotao());
		inverter.setBounds(0, 180, 59, 34);
		panel.add(inverter);
		
		JButton b0 = new JButton("0");
		b0.setBounds(65, 180, 59, 34);
		panel.add(b0);
		
		JButton virgula = new JButton(",");
		virgula.setBounds(130, 180, 59, 34);
		panel.add(virgula);
		
		JButton igual = new JButton("=");
		igual.setBounds(190, 180, 59, 34);
		panel.add(igual);
		
		JButton mais = new JButton("+");
		mais.setBounds(190, 135, 59, 34);
		panel.add(mais);
		
		JButton b3 = new JButton("3");
		b3.setBounds(130, 135, 59, 34);
		panel.add(b3);
		
		JButton b2 = new JButton("2");
		b2.setBounds(65, 135, 59, 34);
		panel.add(b2);
		
		JButton b1 = new JButton("1");
		b1.addActionListener(new ListenerBotao());
		b1.setBounds(0, 135, 59, 34);
		panel.add(b1);
		
		btnNewButton.addActionListener(new ListenerBotao());//limpar o histórico
		b0.addActionListener(new ListenerBotao());
		b2.addActionListener(new ListenerBotao());
		b3.addActionListener(new ListenerBotao());
		b4.addActionListener(new ListenerBotao());
		b5.addActionListener(new ListenerBotao());
		b6.addActionListener(new ListenerBotao());
		b7.addActionListener(new ListenerBotao());
		b8.addActionListener(new ListenerBotao());
		b9.addActionListener(new ListenerBotao());
		inverso.addActionListener(new ListenerBotao());
		igual.addActionListener(new ListenerBotao());
		virgula.addActionListener(new ListenerBotao());
		mais.addActionListener(new ListenerBotao());
		menos.addActionListener(new ListenerBotao());
		vezes.addActionListener(new ListenerBotao());
		dividir.addActionListener(new ListenerBotao());
		fatorial.addActionListener(new ListenerBotao());
		elevado.addActionListener(new ListenerBotao());
		apagar.addActionListener(new ListenerBotao());
	}
	
	
	public static void clicar(String texto) {
	try {
			
			if(textField.getText().equals("") ||textField.getText().equals("erro de sintaxe") || textField.getText().equals("NaN")
					||textField.getText().equals("Infinity")
					) {
				textField.setText("0");
			}
			
			
			if(texto.equals("√X")&& pos==0) {
				//pos--;
				numeros[1]="0";
				numeros[0]=textField.getText();
				
				textField.setText("" +(Math.sqrt(Double.parseDouble(numeros[pos]))));
			}
			else if(texto.equals("1/X") && pos==0) {
				//pos--;
				numeros[1]="0";
				numeros[0]=textField.getText();
				
				textField.setText(""+(1/Double.parseDouble(numeros[pos])));
			}
			else if(texto.equals("X^Y")&& pos==0) {
				operacao = '^';
				//historico.setText(historico.getText()+"^");
				textField.setText(textField.getText()+"^");
				pos++;
			}
			else if(texto.equals("/")&& pos==0) {
				operacao = '/';
				textField.setText(textField.getText()+"/");
				//historico.setText(historico.getText()+texto);
				pos++;
			}
			else if(texto.equals("*")&& pos==0) {
				operacao = '*';
				textField.setText(textField.getText()+"*");
				//historico.setText(historico.getText()+"*");
				pos++;
			}else if(texto.equals("+")&& pos==0) {
				operacao = '+';
				textField.setText(textField.getText()+"+");
				//historico.setText(historico.getText()+texto);
				pos++;
			}
			else if(texto.equals("-")&& pos==0) {
			
				operacao = '-';
				//historico.setText(historico.getText()+texto);
				textField.setText(textField.getText()+"-");
				pos++;
				
			}else if(texto.equals("=")&& pos==1) {
				
				
				switch(operacao) {
				case '+':
					textField.setText(""+(Double.parseDouble(numeros[0])+Double.parseDouble(numeros[1])));
				break;
				case '-':
					textField.setText(""+(Double.parseDouble(numeros[0])-Double.parseDouble(numeros[1])));
				break;
				case '*':
					textField.setText(""+(Double.parseDouble(numeros[0])*Double.parseDouble(numeros[1])));
				break;
				case '/':
					textField.setText(""+(Double.parseDouble(numeros[0])/Double.parseDouble(numeros[1])));
				break;
				case '^':
					textField.setText(""+(Math.pow(Double.parseDouble(numeros[0]),Double.parseDouble(numeros[1]))));
				break;
					
				}
				historico.setText(historico.getText()+numeros[0]+ operacao + numeros[1] +  "=" + textField.getText()+ "\n");
				pos--;
				operacao=' ';
				numeros[1]="0";
				numeros[0]=textField.getText();
				
				
			}else if(texto.equals(",")) {
				numeros[pos]+='.';
				textField.setText(textField.getText()+".");
			}else if(texto.equals("AC")) {
				textField.setText("0");
				pos = 0;
				operacao=' ';
				numeros[1]="";
				numeros[0]="0";
			}else if(texto.equals("X!") && pos==0) {
				//pos--;
				numeros[1]="0";
				numeros[0]=textField.getText();
				
				textField.setText(""+(Menu.fatorial( (long) Double.parseDouble(numeros[pos]))));
			}else if(texto.equals("Limpar histórico")) {
				historico.setText("");
				
			}
			else if(texto.charAt(0)>='0' && texto.charAt(0)<='9' && texto.length()==1) {
				if(textField.getText().equals("0")) {
					textField.setText("");
					numeros[pos] ="";
				}
				
				numeros[pos]+=texto;
				textField.setText(textField.getText()+texto);
				//historico.setText(historico.getText()+texto);
				
			}
			
	}catch(Exception e) {
			textField.setText("erro de sintaxe");
			pos=0;
			numeros[1]="0";
			numeros[0]="0";
	}
		
		
	}
	
	public static double fatorial(long a) {
		long resultado=1;
		for(long i=a;i>1;i--) {
			resultado*=i;
		}
		return resultado;
	}
	
}
