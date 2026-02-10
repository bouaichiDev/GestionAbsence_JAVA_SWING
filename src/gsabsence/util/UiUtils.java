/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gsabsence.util;

/**
 *
 * @author badrBouaichi
 */
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class UiUtils {

    private static Image APP_ICON = new ImageIcon(
        UiUtils.class.getResource("/images/GsAbsence-icon.png")
    ).getImage();

    public static void setAppIcon(JFrame frame) {
        frame.setIconImage(APP_ICON);
    }

    public static Image getAppIcon() {
        return APP_ICON;
    }
}
