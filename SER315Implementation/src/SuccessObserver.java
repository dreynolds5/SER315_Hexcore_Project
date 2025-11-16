public class SuccessObserver implements Observer {

    /**
    *SuccessObserver
    *Author: Shiree T.
    *Date: 11/15/2025
    *
    *Description:
    *Concrete Oberver in the Observer Designn Pattern. 
    *This class listens for status updates from the RacerController
    *It reacts only to successful regiestration messages.
    *Note: 
    *-Implements Observer interface.
    *-Prints a message when the racer failed to register
    **/
    @Override
    public void sendStatus(String message){
      if(message.toLowerCase().contains("success") ){
        system.out.printLin("Success Observer: " + message );
      }
    }   
}
