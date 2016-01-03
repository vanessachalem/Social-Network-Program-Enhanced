package pa07;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * creates an action listener for the SignOut which will call the exit() method
 * @author Vanessa
 */
public class SignOutListener implements ActionListener {
	public void actionPerformed(ActionEvent arg0) {
		Network.exit();

	}

}
