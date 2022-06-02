import React, { useState, useEffect }  from 'react';
import './SearchedRecipe.css';
import SearchIcon from '@material-ui/icons/Search';
import StarIcon from '@material-ui/icons/StarRounded';
import Banner from './Banner';
import Tab from './Tab';
import { Link } from "react-router-dom";


function SearchedRecipe() {
    // const [dtos, setDtos] = useState([[]]);
    // useEffect(() => {
    //     fetch('/search')
    //         .then(response => response.json())
    //         .then(dtos => {
    //             setDtos(dtos);
    //         });
    // },[])


    let Info = [
        { id: 1, thump: "썸", profile: "프", title: "타", star: <StarIcon />, hit: "조"},
        { id: 2, thump: "네", profile: "로", title: "이", star: <StarIcon />, hit: "회"},
        { id: 3, thump: "일", profile: "필", title: "틀", star: <StarIcon />, hit: "수"},
        { id: 4, thump: "썸", profile: "프", title: "타", star: <StarIcon />, hit: "조"},
        { id: 5, thump: "네", profile: "로", title: "이", star: <StarIcon />, hit: "회"},
        { id: 6, thump: "일", profile: "필", title: "틀", star: <StarIcon />, hit: "수"},
    ];

    const [search, setSearch] = useState("")
    const onSearchHandler = (event) => {
        setSearch(event.currentTarget.value)
    }
    const [dtos, setDtos] = useState([[]]);
    useEffect(() => {

        var url = decodeURI(document.location.href);
        var str = url.split("=");
        if(str[1] == "") {
            alert("검색어를 입력하세요.")
            return;
        } else {
            fetch('/search?'+ new URLSearchParams({
                search: str[1],
            }))
            .then(response => response.json())
            .then(dtos => {
                setDtos(dtos);
                setSearch(str[1]);
            });
        }
    },[])

    const reloading = () => {
        window.location.replace("/SearchedRecipe?search=" + search);
    };
                
    return (
        <div className="Recipe">

            <div className="Header">
                <Banner/>
                <Tab />
            </div>

            <div className="Search">
                <input className="Search-input" placeholder=" 통합 검색" type="text" onChange={onSearchHandler}/>
                <SearchIcon className="Search-icon" onClick={reloading}/>
            </div>
        
            <select id="Array">
                <option> 이름순 </option>
                <option> 조회순 </option>
                <option> 별점순 </option>
            </select>
            
            <div id='info-con'>
            <div id="Container">
                { dtos.map((a) => (
                    <div className="Content">  
                        <div className="Thump">
                            <Link to={"/SingleRecipe/?" + a.name}>
                                <div className="Thump-link"> 
                                    <img src={a.thumbnail} width="350" height="160" />
                                </div>
                            </Link>
                        </div>
                        
                        <div className="Detail">
                            <div className="Profile">
                                <Link to="">
                                    <div className="Profile-link"> { a.profile }</div>
                                </Link>
                            </div>

                            <h4 className="Title">
                                <Link to={"/SingleRecipe/?" + a.name}><div className="Title-link">{ a.name }</div></Link>
                            </h4>
                            
                            <div>
                                <div className="Stars"> { a.star } </div> &nbsp;
                                <div className="Hits">  { a.hit } </div>
                            </div>
                        </div>
                    </div>
                ))}
            </div>
            </div>
        </div>
    );   
}

export default SearchedRecipe;