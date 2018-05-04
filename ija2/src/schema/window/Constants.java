package schema.window;

import java.awt.*;

public interface Constants {

    Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    final static int SCREEN_WIDTH = (int) SCREEN_SIZE.getWidth();
    final static int SCREEN_HEIGHT = (int) SCREEN_SIZE.getHeight();

    final static int BLOCK_WIDTH = 130;
    final static int BLOCK_HEIGHT = 115;
    final static int INDENT = 20;

    final static int BUTTON_WIDTH = 110;
    final static int BUTTON_HEIGHT = 55;

    final static int WORKING_AREA_WIDTH = (SCREEN_WIDTH - 200);
    final static int WORKING_AREA_HEIGHT = (SCREEN_HEIGHT - 150);

    final static int SRC_X = INDENT;
    final static int SRC_Y = INDENT;
    final static int DST_X = SRC_X + BLOCK_WIDTH + INDENT;
    final static int DST_Y = SRC_Y + SCREEN_HEIGHT + INDENT;
}
