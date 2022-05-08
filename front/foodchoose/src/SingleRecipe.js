import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import StarIcon from '@material-ui/icons/StarRounded';
import Banner from './Banner';
import './SingleRecipe.css';

function stepFunc(step) {
    step = step?.replaceAll("_", "\n");
    return step;
}
function SingleRecipe() {
    const [dtos, setDtos] = useState([[]]);
    useEffect(() => {
        fetch('/dtos')
            .then(response => response.json())
            .then(dtos => {
                setDtos(dtos);
            });
    },[])
  return(
    <div>
        <div className="Header"><Banner/></div>

        <div className="Single-recipe" >
            <div className="Recipe-img">
                <img src={dtos[0]?.thumbnail} />
                <div className="Star">
                    <StarIcon className="Star-icon"/>
                    <StarIcon className="Star-icon"/>
                    <StarIcon className="Star-icon"/>
                    <StarIcon className="Star-icon"/>
                    <StarIcon className="Star-icon"/>
                </div>
            </div>

            <div className="Recipe-info">
                <div className="Recipe-name"> 요리명 {dtos[0]?.title}
                    <div className="Hit">조회수</div>
                </div>
                <div className="Recipe-intro"> 요리 소개 {dtos[0]?.intro}</div>
                <div className="Recipe-Ingre"> 재료 {dtos[0]?.ingredient}</div>
                <div className="Recipe-detail" id="step"> 조리 순서 {stepFunc(dtos[0]?.step)}</div>
            </div>
        </div>
    </div>
  );
}
export default SingleRecipe;