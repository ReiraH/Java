public class RheaThread extends Thread {
    
    private boolean isRunning; // getters en setters toevoegen

    public RheaThread() {
        isRunning = true;
    }
    
    public boolean getIsRunning() {
        return isRunning;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }
            
    public void run() {
        int c = 0;
        while(isRunning) {
            System.out.println("Count : " + c);
                    c++;
        }
    }
    
}
