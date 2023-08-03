public class Producer extends Thread
{
    MessageBox box;

    public Producer(MessageBox box)
    {
        super();
        this.box = box;
    }

    public void run()
    {
        for (int i = 1; i <= 20; i++)
        {
            box.put("message " + i);
        }
    }
}