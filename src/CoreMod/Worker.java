package CoreMod;

@FunctionalInterface
interface OnTaskDoneListener{
    void onDone(String result);
}

@FunctionalInterface
interface OnTaskErrorListener{
    void onError(String result);
}

public class Worker {
    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback){
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void startWork(){
        for (int i = 1; i <= 40; i++){
            if (i != 33)
                callback.onDone("Task " + i + " is done");
            else
                errorCallback.onError("Task " + i + " is failed");
        }
    }
}
