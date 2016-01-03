package pa07;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * creates an action listener for the AddFriendsButton which will call the addFriends() method
 * @author Vanessa
 *
 */
public class AddFriendsActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent b) {
		Network.enterFriendInfo();

	}

}
