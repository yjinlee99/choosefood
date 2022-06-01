import React, { useState, useEffect }  from 'react';
import './MyWriting.css';
import Banner from "../Banner";
import StarIcon from '@material-ui/icons/StarRounded';
import { Link } from "react-router-dom";


function MyWriting(){
    const id = sessionStorage.getItem("id", id);
    const [dtos, setDtos] = useState([[]]);
    useEffect(() => {
        const requestOptions = {
            method:'post',  
            headers: { 'Content-Type': 'application/json' },
            body:JSON.stringify({
                id: id
            })
        }
        fetch('/post/my',requestOptions)
        .then(response => response.json())
        .then(dtos => {
            setDtos(dtos);
        });
    },[])
    
    return(
        <div>
            <div className="Header"><Banner/></div>
            <h1 id='mywritingMain'>내가 쓴 글</h1>

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
                                <Link to=""><div className="Title-link">{dtos[0].title}</div></Link>
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

export default MyWriting;