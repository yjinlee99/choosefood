import React, { useState, useEffect }  from 'react';
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

    // const [dtos, setDtos] = useState([[]]);
    // const location = useLocation();
    // useEffect(() => {
    //     getParameters()
    // },[])

    // var getParameters = function (paramName) {
    //     var returnValue;

    //     var url = decodeURI(document.location.href);
    //     console.log(decodeURI(url));
    //     var parameters=(url.slice(url.indexOf('?') + 1, url.length)).split('&');
    //     var a = url.slice(url.indexOf('?')+1);
    //     var themeop = [];
    //     var tasteop = [];
    //     var ingredientop = [];
    //     var situationop = [];
    //     // var b = a.slice(a.indexOf('&')+1);
    //     var b = a.split('&');
    //     b.map((data)=>{
    //         let d=data.split('=');{
    //             if(d[0] === 'theme') {
    //                 themeop = d[1];
    //             }
    //             else if(d[0] === 'taste') {
    //                 tasteop = d[1];
    //             }
    //             else if(d[0] === 'ingredient') {
    //                 ingredientop = d[1];
    //             }
    //             else if(d[0] === 'situation') {
    //                 situationop = d[1];
    //             }
    //     }});
    //     themeop=themeop.split(',');
    //     tasteop=tasteop.split(',');
    //     ingredientop=ingredientop.split(',');
    //     situationop=situationop.split(',');
    //     console.log(themeop)
    
    //     const requestOptions = {
    //         method:'post',  
    //         headers: { 'Content-Type': 'application/json' },
    //         body:JSON.stringify({
    //             theme: themeop,
    //             taste: tasteop,
    //             ingredient: ingredientop,
    //             situation: situationop,
    //         })
    //     }
        
        
    //     fetch('/option',requestOptions)
    //         .then(response => response.json())
    //         .then(dtos => {
    //             setDtos(dtos);
    //         });

    //     console.log(themeop);
        
        
    // };
    
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
    const goBackend = () => {
        if(search == "") {
            alert("검색어를 입력하세요.")
            return;
        } else {
            fetch('/search', {
                method: 'post',
                body: JSON.stringify({
                    search: search
                })
            })
        }
    }
    // const views = (name) => {
    //     fetch('/views', {
    //         method: 'post',
    //         body: JSON.stringify({
    //             name: name
    //         })
    //     })
    // }

    return (
        <div className="Recipe">

            <div className="Header">
                <Banner/>
                <Tab />
            </div>

            <div className="Search">
                <input className="Search-input" placeholder=" 통합 검색" type="text" onChange={onSearchHandler}/>
                <Link to="/SearchedRecipe"><SearchIcon className="Search-icon" onClick={goBackend}/></Link>
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

export default Recipe;