import React, { useState, useEffect }  from 'react';
import './MyWriting.css';
import Banner from "../Banner";
import StarIcon from '@material-ui/icons/StarRounded';
import { Link } from "react-router-dom";


function MyWriting(){
    const id = sessionStorage.getItem("id", id);
    const [dtos, setDtos] = useState([[]]);
    const [Date, setDate] = useState([]);
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
            var arr = [];
                var str1, str2;
                for(var i=0; i<dtos.length;i++) {
                    str1 = dtos[i].uploadDate.split("T");
                    str2 = str1[1].split(".");
                    str1 = str1[0] + " / " + str2[0];
                    arr[i] = str1;
                }
                setDate(arr);
        });
    },[])
    
    return(
        <div>
            <div className="Header"><Banner/></div>
            <h1 id='mywritingMain'>내가 쓴 글</h1>

            <div id="Container">
            { dtos && dtos.map((a) => (
                    <div className="Content">  
                            <Link to={"/SinglePost/?" + a.title}><img src={"\\img\\"+ a.thumbImg} width="350px" height="200px" style={{borderRadius:'5px', objectFit: 'cover'}}/> </Link>
                            <div id='infoBoard'>
                                <Link to=""><div ><img id='profileBoard' src={"\\img\\profile\\"+ a.profileImg} width="50px" style={{borderRadius:'70%'}}></img> { a.profile }</div></Link>
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