import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import Banner from './Banner';
import './Main.css';

function Main() {
    return (
        <div className="Main">         
            <div className="Header"><Banner/></div>
            <div className="Choose">
                <ul className="Choose-table">
                    <li><Link to="/Option"> 레시피 </Link></li>       
                    <li><Link to="/MapOption"> 식당 추천 </Link></li>
                </ul>
                <ul className="Choose-table">                        
                    <li><Link to="/Refrigerator"> 냉장고 </Link></li>
                    <li><Link to="/Board"> 게시판 </Link></li>
                </ul>
            </div>
        </div>
    );
}

export default Main;