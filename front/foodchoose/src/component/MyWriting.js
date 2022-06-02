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
            { dtos && dtos.map((a) => (
                    <div className="Content">  
                            <Link to={"/SinglePost/?" + a.title}><img src={a.thumbnail} width="350px" height="200px" style={{borderRadius:'5px'}}/> </Link>
                            <div id='infoBoard'>
                                <Link to=""><div ><img id='profileBoard' src="/img/profile.png" width="50px" style={{borderRadius:'70%'}}></img> { a.profile }</div></Link>
                                <div id='infoBoard2'>
                                    <Link id='titleBoard' to={"/SinglePost/?" + a.title}><div id='titleBoard'>{ a.title }</div></Link>
                                    <div id="datehit">
                                        <div id="dateBoard">{ Date[dtos.indexOf(a)] }</div> &nbsp;
                                        <div id="hitBoard">조회수 { a.view }</div>
                                    </div>
                                </div>
                            </div>
                    </div>
                ))}

            </div>
        </div>
    )
}

export default MyWriting;