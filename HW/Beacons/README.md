ESP32 비콘 만들기

1.Aduino ide 설치 후 ,  보드매니저에서

https://dl.espressif.com/dl/package_esp32_index.json,http://arduino.esp8266.com/stable/package_esp8266com_index.json,http://downloads.arduino.cc/packages/package_arduino.cc_linux_index.json

추가

2. 라이브러리 검색에서  esp32 검색후 설치

3. 장치관리자에서 esp32인식 확인

4. cp2102drivers 압축 해제후 , cp210x...._x64설치

5. 포트확인

6. 보드는 ESP32 Dev Module 로.

7. 기기 이름 ,  UUID , 전달하는 Major, Minor 데이터 수정해줘야함. txt 문서 확인 후 양식대로 define 후 빌드 하면 됩니다.


SAMPLE SETTING

#define DEVICE_NAME            "ESP32"
#define SERVICE_UUID           "aaaaffe3-aaaa-1000-8000-00805f9b34fc"
#define BEACON_UUID            "1d05786b-a75e-fa84-7f4d-0970cc467bb6"
#define BEACON_UUID_REV        "b67b46cc-7009-4d7f-84fa-5ea76b78051d"
#define CHARACTERISTIC_UUID    "82258BAA-DF72-47E8-99BC-B73D7ECD08A5"
#define beacon_idx_X               1
#define beacon_idx_Y               1


// DEVICE_NAME MUST BE "ESP32"
// set SERVICE_UUID same.
// BEACON_UUID must be unique. you can get UUID from "https://www.uuidgenerator.net/"

// beacon_idx_X must be unique, 1~3
// beacon_idx_Y must be unique, 1~4