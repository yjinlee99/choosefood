import React from "react";
import './MyRestaurant.css';
import Banner from "../Banner";
import StarIcon from '@material-ui/icons/StarRounded';
import { Link } from "react-router-dom";


function MyRestaurant(){
    return(
        <div>
            <div className="Header"><Banner/></div>
            <h1 id='myrestMain' >관심 식당</h1>

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
    )
}

export default MyRestaurant;