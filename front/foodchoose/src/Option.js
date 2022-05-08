import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import Banner from './Banner';
import './Option.css';

function Option() {
    return (
        <div className="Option">         
            <div className="Header"><Banner/></div>
            <div className="Options">
                <div className="Option-table1">
                <div id="Theme">
                        <caption> 테마별 </caption>
                        <ul>
                            <li> 한식 </li>
                            <li> 중식 </li>
                            <li> 일식 </li>
                        </ul>
                        <ul>
                            <li> 양식 </li>
                            <li> 분식 </li>
                            <li> 디저트 </li>
                        </ul>
                    </div>
                    <div id="Taste">
                        <caption> 미각별 </caption>
                        <ul>
                            <li> 매콤 </li>
                            <li> 달콤 </li>
                        </ul>
                        <ul>
                            <li> 새콤 </li>
                            <li> 짭짤 </li>
                        </ul>
                    </div>
                </div>

                <div className="Option-table2">
                    <div id="Ingre">
                        <caption> 재료별 </caption>
                        <ul>
                            <li> 고기 </li>
                            <li> 채소 </li>
                            <li> 해물 </li>
                        </ul>
                        <ul>
                            <li> 밥 </li>
                            <li> 떡 </li>
                            <li> 면 </li>
                        </ul>
                        <ul>
                            <li> 빵/과자 </li>
                            <li> 두부/계란 </li>
                            <li> 과일 </li>
                        </ul>
                    </div>
                    <div id="Situa">
                        <caption> 상황별 </caption>
                        <ul>
                            <li> 야식 </li>
                            <li> 간식 </li>
                        </ul>
                        <ul>
                            <li> 술안주</li>
                            <li> 해장 </li>
                        </ul>
                        <ul>
                            <li> 식사 </li>
                            <li> 기타 </li>
                        </ul>
                    </div>
                </div>
            </div>
            <Link to="/Recipe"><div id="Find"> 찾기 </div></Link>
        </div>
    );
}

export default Option;