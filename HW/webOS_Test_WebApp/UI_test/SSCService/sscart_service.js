/*
 * ChangYong Ahn.
 * SSAFY 08th, A102 first project.
 * 
 */


// eslint-disable-next-line import/no-unresolved
const pkgInfo = require('./package.json');
const Service = require('webos-service');

// Create service by service name on package.json
const service = new Service(pkgInfo.name); 
const logHeader = "[" + pkgInfo.name + "]";



// MAKE APP SERVICE ACTIVE BACKGROUND.
service.activityManager.create('keepAlive', (activity) => {
    keepAliveActivity = activity;
    console.log('created activity');
})
// CHECK IF BLUETOOTH SERVICE POSSIBLE.
service.call('luna://com.webos.service.bluetooth2/adapter/setState', {"powered":true},function(msg) {
    console.log(JSON.stringify(msg));
    myrsp = JSON.stringify(msg);
});
// maybe there will be no problem, so no addtional action here. 


/////////////////DEFINE BASE varibles, functions////////////////////



// To get distance from some specific beacon, ill use following steps.

// 1. all beacon has same name, "ESP32", and  beacon has different majornum, minornum set.
// 2. this service will get subscription msg about scanning data from BLE controller. (subscription data from api is not frequent.)
// 3. major&minor set is at JSON.parse(msg).devices[i].manufacturerData.data[19], data[21];
// 4. each beacon has diffent Tx, so if you want more correct possition, strongly recommend having some tests to get avg 1m data. 





// cnt : subscription varifing var, mtp: 

let beacon_rssi_list =[
    [-200,-200,-200,-200],
    [-200,-200,-200,-200],
    [-200,-200,-200,-200]
];
let sample_bc_1m_table =[
    [-48,-51,-53],
    [-59,-59,-47],
    [-51,-48,-44]
];
let top_bc_cnt = [
    [0,0,0,0],
    [0,0,0,0],
    [0,0,0,0]
];
let top_bc_filter = 1;
//beacon pos arr.
let bc_X = [
    [2,2,2,2],
    [6,6,6,6],
    [10,10,10,10]
];
let bc_Y = [
    [2,6,10,14],
    [2,6,10,14],
    [2,6,10,14]
];
let curx = -2, cury = -2;
let top_bc_xidx =-1, top_bc_yidx = -1;

function get_top_rssi(){
    let top_x=-1, top_y= -1;
    let temp_top_rssi = -200;
    for(let x = 0; x < 3 ; x ++){
        for(let y = 0; y < 4; y++){
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
            curx = bc_X[top_bc_xidx][top_bc_yidx];
            cury = bc_Y[top_bc_xidx][top_bc_yidx];
        }    
    }
    else{
        top_bc_cnt = [[0,0,0,0],[0,0,0,0],[0,0,0,0]];
        top_bc_cnt[top_x][top_y]++;
    }
};

// Subscribe BLE Scan & GET position
var sub = service.subscribe("luna://com.webos.service.bluetooth2/le/startScan", {"subscribe": true, "name":"ESP32"});
var arg = [];
sub.on("response", function(message) {
    let device_N = 0;
    arg = message.payload.devices;
    if(Array.isArray(arg)){
        device_N = arg.length;
        beacon_rssi_list =[[-200,-200,-200,-200],[-200,-200,-200,-200],[-200,-200,-200,-200]];
        for (var i = 0; i < device_N ; i++){
            var temp_rssi = arg[i].rssi;//.rssi 시 undefined  
            var major_num = arg[i].manufacturerData.data[19];
            var minor_num = arg[i].manufacturerData.data[21];
            beacon_rssi_list[major_num-1][minor_num-1] = temp_rssi;
        };

        if(device_N){
            get_top_rssi();
        }
    }
});

////////////////////MY SERVICE/////////////////////

//x,y position API
service.register("mypos",function(message){
    console.log(logHeader, "SERVICE_METHOD_CALLED:/mypos");
    console.log("In mypos callback");

    message.respond({
        returnValue: true,
        x:curx,
        y:cury
    });
});






//////////////////Customized quit///////////////////
///// DONT  CHANGE///////A//////////////////////////
service.register("quit", function(){
    sub.cancel();

    service.activityManager.complete(keepAliveActivity, (activity) => {
        keepAliveActivity = null;
        console.log('completed activity');
    });
});

////////C////////////DEMO CODE/////////////////////

// a method that always returns the same value
service.register("hello", function(message) {
    console.log(logHeader, "SERVICE_METHOD_CALLED:/hello");
    console.log("In hello callback");
    const name = message.payload.name ? message.payload.name : "World";

    message.respond({
        returnValue: true,
        Response: "HELLO"
    });
});



// listen for requests, and handle subscriptions via implicit event handlers in call
// to register




