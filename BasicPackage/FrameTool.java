package BasicPackage;

import javax.swing.*;
import java.awt.event.*;
import java.util.Timer;

import java.util.TimerTask;

public class FrameTool extends JFrame {
    DropedBlock dropBlock;
    private int mouseX=0;
    private int mouseY=0;
    private int setAccel=60;
    private int frameWidth=1200;
    private int frameHeight=600;
    FrameTool(DropedBlock dropBlock){
        this.dropBlock = dropBlock;
        initFrame(dropBlock);
    }

    public void initFrame(DropedBlock dropBlock){
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new ForTimer(), 500, 18); //눈이 자연스러운 움직임 인식을위해
        // 1초당 24프레임적용시 초당 0.018 => 18ms
        this.dropBlock = dropBlock;  //여기서 막혔었음 인자값을 받아서 이 클래스에서 굴리려고
        //만들어놨던 변수에다 집어넣질 않고 이하의 코드에서는 인자로 들어온 객체를 사용 했음
        setSize(frameWidth,frameHeight);
        setTitle("Droped Box");
        add(this.dropBlock);//마찬가지로 여기서도 this를 이용해서 여기서 정의된 변수를 사용했었어야했음
        addMouseListener(new ForMouseClass()); //마우스 클릭이 안먹혔던이유 마우스 리스너 추가가 안됬음
        addMouseMotionListener(new ForMouseClass()); //마우스 드래그가 안먹혔던 이유 마우스 모션 리스너 추가가 안됬음
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        this.dropBlock.setxPosition(200); //여기서도 마찬가지로 클래스 내에 정의된 객체변수가 아니라 들어온 인자값으로
        //사용했었기에 문제였었음
    }

    void moveCycle () {
//        if(mouseX!=0){
//            this.dropBlock.setxyPosition(mouseX,mouseY);
//        }
        repaint();
        mouseX=0;
        mouseY=0;
    }

    private class ForMouseClass implements MouseListener, MouseMotionListener{
        @Override
        public void mouseClicked(MouseEvent e) {
//            mouseX=e.getX();
//            mouseY=e.getY();
//            System.out.println("Mouse clicked X:Y = "+mouseX+":"+mouseY);

//            dropBlock.setxPosition(+15);  //현재 위치에서 더하기가 아니라 x좌표 15에서 시작해버림..
            //블록 클래스 문제였고 해결함

            dropBlock.setAccel(setAccel);
        }

        @Override
        public void mousePressed(MouseEvent e) {
//            mouseX=e.getX();                      //마우스 클릭시 마우스의 x값 y값에 맞춰 위치 변화
//            mouseY=e.getY();
//            dropBlock.setxyPosition(mouseX,mouseY);
//            repaint();
//            System.out.println("Mouse pressed X:Y = "+mouseX+":"+mouseY);

//            dropBlock.setxPosition(+15);  //현재 위치에서 더하기가 아니라 x좌표 15에서 시작해버림..
            //블록 클래스 문제였고 해결함
            dropBlock.setAccel(setAccel);



        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseDragged(MouseEvent e) {
//            mouseX=e.getX();
//            mouseY=e.getY();
//            dropBlock.setxyPosition(mouseX,mouseY);
//            repaint();
//            System.out.println("Mouse draggedX:Y = "+mouseX+":"+mouseY);

            dropBlock.setxPosition(+5);
            repaint();

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }


    private class ForTimer extends TimerTask{
        @Override
        public void run(){
            moveCycle();
        }
    }
}
