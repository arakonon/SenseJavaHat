import rpi.sensehat.api.SenseHat;
import rpi.sensehat.api.dto.Color;
public class Flugbahn {
    

    public static void main(String[] args){
        SenseHat senseHat = new SenseHat();
        Color pixelColor = Color.GREEN;
        Ball ball = new Ball();
        
        while(true){
            int x = ball.woIstBallX();
            int y =ball.woIstBallY();
            senseHat.ledMatrix.setPixel(x, y, pixelColor);
            ball.fliegX();
            ball.fliegY();
            senseHat.ledMatrix.clear();
        }

    }
}
