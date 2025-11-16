public interface Observer {
    /**
    * Oberver Interface
    * Author: Shiree T.
    * Date: 11/15/2025
    *
    * Description:
    * This is the interface that defines the Observer in the
    * Design Pattern.
    * Any class that implements this interface must define the
    * sentStatus() method to recieve success or failure 
    * notifications from the subject (RacerController).
    *
    * Notes:
    * -sentStatus() is used to used to notify observers when
    *  a registration attempt succeeds or fail. 
    * -Concret class: SuccessObercer, FailObserver
    **/
    void sendStatus(String message);
}
