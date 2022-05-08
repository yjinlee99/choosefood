import React, { useState, useEffect } from 'react';
import './Board.css';
import SearchIcon from '@material-ui/icons/Search';
import StarIcon from '@material-ui/icons/StarRounded';
import Banner from './Banner';
import { Link } from "react-router-dom";


function Board() {
    return (
        <div className="Recipe">

            <div className="Header"><Banner/></div>
            
            <div className="Search">
                <input className="Search-input" type="text" />
                <Link to="/SearchedRecipe"><SearchIcon className="Search-icon"/></Link> 
          
                <select className="Array">
                    <option> 이름순 </option>
                    <option> 조회순 </option>
                    <option> 별점순 </option>
                </select>

                <Link to="/Writing"><div className="GotoWrite"> 글쓰기 </div></Link>

            </div> 

            <div id="Container">
                <div id="List1" className="Content-list">
                    <div className="Content">
                        <Link to="/SingleRecipe">
                        <div className="Thump">
                                <img src="" />썸네일
                        </div>
                        </Link>
                        <div className="Detail">
                            <div className="Profile">
                                <Link to="">
                                    <img src=""/>프로필
                                </Link>
                            </div>
                            <h4 className="Title">
                                <Link to=""><div className="Title-link">제목</div></Link>
                            </h4>
                            <div>
                                <div className="Stars">
                                    <StarIcon className="Star-icon"/>
                                    <StarIcon className="Star-icon"/>
                                    <StarIcon className="Star-icon"/>
                                    <StarIcon className="Star-icon"/>
                                    <StarIcon className="Star-icon"/>
                                </div> &nbsp;
                                <div className="Hits">조회수</div>
                            </div>
                        </div>
                    </div>

                    <div className="Content">
                        <Link to="/SingleRecipe">
                        <div className="Thump">
                                <img src="" />썸네일
                        </div>
                        </Link>
                        <div className="Detail">
                            <div className="Profile">
                                <Link to="">
                                    <img src=""/>프로필
                                </Link>
                            </div>
                            <h4 className="Title">
                                <Link to=""><div className="Title-link">제목</div></Link>
                            </h4>
                            <div>
                                <div className="Stars">
                                    <StarIcon className="Star-icon"/>
                                    <StarIcon className="Star-icon"/>
                                    <StarIcon className="Star-icon"/>
                                    <StarIcon className="Star-icon"/>
                                    <StarIcon className="Star-icon"/>
                                </div> &nbsp;
                                <div className="Hits">조회수</div>
                            </div>
                        </div>
                    </div>

                    <div className="Content">
                        <Link to="/SingleRecipe">
                        <div className="Thump">
                                <img src="" />썸네일
                        </div>
                        </Link>
                        <div className="Detail">
                            <div className="Profile">
                                <Link to="">
                                    <img src=""/>프로필
                                </Link>
                            </div>
                            <h4 className="Title">
                                <Link to=""><div className="Title-link">제목</div></Link>
                            </h4>
                            <div>
                                <div className="Stars">
                                    <StarIcon className="Star-icon"/>
                                    <StarIcon className="Star-icon"/>
                                    <StarIcon className="Star-icon"/>
                                    <StarIcon className="Star-icon"/>
                                    <StarIcon className="Star-icon"/>
                                </div> &nbsp;
                                <div className="Hits">조회수</div>
                            </div>
                        </div>
                    </div>
                </div>

                <div id="List2" className="Content-list">
                    <div className="Content">
                        <Link to="/SingleRecipe">
                        <div className="Thump">
                                <img src="" />썸네일
                        </div>
                        </Link>
                        <div className="Detail">
                            <div className="Profile">
                                <Link to="">
                                    <img src=""/>프로필
                                </Link>
                            </div>
                            <h4 className="Title">
                                <Link to=""><div className="Title-link">제목</div></Link>
                            </h4>
                            <div>
                                <div className="Stars">
                                    <StarIcon className="Star-icon"/>
                                    <StarIcon className="Star-icon"/>
                                    <StarIcon className="Star-icon"/>
                                    <StarIcon className="Star-icon"/>
                                    <StarIcon className="Star-icon"/>
                                </div> &nbsp;
                                <div className="Hits">조회수</div>
                            </div>
                        </div>
                    </div>

                    <div className="Content">
                        <Link to="/SingleRecipe">
                        <div className="Thump">
                                <img src="" />썸네일
                        </div>
                        </Link>
                        <div className="Detail">
                            <div className="Profile">
                                <Link to="">
                                    <img src=""/>프로필
                                </Link>
                            </div>
                            <h4 className="Title">
                                <Link to=""><div className="Title-link">제목</div></Link>
                            </h4>
                            <div>
                                <div className="Stars">
                                    <StarIcon className="Star-icon"/>
                                    <StarIcon className="Star-icon"/>
                                    <StarIcon className="Star-icon"/>
                                    <StarIcon className="Star-icon"/>
                                    <StarIcon className="Star-icon"/>
                                </div> &nbsp;
                                <div className="Hits">조회수</div>
                            </div>
                        </div>
                    </div>

                    <div className="Content">
                        <Link to="/SingleRecipe">
                        <div className="Thump">
                                <img src="" />썸네일
                        </div>
                        </Link>
                        <div className="Detail">
                            <div className="Profile">
                                <Link to="">
                                    <img src=""/>프로필
                                </Link>
                            </div>
                            <h4 className="Title">
                                <Link to=""><div className="Title-link">제목</div></Link>
                            </h4>
                            <div>
                                <div className="Stars">
                                    <StarIcon className="Star-icon"/>
                                    <StarIcon className="Star-icon"/>
                                    <StarIcon className="Star-icon"/>
                                    <StarIcon className="Star-icon"/>
                                    <StarIcon className="Star-icon"/>
                                </div> &nbsp;
                                <div className="Hits">조회수</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Board;