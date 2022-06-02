import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import StarIcon from '@material-ui/icons/StarRounded';
import Banner from './Banner';
import './SingleRecipe.css';

var datas=[];
function SingleRecipe() {
    const [dtos, setDtos] = useState([]);
    const [Ingredient, setIngredient] = useState([]);
    const [Recipe, setRecipe] = useState([]);
    const [StepImg, setStepImg] = useState([]);
    
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
                 setIngredient(data.ingredient.split("<br/>"));
                 setRecipe(data.recipe.split("<br/>"));
                 setStepImg(data.stepImg.split("<br/>"));
            });
    },[])
    
    return(
        <div>
            <div className="Header"><Banner/></div>
    
            <div className="Single-recipe">
                <div className="Recipe-img">
                    <img src={dtos.thumbnail} width="700"/>
                </div>
    
                <div className="Recipe-info">
                    <div className="Recipe-name">
                    <span>{dtos["name"]}</span></div>
                    <div className="Recipe-intro">
                    <span>{dtos["intro"]}</span></div>
                    
                    <div className="Recipe-Ingre"> &nbsp; [재료]<br/>
                    { Ingredient.map((a) => (
                    <span>{Ingredient.indexOf(a)+1 + ") " + a}<br/></span>
                    ))}</div>
                    <div className="Recipe-detail"> &nbsp; [조리 순서]<br/>
                    { Recipe.map((a) => (
                    <span>{Recipe.indexOf(a)+1 + ") " + a}<br/><img src={StepImg[Recipe.indexOf(a)]} width="700"/><br/><br/><br/></span>
                    ))}</div>
                    </div>
                </div>
            </div>
        );
}
export default SingleRecipe;