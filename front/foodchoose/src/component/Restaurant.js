import React from 'react';
import './Restaurant.css';
import Banner from '../Banner';
import { Link } from 'react-router-dom';
import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';
import FavoriteIcon from '@mui/icons-material/Favorite';

function Restaurant(){
    return(
        <div>
            <div className="Header"><Banner /></div>

            <div id='Restaurant'>
            <div id='info'>
                <div id='menuName'><div id='menuName2'>삼겹살</div></div><br />
                <span id='location'>서울 성북구 삼선동</span>
                <select id="ArrayRestaurant">
                    <option> 거리순 </option>
                    <option> 추천순 </option>
                </select>
                
                <div id='restaurantContainer1'>
                <div id='restaurantContainer2'>
                    <div id='img'>
                        <img src="https://search.pstatic.net/common/?autoRotate=true&quality=95&type=w750&src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTExMjhfNTkg%2FMDAxNjM4MDg1Nzc5NzYz.Zw27NpBhfH-doNjh6yzwW4F7RA3vQPEkB5Kayd_naY8g.2Jsmqk3McdW8z2yJDGv-a4axGuP4chwSuvkFbnL_jXEg.JPEG.weddingbin%2F2.jpg"  width='250px' height='150px'/>
                    </div>
                    <FavoriteBorderIcon id='likeIcon' fontSize='small'/>
                    <span id='name'>방목</span>
                    <span id='count'>77</span><br />
                    <span id='explanation'>삼겹살이 맛있는 한성대맛집</span><br />
                </div>
                </div>
            </div>

            <div id='map'>지도</div>
            </div>

        </div>
    )

}

export default Restaurant;