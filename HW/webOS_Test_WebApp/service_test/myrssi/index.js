    window.onload = function() {

    function getmypos(){

        // making bridge setting, 
        var bridge = new WebOSServiceBridge();
        var url = 'luna://com.myrssi.app.service/mypos';
        var params = '{}';



        //call back func (if get rssi scanned data, it works)
        function callback(msg){
            var arg = JSON.parse(msg);

            var myx= JSON.parse(msg).x;
            var myy= JSON.parse(msg).y;
            document.getElementById("beacon_top1").innerHTML = JSON.stringify(arg);
            document.getElementById("pos_x").innerHTML = myx;
            document.getElementById("pos_y").innerHTML = myy;

            

        }

        bridge.url = url;
        bridge.onservicecallback = callback;
        setInterval(() => {
            bridge.call(url, params);
        }, 1000);
        

        
    }


    document.getElementById("txt_msg").onclick = function(){
        
        if(document.getElementById("txt_msg").innerHTML === "Hello, This is RSSI TEST!!"){
            document.getElementById("txt_msg").innerHTML = "Let's START!";
            setTimeout(function(){
                document.getElementById("txt_msg").innerHTML = "Measuring...";
            }, 3000);

            getmypos();
        }
        else{
            document.getElementById("txt_msg").innerHTML = "Restarted!";
            setTimeout(function(){
                document.getElementById("txt_msg").innerHTML = "Measuring...";
            }, 3000);
        }

    };   
    }