package shushangshixun.shixun10;

public class s2 implements Runnable{
    int mum = 10;
    public synchronized void s(){
        if(mum > 0){
            try{
                Thread.sleep(100);
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "˵��num��ֵΪ" + mum--);
        }
    }
    public void run() {
        for(int i = 0; i < 10;i++){
            s();
        }
    }
    public static void main(String[] args){
        s2 t = new s2();
        Thread t1 = new Thread(t, "t1");
        Thread t2 = new Thread(t, "t2");
        t1.start();
        t2.start();
    }
}
