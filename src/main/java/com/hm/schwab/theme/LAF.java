package com.hm.schwab.theme;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class LAF {
	public static void applyTheme() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) { }
	}
}
