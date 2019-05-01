package BasicPackage;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;

public class DropedBlock extends JPanel {
    private int xPosition;
    private int yPosition;
    private int blockHeight=100;
    private int blockWidth=100;
    private int blockWeight=10;
    private int gravity=1;
    private int acceleration=0;
    private int tmpx=0;
    private int tmpy=0;
    private int tmpaccel=0;
    DropedBlock() {

    }

    public void initBlock(){

    }

    public void paint(Graphics g){
        super.paint(g);
        drawBlock(g);
//        setxPosition();
        effectGravity();
        if(tmpx!=xPosition||tmpy!=yPosition||tmpaccel!=acceleration) {
            System.out.println("X Position : " + xPosition + " Accel : " + acceleration);
            tmpx=xPosition;
            tmpy=yPosition;
            tmpaccel=acceleration;
        }
    }

    public void drawBlock(Graphics g){
        g.drawRect(xPosition,yPosition,blockWidth,blockHeight);
    }

    public void effectGravity(){
        if((xPosition>0)||(acceleration>0))
        {
            acceleration=acceleration-(gravity*blockWeight);
            xPosition=xPosition+acceleration;
        }
        if(xPosition<0){
            xPosition=0;
        }
        accelCheck();
    }

    public void accelCheck(){
        if((acceleration!=0)&&(xPosition==0)){
            acceleration=acceleration*-1;
        }
    }
    public void setxPosition() {
        repaint();
    }

    public  void setxPosition(int xPosition){
        this.xPosition=this.xPosition+xPosition; //clicked, pressed, 드래그시 위치 더하기를 위해서는
        //this.xPosition = xPosition 으로 설정하면 안됨 들어오는 인자값으로 x위치가 세팅되기 때문에
        repaint();
    }

    public void setAccel(int acceleration){
        this.acceleration = acceleration;
    }

    public void setBlockWeight(int weight){
        this.blockWeight=weight;
    }
    public void setxyPosition(int xPosition, int yPosition){
        this.xPosition =xPosition;
        this.yPosition =yPosition;
    }
    public void setGravity(int i){
        this.gravity = i;
    }

}
