import rpi.sensehat.api.SenseHat;
import rpi.sensehat.api.dto.JoystickEvent;
import rpi.sensehat.api.dto.joystick.Direction;
import rpi.sensehat.api.dto.Color;
import rpi.sensehat.api.dto.joystick.Action;

public class JoystickPixelMover {
    public static void main(String[] args) {
        SenseHat senseHat = new SenseHat();
        int x = 3;  // Startposition in der Mitte der 8x8-Matrix
        int y = 3;

        Color pixelColor = Color.GREEN;  // Farbe des bewegten Pixels (Grün)
        senseHat.ledMatrix.clear();

        while (true) {
            // Setze den aktuellen Pixel und lösche die vorherige Position
            senseHat.ledMatrix.clear();
            senseHat.ledMatrix.setPixel(x, y, pixelColor);

            // Warte auf ein Joystick-Ereignis
            JoystickEvent event = senseHat.joystick.waitForEvent();

            // Verarbeite die Richtung des Joysticks
            if (event.getAction() == Action.PRESSED) {
                Direction direction = event.getDirection();

                // Bewegung basierend auf der Richtung
                switch (direction) {
                    case UP:
                        if (y > 0) y--;  // Bewege den Pixel nach oben
                        break;
                    case DOWN:
                        if (y < 7) y++;  // Bewege den Pixel nach unten
                        break;
                    case LEFT:
                        if (x > 0) x--;  // Bewege den Pixel nach links
                        break;
                    case RIGHT:
                        if (x < 7) x++;  // Bewege den Pixel nach rechts
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
