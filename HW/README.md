
자바스크립트에서 service api 쓰는 법.

```js
    function getmypos(){

        // making bridge setting, 
        var bridge = new WebOSServiceBridge();
        var url = 'luna://com.myrssi.app.service/mypos';
        var params = '{}';

        var myx = 0;
        var myy = 0;
        //call back func (if get rssi scanned data, it works)
        function callback(msg){
            var arg = JSON.parse(msg);

            myx= JSON.parse(msg).x;
            myy= JSON.parse(msg).y;
            // document.getElementById("pos_x").innerHTML = myx;
            // document.getElementById("pos_y").innerHTML = myy;
        }

        bridge.url = url;
        bridge.onservicecallback = callback;
        setInterval(() => {
            bridge.call(url, params);

            //realtime action here//

            // 1초마다 위치 얻어오고, 좌표는 myx, myy임.
            // css 수정 같은 거 넣으면 됨.

            ////////////////////////
        }, 1000);
    }

    getmypos();
```
