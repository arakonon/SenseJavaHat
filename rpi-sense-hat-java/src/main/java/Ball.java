public class Ball {
    public int nowX = 3; //Ball startet bei 3,3
    public int nowY = 3;
    public int pastX = 3; //Ball kommt am Start von unten
    public int pastY = 4;

    public Ball(){
        nowX = 3; //Ball startet in der mitte (3,3)
        nowY = 3;
        pastX = 3; //Ball kommt, am Start, von unten
        pastY = 4;
    }

    public int woIstBallX(){
        return nowX;
    }
    public int woIstBallY(){
        return nowY;
    }
    public int woWarBallX(){
        return pastX;
    }
    public int woWarBallY(){
        return pastY;
    }
    public void jetztX(int istX){
        nowX = istX;
    }
    public void jetztY(int istY){
        nowY = istY;
    }

    //X Achsen Bewegung 
    public void fliegX(){
        int xIst = 0;
        int jetztX = woIstBallX();
        int warX = woWarBallX();

        if(jetztX == warX){ //Ball bleibt auf xLinie
            xIst = jetztX;
        } 
        else if(jetztX > warX){ //Ball geht nach rechts auf xLinie
            xIst = jetztX + 1;
        }
        else if(jetztX < warX){ //Ball geht nach links auf xLinie
            xIst = jetztX - 1;
        }
        else{
            System.out.println("X-Achsen Error");
        }
        jetztX(xIst);
    }
    //Y Achsen Bewegung
    public void fliegY(){
        int yIst = 0;
        int jetztY = woIstBallY();
        int warY = woWarBallY();

        if(jetztY < warY){ //Ball geht nach Oben
            yIst = jetztY - 1;
        }
        else if(jetztY > warY){ //Ball geht nach Unten
            yIst =jetztY +1;
        }
        else if(jetztY == warY){ 
            System.out.println("Y-Achsen Error, Ball ist zur Seite geflogen");
        }
        else{
            System.out.println("X-Achsen Error");
        }
        jetztY(yIst);
    }

    

}
