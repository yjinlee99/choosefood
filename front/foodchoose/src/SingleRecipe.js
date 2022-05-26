import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import StarIcon from '@material-ui/icons/StarRounded';
import Banner from './Banner';
import './SingleRecipe.css';
var datas=[];
function SingleRecipe() {
    const [dtos, setDtos] = useState([]);
    
    useEffect(() => {
        var url = decodeURI(document.location.href);
        var d;
        var a = url.slice(url.indexOf('?')+1);
        console.log(a);
        var b = a.split('=');
        console.log(b[1]);
        var c = b[1];

        const requestOptions = {
            method:'post',  
            headers: { 'Content-Type': 'application/json' },
            body:JSON.stringify({
                food: c,
            })
        }

        fetch('/singlefood',requestOptions)
            .then(response => {
                return response.json()
                // const result  =response.json();
                // console.log("result",result.id)
                // var value=Object.values(result);
                // datas.push(value)
            })
            .then((data) =>{
                 d=data
                 console.log(d);
                 setDtos(data);
            });
    },[])

    
    return(
    <div>
        
        <div class="Header"><Banner/></div>
        
        
            <div>
            <div className="Single-recipe">
                <div className="Recipe-img">
                    <img src={dtos.thumbnail} />
                    <div className="Star">
                        <StarIcon className="Star-icon" />
                        <StarIcon className="Star-icon" />
                        <StarIcon className="Star-icon" />
                        <StarIcon className="Star-icon" />
                        <StarIcon className="Star-icon" />
                    </div>
                </div>

                <div className="Recipe-info">
                    <div className="Recipe-name"> 요리명 
                    <span>{dtos["name"]}</span>
                        <div className="Hit">조회수</div>
                        
                    </div>
                    <div className="Recipe-intro"> 요리 소개 </div>
                    <div className="Recipe-Ingre"> 재료 <span>{dtos.ingredient}</span> </div>
                    <div className="Recipe-detail"> 조리 순서 
                    <span>{dtos.recipe}</span></div>
                </div>
            </div>
            </div>
       
    </div>
  );
}
export default SingleRecipe;