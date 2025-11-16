public class FailedObserver implements Observer {
      /**
    *FailObserver
    *Author: Shiree T.
    *Date:11/15/2025
    *
    *Description:
    *Concrete Oberver in the Observer Designn Pattern. 
    *This class listens for status updates from the RacerController
    *It only reacts to failed registered racers.
    *
    *Note: 
    *-Implements Observer interface.
    *-Prints a message when the racer failed to register
    **/
    @Override
    public void sendStatus(String message){
      if(message.toLowerCase().contains("fail") ){
        system.out.printLin("Fail Observer: " + message );
      }
    }   
}
