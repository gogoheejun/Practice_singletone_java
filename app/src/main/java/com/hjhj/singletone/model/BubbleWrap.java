package com.hjhj.singletone.model;

public class BubbleWrap {
    private static final int ADD_MORE_BUBBLES = 10;
    private int numBubbles;

//    singletone support
    private static BubbleWrap instacne;
    private BubbleWrap(){
        //Private to prevent anyone else from instantiate
    }
    public static BubbleWrap getInstance(){
        if(instacne == null){
            instacne = new BubbleWrap();
        }
        return instacne;
    }


//    Normal object code
    public int getNumBubbles() {
        return numBubbles;
    }

    public void addMoreBubbles(){
        numBubbles += ADD_MORE_BUBBLES;
    }

    public void popBubble() {
        numBubbles--;
    }
}
