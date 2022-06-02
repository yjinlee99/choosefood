import React, { useState, useEffect }  from 'react';
import './SearchedRecipe.css';
import SearchIcon from '@material-ui/icons/Search';
import Banner from './Banner';
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
            </div>

            <div className="Search">
                <input className="Search-input" placeholder=" 통합 검색" type="text" onChange={onSearchHandler}/>
                <SearchIcon className="Search-icon" onClick={reloading}/>
            </div>
            
            <div id="Container">
            { dtos && dtos.map((a) => (
                    <div className="Content">
                            <Link id="Thump" to={"/SingleRecipe?food=" + a.name}>
                                <img id="ThumpImg" src={a.thumbnail}></img>
                            </Link>
                        
                            <Link id="Title" to={"/SingleRecipe?food=" + a.name}>{ a.name }</Link>
                    </div>
            ))}
            </div>
        </div>
    );   
}

export default SearchedRecipe;