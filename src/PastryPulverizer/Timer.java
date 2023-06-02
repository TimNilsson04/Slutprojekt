package PastryPulverizer;

public class Timer implements Runnable{

    Model model;
    View view;
    private boolean isRunning;

    public synchronized void start() {
        Thread thread = new Thread(this);
        isRunning = model.getPastryBaker().getOwned() > 0;
        thread.start();
    }

    public static void main(String[] args) {
        Timer exempel = new Timer();
    }

    @Override
    public void run() {
        double deltaT = 1000.0 / model.fps;
        long lastTime = System.currentTimeMillis();

        while (isRunning) {
            long now = System.currentTimeMillis();
            if (now - lastTime > deltaT) {
                model.pastries += model.getPastryBaker().getPps();
                lastTime = now;
                view.setTextPane1(model.getMoney());
            }
        }
    }
}


