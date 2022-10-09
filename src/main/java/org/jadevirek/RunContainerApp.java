//package org.jadevirek;
//
//import io.reactivex.rxjava3.core.Flowable;
//import io.reactivex.rxjava3.core.Observable;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.stream.Stream;
//
//public class RunContainerApp {
//    private static String result="";
//    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);
//
//    public static void main(String[] args) throws InterruptedException, IOException {
////        System.out.println("Start...");
////        System.out.println("Result -> " + result);
////        Thread.sleep(2000);
////        Flowable.just("Hello world").subscribe(System.out::println);
//////        getObservableStream();
////        tester(getObservableStream());
////        System.out.println("Result END -> " + result);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//     1
//        String[] inputString = br.readLine().split("\\s");
//
//        System.out.println(Arrays.stream(inputString).mapToInt(Integer::valueOf).sum());
//    }
//
//    private static  Void getObservableStream() {
//        Observable.create(emitter -> {
//            while (!emitter.isDisposed()) {
//                long time = System.currentTimeMillis();
//                emitter.onNext(time);
//                System.out.println("Doing");
//                if (time % 2 != 0) {
//                    emitter.onError(new IllegalStateException("Odd millisecond!"));
//                    break;
//                }
//            }
//        })
//                .subscribe(System.out::println, Throwable::printStackTrace);
//        return null;
//    }
//
//    private static void tester(Void e ){
//        String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
//        Observable<String> observable = Observable.fromArray(letters);
//        observable.subscribe(
//                i -> result += i,  //OnNext
//                Throwable::printStackTrace, //OnError
//                () -> result += "_Completed" //OnCompleted
//        );
//    }
//}
