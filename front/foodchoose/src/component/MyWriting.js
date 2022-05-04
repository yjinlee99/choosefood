import React from "react";
import './MyWriting.css';
import Banner from "../Banner";


function MyWriting(){
    return(
        <div>
            <div className="Header"><Banner/></div>
            <h1>내가 쓴 글</h1>
        </div>
    )
}

export default MyWriting;