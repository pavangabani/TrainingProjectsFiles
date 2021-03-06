import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;
@ServerEndpoint("/serverendpoint")
public class ServerEndPointDemo {
    @OnOpen
    public void handleOpen(){
        System.out.println("client is now connected");
    }

    @OnMessage
    public String handleMessage(String message){
        System.out.println("receive from client:"+message);
        String replyMessage="echo"+message;
        System.out.println("send to client: "+replyMessage);
        return replyMessage;
    }
    @OnClose
    public void handleClose(){
        System.out.println("client is now disconnected");
    }
    @OnError
    public void handleError(Throwable t){
        t.printStackTrace();
    }
}
