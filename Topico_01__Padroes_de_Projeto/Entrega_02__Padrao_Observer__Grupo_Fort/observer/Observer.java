package observer;

public class Observer
{
    public static void main(String[] args)
    {
        AsyncTaskObservable asyncTaskObservable = new AsyncTaskObservable();

        asyncTaskObservable.subscribe(result -> System.out.printf("Task finished! Result is %s%n", result));
        asyncTaskObservable.subscribe(new AnalyticsSystem(asyncTaskObservable));
        asyncTaskObservable.subscribe(new View());
        asyncTaskObservable.subscribe(new DatabaseConnection());
    }
}
