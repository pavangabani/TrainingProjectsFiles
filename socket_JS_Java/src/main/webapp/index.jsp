<html>
<body>
<form>
    Message: <input id="textMessage" type="text">
    <input type="button" value="Send" onclick="sendMessage();">
</form><br>
<textarea id="messageTextArea" rows="10" cols="50"></textarea>
<script type="text/javascript">
    var webSocket=new WebSocket("ws://localhost:8080/socket_JS_Java/serverendpoint");
    var messageTextArea=document.getElementById("messageTextArea");
    var textMessage=document.getElementById("textMessage");
    webSocket.onopen=function (message) { processOpen(message);};
    webSocket.onmessage=function (message){processMessage(message);};
    webSocket.onclose=function (message){processClose(message);};
    webSocket.onerror=function (message) {processError(message);};
    function  processOpen(message){
        messageTextArea.value+="Server Connet"+"\n";
    }
    function processMessage(message){
        messageTextArea.value+="Receiver From Server==>"+message.data+"\n";
    }
    function sendMessage(){
        if(textMessage.value!="close"){
            webSocket.send(textMessage.value);
            messageTextArea.value+="send to server ==>"+textMessage.value+"\n";
            textMessage.value="";
        }else webSocket.close();
    }
    function processClose(message){
        webSocket.send("client disconnected");
        messageTextArea.value+="server Disconected"+"\n";
    }
    function  processError(message){
        messageTextArea.value+="error"+"\n";
    }


</script>
 </body>
</html>
