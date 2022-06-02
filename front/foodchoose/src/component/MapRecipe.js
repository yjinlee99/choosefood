import React, { useState, useEffect }  from 'react';
import './MapRecipe.css';
import SearchIcon from '@material-ui/icons/Search';
import StarIcon from '@material-ui/icons/StarRounded';
import Banner from '../Banner';
import Tab from '../Tab';
import { Link } from "react-router-dom";


function MapRecipe() {
    
    const [dtos, setDtos] = useState([[]]);

    useEffect(() => {
        getParameters()
    },[])

    var getParameters = function (paramName) {
        var returnValue;

        var url = decodeURI(document.location.href);
        console.log(decodeURI(url));
        var parameters=(url.slice(url.indexOf('?') + 1, url.length)).split('&');
        var a = url.slice(url.indexOf('?')+1);
        var themeop = [];
        var tasteop = [];
        var ingredientop = [];
        var situationop = [];
        var refrigeratorop =[];
        // var b = a.slice(a.indexOf('&')+1);
        var b = a.split('&');
        b.map((data)=>{
            let d=data.split('=');{
                if(d[0] === 'theme') {
                    themeop = d[1];
                }
                else if(d[0] === 'taste') {
                    tasteop = d[1];
                }
                else if(d[0] === 'ingredient') {
                    ingredientop = d[1];
                }
                else if(d[0] === 'situation') {
                    situationop = d[1];
                }
                else if(d[0] === 'refrigerator') {
                    refrigeratorop = d[1];
                    console.log(refrigeratorop);
                }
        }});
        themeop=themeop.split(',');
        tasteop=tasteop.split(',');
        ingredientop=ingredientop.split(',');
        situationop=situationop.split(',');
        refrigeratorop=refrigeratorop.split(',');
        console.log(themeop)
    
        const requestOptions = {
            method:'post',  
            headers: { 'Content-Type': 'application/json' },
            body:JSON.stringify({
                theme: themeop,
                taste: tasteop,
                ingredients: ingredientop,
                situations: situationop,
                refrigerator: refrigeratorop,
            })
        }
        
        
        fetch('/option',requestOptions)
            .then(response => response.json())
            .then(dtos => {
                setDtos(dtos);
            });

        console.log(themeop);
        
        
    };

    let Info = [
        { id: 1, thump: "썸", profile: "프", title: "타", star: <StarIcon />, hit: "조"},
        { id: 2, thump: "네", profile: "로", title: "이", star: <StarIcon />, hit: "회"},
        { id: 3, thump: "일", profile: "필", title: "틀", star: <StarIcon />, hit: "수"},
        { id: 4, thump: "썸", profile: "프", title: "타", star: <StarIcon />, hit: "조"},
        { id: 5, thump: "네", profile: "로", title: "이", star: <StarIcon />, hit: "회"},
        { id: 6, thump: "일", profile: "필", title: "틀", star: <StarIcon />, hit: "수"},
    ];
                
    return (
        <div className="Recipe">

            <div className="Header">
                <Banner/>
                <Tab />
            </div>

            <div className="Search">
                <input className="Search-input" type="text" />
                <Link to="/SearchedRecipe"><SearchIcon className="Search-icon"/></Link>
            </div>

            <div id='info-con'>
            <div id="Container">
                { dtos.map((a) => (
                    <div className="Content">
                            <Link  id="Thump" to={"/MapContainer?food=" + a.name}>
                                    <img id="ThumpImg" src={a.thumbnail} />
                            </Link>
                        
                            <Link id="Title" to={"/MapContainer?food=" + a.name}>{ a.name }</Link>
                    </div>
                ))}
            </div>
            </div>
        </div>
    );   
}

export default MapRecipe;