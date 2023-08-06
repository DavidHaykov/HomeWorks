
public class Consumer extends Thread
{
    MessageBox box;
//	public volatile boolean running = true;

    public Consumer(MessageBox box)
    {
        super();
        this.box = box;
    }

    public void run()
    {
        while (true)
        {
            String message;
            try
            {
                message = box.take();
                printMessage(message);
            } catch (InterruptedException e)
            {
                message = box.pull();
                if(message != null)
                    printMessage(message);
                break;
            }

        }
    }

    private void printMessage(String message)
    {
        System.out.printf("Thread: %s, id: %d, message: %s\n", getName(), getId(), message);
    }
}
