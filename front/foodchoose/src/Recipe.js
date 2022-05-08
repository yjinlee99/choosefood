import React, { useState, useEffect } from 'react';
import './Recipe.css';
import SearchIcon from '@material-ui/icons/Search';
import StarIcon from '@material-ui/icons/StarRounded';
import Banner from './Banner';
import Tab from './Tab';
import { Link } from "react-router-dom";


function Recipe() {
    const [dtos, setDtos] = useState([[]]);
    useEffect(() => {
        fetch('/dtos')
            .then(response => response.json())
            .then(dtos => {
                setDtos(dtos);
            });
    },[])
    return (
        <div className="Recipe">
            
            <div className="Search">
                <input className="Search-input" type="text" />
                <Link to="/SearchedRecipe"><SearchIcon className="Search-icon"/></Link>
            </div>

            <div className="Header">
                <Banner/>
                <Tab />
            </div>

            <select id="Array">
                <option> 이름순 </option>
                <option> 조회순 </option>
                <option> 별점순 </option>
            </select>
            
            <div id="Container">
                <div id="List1" className="Content-list">
                    <div className="Content">
                        <Link to="/SingleRecipe">
                        <div className="Thump">
                                <img src={dtos[0].thumbnail} width="290" height="160" />썸네일
                        </div>
                        </Link>
                        <div className="Detail">
                            <div className="Profile">
                                <Link to="">
                                    <img src=""/>프로필
                                </Link>
                            </div>
                            <h4 className="Title">
                                <Link to=""><div className="Title-link">{(dtos[0].title)}</div></Link>
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
                                <img src="" width="290" height="160"  />썸네일
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


export default Recipe;