package hardwired;

public class View
{
    public boolean isRendering()
    {
        return IsRendering;
    }

    public void handleAsyncTask(String finalResultOfAsyncTask)
    {
        System.out.printf("Displaying async task result: %s%n", finalResultOfAsyncTask);
    }

    private static boolean IsRendering = true;
}
