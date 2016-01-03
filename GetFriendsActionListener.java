package pa07;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * creates an action listener for the getFriendsButton which will call the getFriendNames() method
 * @author Vanessa
 */
public class GetFriendsActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Network.getFriendNames();

	}

}
