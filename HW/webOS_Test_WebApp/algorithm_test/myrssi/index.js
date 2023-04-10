window.onload = function() {

var cnt = 1, mtp = 3;
var beacon_rssi_list =[
    [-200,-200,-200],
    [-200,-200,-200],
    [-200,-200,-200]
];
var bc_1m_table =[
    [-48,-51,-53],
    [-59,-59,-47],
    [-51,-48,-44]
];
var top_bc_cnt = [
    [0,0,0],
    [0,0,0],
    [0,0,0]
];
var top_bc_filter = 2;
//
var bc_X = [
    [0,0,0],
    [8,8,8],
    [16,16,16]
];
var bc_Y = [
    [0,4,8],
    [0,4,8],
    [0,4,8]
];




var top_bc_xidx =-1, top_bc_yidx = -1;


// .
function get_top_rssi(){
    let top_x=-1, top_y= -1;
    let temp_top_rssi = -200;
    for(let x = 0; x < 3 ; x ++){
        for(let y = 0; y < 3; y++){
            let cur_rssi = beacon_rssi_list[x][y];
            if(cur_rssi > temp_top_rssi){
                top_x = x;
                top_y = y;
                temp_top_rssi = cur_rssi;
            }
        }
    }
    if(top_bc_cnt[top_x][top_y]){
        top_bc_cnt[top_x][top_y]++;
        if(top_bc_cnt[top_x][top_y]>top_bc_filter){
            top_bc_xidx = top_x;
            top_bc_yidx = top_y;
        }    
    }
    else{
        top_bc_cnt = [[0,0,0],[0,0,0],[0,0,0]];
        top_bc_cnt[top_x][top_y]++;
    }
};


function subscribe_rssi(){
    let beacon_N = 0;
    // making bridge setting, 
    var bridge = new WebOSServiceBridge();
    var url = 'luna://com.webos.service.bluetooth2/le/startScan';
    var params = '{"subscribe":true,"name":"ESP32"}';
    // show dist. between beacons  
    
    //call back func (if get rssi scanned data, it works)
    function callback(msg){
        beacon_N = 0;
        cnt++;
        document.getElementById("cnt_N").innerHTML =cnt;
        var arg = JSON.parse(msg);

        var device_N = JSON.parse(msg).devices.length;

        beacon_rssi_list =[[-200,-200,-200],[-200,-200,-200],[-200,-200,-200]];
        for (var i = 0; i < device_N ; i++){
            var arg = JSON.parse(msg).devices[i].rssi;//.rssi 시 undefined
            // beacon has major_id, minor_id. with means [x,y] index. so need to be mtp with mtp. cf => [1,1]  => [5m, 5m]  
            var major_num = JSON.parse(msg).devices[i].manufacturerData.data[19];
            var minor_num = JSON.parse(msg).devices[i].manufacturerData.data[21];
            beacon_rssi_list[major_num-1][minor_num-1] = arg;
        }
        for(let x = 0; x < 3 ; x ++){
            for(let y = 0 ; y < 3 ; y ++){
                if(beacon_rssi_list[x][y]>-100){
                    beacon_N++;
                }
            }
        }

        get_top_rssi(beacon_rssi_list);


        document.getElementById("beacon_top1").innerHTML =  `ID : ${top_bc_xidx+1}  ${top_bc_yidx+1}`;
        document.getElementById("pos").innerHTML =`${bc_X[top_bc_xidx][top_bc_yidx]}m, ${bc_Y[top_bc_xidx][top_bc_yidx]}m`;
        document.getElementById("beaconN").innerHTML = beacon_N;

        // document.getElementById("txt_msg").innerHTML = JSON.stringify(arg3) + " "  + JSON.stringify(num3);
    }
    bridge.url = url;
    bridge.onservicecallback = callback;
    bridge.call(url, params);
}


document.getElementById("txt_msg").onclick = function(){

    if(document.getElementById("txt_msg").innerHTML === "Hello, This is RSSI TEST!!"){
        document.getElementById("txt_msg").innerHTML = "Let's START!";
        setTimeout(function(){
            document.getElementById("txt_msg").innerHTML = "Measuring...";
        }, 3000);

        subscribe_rssi();
    }
    else{
        document.getElementById("txt_msg").innerHTML = "Restarted!";
        setTimeout(function(){
            document.getElementById("txt_msg").innerHTML = "Measuring...";
        }, 3000);
    }
};
}