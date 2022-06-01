import React, { useEffect } from 'react';
import { useState } from 'react';
import Banner from '../Banner';
import './MapContainer.css';
const { kakao } = window

const MapContainer=({searchPlace})=>{

  const [Places, setPlaces] = useState([]);

  const [dtos, setDtos] = useState([]);
  useEffect(()=>{
    var url = decodeURI(document.location.href);
    var d;
    var a = url.slice(url.indexOf('?')+1);
    console.log(a);
    var b = a.split('=');
    console.log(b[1]);
    var c = b[1];

    const requestOptions = {
        method:'post',  
        headers: { 'Content-Type': 'application/json' },
        body:JSON.stringify({
            food: c,
        })
    }

  fetch('/singlefood', requestOptions)
  .then(response => {
    return response.json()
})
.then((dtos) =>{
     setDtos(dtos);
});
    

  //맵 생성
  var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
  var options = { //지도를 생성할 때 필요한 기본 옵션
      center: new kakao.maps.LatLng(36.815129, 127.113893), //지도의 중심좌표.
      level: 3 //지도의 레벨(확대, 축소 정도)
    };

  var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴


  // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
  var mapTypeControl = new kakao.maps.MapTypeControl();

  // 지도에 컨트롤을 추가해야 지도위에 표시됩니다
  // kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
  map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

  // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
  var zoomControl = new kakao.maps.ZoomControl();
  map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

  // 마커를 클릭하면 장소명을 표출할 인포윈도우 입니다
  var infowindow = new kakao.maps.InfoWindow({zIndex:1});

  // 장소 검색 객체를 생성합니다
  var ps = new kakao.maps.services.Places(); 


  //현재위치 가져오기
  if (navigator.geolocation) {
    
    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
    navigator.geolocation.getCurrentPosition(function(position) {
        
        var lat = position.coords.latitude, // 위도
            lon = position.coords.longitude; // 경도
        
        var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
            message = '<div style="width:50px; text-align:center;">현위치</div>'; // 인포윈도우에 표시될 내용입니다
        
            document.getElementById("lat2").innerHTML=lat;
            document.getElementById("lon2").innerHTML=lon;
        // 마커와 인포윈도우를 표시합니다
        displayMarker(locPosition, message);

        // 키워드로 장소를 검색합니다
        ps.keywordSearch( c, placesSearchCB,  {radius:1200, location:
          // locPosition}); 
          new kakao.maps.LatLng(lat, lon)}); 
      });
  
  } else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
    
    var locPosition = new kakao.maps.LatLng(36.815129, 127.113893),    
        message = 'geolocation을 사용할수 없어요'
        
    displayMarker(locPosition, message);

  }

// 키워드 검색 완료 시 호출되는 콜백함수 입니다
function placesSearchCB (data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
        // LatLngBounds 객체에 좌표를 추가합니다
        var bounds = new kakao.maps.LatLngBounds();

        for (var i=0; i<data.length; i++) {
            displayMarker2(data[i]);    
            bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
        }       

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
        map.setBounds(bounds);
        setPlaces(data);
        console.log(data);
    }
  }

  // 식당정보 마커
  // 지도에 마커를 표시하는 함수입니다
function displayMarker2(place) {
    
  // 마커를 생성하고 지도에 표시합니다
  var marker = new kakao.maps.Marker({
      map: map,
      position: new kakao.maps.LatLng(place.y, place.x) 
  });


  // 마커에 클릭이벤트를 등록합니다
  kakao.maps.event.addListener(marker, 'mouseover', function() {
      // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
      infowindow.setContent(
        '<div style="padding:5px; text-align:center; width:230px; height:95px; font-size:12px;">' +
        '<div style="font-size:1.5em; font-weight:bold;">'+ place.place_name + '</div>' +
        '<div>'+ place.road_address_name + '</div>' +
        '<div style="color:green;">' + place.phone + '</div>' +
        '<div><a href="' + place.place_url + '" target="_blank" class="link" style="color:#ff6161; text-decoration:none;">상세보기</a></div>'
      +'</div>'
      );
      infowindow.open(map, marker);
  });


  
}

function alert(){
  
}
  

// 현위치 마커
// 지도에 마커와 인포윈도우를 표시하는 함수입니다
function displayMarker(locPosition, message) {

    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({  
        map: map, 
        position: locPosition
    }); 
    
    var iwContent = message; // 인포윈도우에 표시할 내용
        // iwRemoveable = true;

    // 인포윈도우를 생성합니다
    var infowindow = new kakao.maps.InfoWindow({
        content : iwContent,
        // removable : iwRemoveable
    });
    
    // 인포윈도우를 마커위에 표시합니다 
    infowindow.open(map, marker);
    
    // 지도 중심좌표를 접속위치로 변경합니다
    map.setCenter(locPosition);      
}    

  }, [searchPlace])



    return (
      <div id='mapContainer'>

        <div>
            <div className="Header"><Banner/></div>
        </div>
        

      <div id='mapContainer2'>
        <div id='info'>
          <div id="placeKeyword" style={{
            fontWeight:'bold',
            fontSize:'1.1em',
            paddingTop:'10px',
            paddingBottom:"10px",
            textAlign: "center",
            alignSelf:'center'
          }}>{dtos.name}
          </div>

          {Places.map((item, i) => (
            <div id='info2' key={i} style={{ paddingTop:'10px', paddingBottom:"10px", borderTop: '1px solid #ff6161' }}
                  onClick={()=>{
                    alert(i+1)
                  }}>
              <div style={{fontSize:'0.8em' }}>{i + 1}</div>
              <div style={{fontWeight:'bold', fontSize:'1.1em'}}>{item.place_name}</div>
              <div style={{fontSize:'0.8em' }}>{item.road_address_name}</div>
              <div style={{color:'green', fontSize:'0.8em' }}>{item.phone}</div>
              <div><a href={item.place_url} style={{color:'#ff6161', textDecoration:'none'}} target="_blank" class="link">상세보기</a></div>
            </div>
          ))}

        </div>
        

        <div id="map" style={{ width: "100%", height: "700px" }}></div>
      
      </div>

        <div> 현재위치: 
          <span>위도</span><span id="lat2"></span>/
        <span>경도</span><span id="lon2"></span>
        </div>

        </div>

    )
}


export default MapContainer;