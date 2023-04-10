window.onload = function() {


    var cnt = 0;
    var intervalcnt = 0;


// document.getElementById("txt_msg").innerHTML = JSON.stringify(arg);

var device_N
var isinitialized;
var processNoise;
var measurementNoise;
var predictedRSSI;
var errorCovariance;
var cnt_arr;
var total_rssi_arr;

function init(){
    cnt = 0; intervalcnt = 0;
    ///KALMAN FILTER
    isinitialized = [
        [0,0,0],
        [0,0,0],
        [0,0,0]
    ];
    processNoise = [
        [0.005,0.005,0.005],
        [0.005,0.005,0.005],
        [0.005,0.005,0.005]
    ];
    measurementNoise = [
        [20,20,20],
        [20,20,20],
        [20,20,20]
    ];
    predictedRSSI = [
        [0,0,0],
        [0,0,0],
        [0,0,0]
    ];
    errorCovariance = [
        [0,0,0],
        [0,0,0],
        [0,0,0]
    ];

    //CALC AVG.
    cnt_arr =   [
        [0,0,0],
        [0,0,0],
        [0,0,0]
    ];
    total_rssi_arr =[
        [0,0,0],
        [0,0,0],
        [0,0,0]
    ];
}


function subscribe_rssi(){
    let beacon_N // 

    var bridge = new WebOSServiceBridge();
    var url = 'luna://com.webos.service.bluetooth2/le/startScan';
    var params = '{"subscribe":true,"name":"ESP32"}';
    var lst_rssi = [
        [0,0,0],
        [0,0,0],
        [0,0,0]
    ];

    //
    function callback(msg){
        cnt++;
        var arg = JSON.parse(msg);
        console.log("Response:",arg);
        lst_rssi = [
            [0,0,0],
            [0,0,0],
            [0,0,0]
        ];
        device_N = JSON.parse(msg).devices.length;
        for (var i = 0; i < device_N ; i++){
            var arg = JSON.parse(msg).devices[i].rssi;//.rssi 시 undefined

            var mjnum = JSON.parse(msg).devices[i].manufacturerData.data[19] - 1;
            var mnnum = JSON.parse(msg).devices[i].manufacturerData.data[21] - 1;
            lst_rssi[mjnum][mnnum] = arg;
        }
    }
    ////////////////////////////////////////////////////////////////////



    setInterval(() => {
        beacon_N = 0
        intervalcnt++;
        document.getElementById(`interval_cnt`).innerHTML =intervalcnt;
        for(let x = 0 ; x < 3; x ++){
            for(let y = 0; y < 3; y ++){

                if(lst_rssi[x][y]){
                    beacon_N++;
                    let rssi = lst_rssi[x][y];
                    
                    cnt_arr[x][y]++;
                    total_rssi_arr[x][y] += rssi;
                    document.getElementById(`average_${x+1}${y+1}`).innerHTML = (total_rssi_arr[x][y]/cnt_arr[x][y]).toFixed(4)*1;
                    document.getElementById(`beaconcnt_${x+1}${y+1}`).innerHTML = cnt_arr[x][y];
                    let priorRSSI,priorErrorCov;
                    if(!(isinitialized[x][y])){
                        isinitialized[x][y] = 1;
                        priorRSSI = rssi;
                        priorErrorCov = 1;
                    }
                    else{
                        priorRSSI = predictedRSSI[x][y];
                        priorErrorCov = errorCovariance[x][y] + processNoise[x][y];
                    }

                    let mNoise = measurementNoise[x][y];
                    let kalmanGain = priorErrorCov / (priorErrorCov + mNoise);
                    predictedRSSI[x][y] = priorRSSI +(kalmanGain * (rssi - priorRSSI));
                    errorCovariance[x][y] = (1 - kalmanGain) * priorErrorCov;
                    document.getElementById(`rssi_${x+1}${y+1}`).innerHTML = lst_rssi[x][y];
                    document.getElementById(`predict_${x+1}${y+1}`).innerHTML = predictedRSSI[x][y];
                }
            }
        }


        document.getElementById("cnt_N").innerHTML =cnt;
        document.getElementById("beaconN").innerHTML =beacon_N;


    }, 2000);

    bridge.url = url;
    bridge.onservicecallback = callback;
    bridge.call(url, params);

}


document.getElementById("txt_msg").onclick = function() {
    
    if(document.getElementById("txt_msg").innerHTML === "Hello, This is RSSI TEST!!"){
        document.getElementById("txt_msg").innerHTML = "Predict START!";
        setTimeout(function(){
            document.getElementById("txt_msg").innerHTML = "Predicting...";
        }, 2000);
        init();
        subscribe_rssi();
    }
    else{
        init();
        document.getElementById("txt_msg").innerHTML = "Restarted!";
        setTimeout(function(){
            document.getElementById("txt_msg").innerHTML = "Predicting...";
        }, 2000);
    }

};
}