package avaliativo;
import avaliativo.Menu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ListenerBotao implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String texto = e.getActionCommand();
		Menu.clicar(texto);
		
	}
	

}
