import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Threads {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		/*concurrent execution
		 * cannot predict if the runnable will be invoked before or after printint "Done!"\
		 * result maybe:
		 *  	Hello main
		 *  	Done!
		 *  	Hello Thread-0
		 *  or
		 *  	Hello main
		 *  	Hello Thread-0
		 *  	Done!
		 *  	*/
		/*//Runnable is a lambda function to print current threads name
		Runnable task = ()->{
			String threadName = Thread.currentThread().getName();
			System.out.println("Hello " + threadName);
		};
		task.run();
		
		Thread thread = new Thread(task);
		thread.start();
		
		System.out.println("Done!");*/
		
		
		
		
		/*archieve one second delay in the thread
		 * 		Foo Thread-0
		 * 		Bar Thread-0*/
		/*Runnable runnable = () -> {
			try{
				String name = Thread.currentThread().getName();
				System.out.println("Foo " + name);
				//one second delay
				//also can use Thread.sleep(1000);
				TimeUnit.SECONDS.sleep(1);
				System.out.println("Bar " + name);
			} 
			catch (InterruptedException e){
				e.printStackTrace();
			}
		};
		
		Thread thread = new Thread(runnable);
		thread.start();*/
		
		
		/*executors	
		 * use an executor with a thread pool of size one
		 * this java process never stops
		 * executors have to be stopped explicitly - otherwise they keep listening for new tasks
		 * can use shutdown() waits for currently running tasks to finish while shutdownNow() interrupts all running tasks and shut the executor down immediately
		 * 		Hello pool-1-thread-1
		 * 		attempt to shutdown executor
		 * 		cancel non-finished tasks
		 * 		shutdown finished*/
		/*ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(()->{
			//result:		Hello pool-1-thread-1
			String threadName = Thread.currentThread().getName();
			System.out.println("Hello " + threadName);
			
			//executor shuts down softly by waiting a certain amount of time for termination of current tasks
			//after a maximum of five seconds, the executor finally shuts down by interruptin all running tasks
			try{
				System.out.println("attempt to shutdown executor");
				executor.shutdown();
				executor.awaitTermination(5, TimeUnit.SECONDS);
			}
			catch (InterruptedException e){
				System.err.println("tasks interrupted");
			}
			finally{
				if (!executor.isTerminated()){
					System.err.println("cancel non-finished tasks");
				}
				executor.shutdownNow();
				System.out.println("shutdown finished");
			}
		});*/
		
		
		
		/*Callables and Futures
		 * after first isDone(), return false, since the above callable sleeps for one second before returning the integer
		 * calling the method get() blocks the current thread and waits until the callable completes before returning the actual result 123
		 * now the future is finally done and we see the following result:
		 * 		future done? false
		 * 		futre done? true
		 * 		result: 123*/
		/*Callable<Integer> task = ()->{
			try{
				TimeUnit.SECONDS.sleep(2);
				return 123;
			}
			catch(InterruptedException e){
				throw new IllegalStateException("task interrupted", e);
			}
		};
		
		//use newFixedThreadPool(1) to create an executor service backed by a thread-pool of size one
		//equivalent to newSingleThreadExecutor(), we could later increase the pool size by simply passing a value larger than one
		ExecutorService executor = Executors.newFixedThreadPool(1);
		Future<Integer> future = executor.submit(task);
		
		System.out.println("future done? " + future.isDone());
		
		//if add the shutdownNow(), it will throw exception error
		//executor.shutdownNow();
		Integer result = future.get();
		
		System.out.println("futre done? " + future.isDone());
		System.out.println("result: " + result);*/
		
		
		
		/*timeout
		 * we specified a maximum wait time of one second but the callable actually needs 2 seconds before returning the result
		 * throw error
		 * 		Exception in thread "main" java.util.concurrent.TimeoutException
		 * 		at java.util.concurrent.FutureTask.get(FutureTask.java:205)
		 * 		at Threads.main(Threads.java:141)*/
		/*ExecutorService executor = Executors.newFixedThreadPool(1);
		
		Future<Integer> future = executor.submit(()->{
			try{
				TimeUnit.SECONDS.sleep(2);
				return 123;
			}
			catch (InterruptedException e){
				throw new IllegalStateException("task interrupted ", e);
			}
		});
		
		future.get(1, TimeUnit.SECONDS);*/
		
		
		
		/*invokeAll()
		 * 		task1
		 * 		task2
		 * 		task3*/
		/*ExecutorService executor = Executors.newWorkStealingPool();
		
		List<Callable<String>> callables = Arrays.asList(
				()->"task1",
				()->"task2",
				()->"task3");
		
		//use streams in order to process all futures returned by the invocation of invokeAll
		//first map each future t oits return value
		//then print each value
		executor.invokeAll(callables).stream().map(future->{
			try{
				return future.get();
			}
			catch(Exception e){
				throw new IllegalStateException(e);
			}
		}).forEach(System.out::println);*/
		
		
		
		/*invokeAny()
		 * returns the string result of the fastest callable -
		 * 		task2*/
		/*//newWorkStealingPool() -- part of Java 8, return an executor of type ForkJoinPool which works slightly different than normal executors
		//instead of using a fixed size thread-pool ForkJoinPools are created for a given parallelism size which per default is the number of available cores of the hosts CPU
		ExecutorService executor = Executors.newWorkStealingPool();
		
		//create a bunch of callables with different durations from one to three seconds
		List<Callable<String>> callables = Arrays.asList(
				callable("task1", 2),
				callable("task2", 1),
				callable("task3", 3));
		
		String result = executor.invokeAny(callables);
		System.out.println(result);*/
		
		
		
		/*Scheduled Executor
		 *  --- 1
		 * 		Remaining Delay: 1659msScheduling: 70513913728080
		 *  --- 2 -- scheduleAtFixedRate
		 *  	Scheduling: 70719809607957
		 *  	Scheduling: 70720811996350
		 *  	Scheduling: 70721811289743
		 *  		...
		 *  --- 2 -- scheduleWithFixedDelay
		 *  	Scheduling: 71340178400333
		 *  	Scheduling: 71343185148670
		 *  	Scheduling: 71346192036429
		 *  		...*/
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		
		/////////////////////////////////   --- 1
		//Runnable task = ()->System.out.println("Scheduling: " + System.nanoTime());;
		
		//ScheduledFuture --- in addition to Future, provides the method getDelay() to retrieve the reamining delay
		//after this delay has elapsed the task will be executed concurrently
		//ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);
		
		//TimeUnit.MILLISECONDS.sleep(1337);
		
		//long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
		//System.out.printf("Remaining Delay: %sms", remainingDelay);
		
		////////////////////////////////   --- 2 -- scheduleAtFixedRate
		//schedule task to be executed periodically,
		//use scheduleAtFixedRate() and scheduleWithFixedDelay()
		//scheduleAtFixedRate() --- executing tasks with a fixed time rate
			//doesn't take into account the actual duration of the task
		//Runnable task = ()->System.out.println("Scheduling: " + System.nanoTime());;

		//int initialDelay = 0;  // --- describes the leading wait time before the tasks will be executed for the first time
		//int period = 1;
		//every second
		//executor.scheduleAtFixedRate(task, initialDelay, period, TimeUnit.SECONDS);
		
		////////////////////////////////   --- 2 -- scheduleWithFixedDelay
		//wait time period applies between the end of a task and the start of the next task
		Runnable task = ()->{
			try{
				TimeUnit.SECONDS.sleep(2);
				System.out.println("Scheduling: " + System.nanoTime());
			}
			catch(InterruptedException e){
				System.err.println("task interrupted");
			}
		};
		
		//with a fixed delay of one second between the end of an execution and the start of the next execution
		//initial delay is 0, tasks duration is 2 seconds
		//end up with an execution interval of 0s, 3s, 6s, 9s, and so on
		executor.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS);
	}
	
	//help function for invokeAny()
	//simulate callables with different duration
	//return a callable that sleeps for a certian amount of time until returning the given result
	public static Callable<String> callable(String result, long sleepSeconds){
		return ()->{
			TimeUnit.SECONDS.sleep(sleepSeconds);
			return result;
		};
	}
}
