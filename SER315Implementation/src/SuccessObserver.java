public class SuccessObserver implements Observer {

    /**
    *SuccessObserver
    *Author: Shiree T.
    *Description:
    *Concrete Oberver in the Observer Designn Pattern. 
    *This class listens for status updates from the RacerController
    *It reacts only to successful regiestration messages.
    **/
    @Override
    public void sendStatus(String message){
      if(message.toLowerCase().contains("success") ){
        system.out.printLin("Success Observer: " + message );
      }
    }   
}
