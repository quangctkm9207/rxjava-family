# RxJava Family - A collection of step-by-step examples to bring ReactiveX into Android development. 

## Content  
1. [RxJava](#1.RxJava)
2. [RxAndroid](#2.RxAndroid)
3. [RxBinding](#3.RxBinding)
4. [RxLifecycle](#4.RxLifecycle)
5. [RxRelay](#5.RxReplay)  

## 1.RxJava
Demonstrates some basic operators in RxJava.  
#### Create
Create an Observable from scratch by calling observer methods programmatically.  
<img src="http://reactivex.io/documentation/operators/images/create.png" width="400" />  

#### Map
Transform the items emitted by an Observables by applying a function to each item.  
<img src="http://reactivex.io/documentation/operators/images/map.png" width="400" />  
  
#### FlatMap
Transform the items emitted by an Observable into Observables, then flatten the emissions.  
<img src="http://reactivex.io/documentation/operators/images/flatMap.png" width="400" />  
  
#### Filter
Emit only those items from an Observable that pass a predicate test.  
<img src="http://reactivex.io/documentation/operators/images/filter.png" width="400" />  

#### Zip
Combine the emissions of multiple Observables together via a specified function and emit single items for each combination based on the results of this function.  
<img src="http://reactivex.io/documentation/operators/images/zip.png" width="400" />  

#### Reduce
Apply a function to each item emitted by an Observable, sequentially, and emit the final value.  
<img src="http://reactivex.io/documentation/operators/images/reduce.png" width="400" />  

Those above images are all credited to [ReactiveX](http://reactivex.io/) and the complete list of all operators can be found at [ReactiveX Operators](http://reactivex.io/documentation/operators.html).  
*TODO*: It would be updated with as many operators as possible.  

## 2.RxAndroid
When developing Android apps, you generally use observeOn() to send background work's result to Android main UI thread.  
That is the reason why you need RxAndroid to provide a Scheduler that schedules on the main thread or any given Looper.  

## 3.RxBinding
It converts UI events into Observables so that these events are handled in a much more simple, consistent and concise way.  

## 4.RxLifecycle
RxJava is awesome to develop Android apps as we have seen so far. 
It, however, has a major drawback that is the potential of memory leaks caused by incomplete subscriptions.
It eventually causes Out Of Memory error in your Android app.  
To deal with this problem, thanks to developers in Trello, we have RxLifecycle library to limit the lifespan of an Observable.  

## 5.RxReplay


