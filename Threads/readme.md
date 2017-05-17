# Threads

Java Concurrency: Threads and Executors

* Build tasks, create threads --- Runnable()
* Sleep duration --- TimeUnit.SECONDS.sleep() / Thread.sleep()\
* Running asynchronous tasks --- ExecutorService()
* * start --- Executors.newSingleThreadExecutor()
* * end --- shutdown() & shutdownNow()
* * Callable & Future
* * * return a value
* * * executor.submit(task)
* * * retrieve the result --- future.get()
* * * check if done --- future.isDone()
* * * submitting multiple callables --- invokeAll() / invokeAny()
* * Schedule executors --- ScheduleFuture
* * * retrive the remaining delay --- getDelay()
* * * scheduleAtFixedRate() --- executing tasks with a fixed time rate
* * * scheduleWithFixedDelay() --- wait time period applies between the end of the task and the start of the next task
