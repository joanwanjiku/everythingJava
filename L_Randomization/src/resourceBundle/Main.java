package resourceBundle;

import javax.swing.*;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        for (Locale l : List.of(Locale.US, Locale.CANADA_FRENCH, Locale.CANADA)) {
            ResourceBundle rb = ResourceBundle.getBundle("BasicText", l);

            System.out.printf("%s %s!%n", rb.getString("hello"), rb.getString("world"));

            String message = "%s %s!%n".formatted(rb.getString("hello"), rb.getString("world"));
            ResourceBundle ui = ResourceBundle.getBundle("UIcomponents", l);
            JOptionPane.showOptionDialog(null,
                    message, ui.getString("first.title"),
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    new Object[]{ui.getString("btn.ok")},
                    null);
        }

    }
}
