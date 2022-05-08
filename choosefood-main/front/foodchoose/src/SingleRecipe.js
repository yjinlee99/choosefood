import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import StarIcon from '@material-ui/icons/StarRounded';
import Banner from './Banner';
import './SingleRecipe.css';

function SingleRecipe() {
  return(
    <div>
        <div className="Header"><Banner/></div>

        <div className="Single-recipe">
            <div className="Recipe-img">
                <img src="" /> 이미지
                <div className="Star">
                    <StarIcon className="Star-icon"/>
                    <StarIcon className="Star-icon"/>
                    <StarIcon className="Star-icon"/>
                    <StarIcon className="Star-icon"/>
                    <StarIcon className="Star-icon"/>
                </div>
            </div>

            <div className="Recipe-info">
                <div className="Recipe-name"> 요리명 
                    <div className="Hit">조회수</div>
                </div>
                <div className="Recipe-intro"> 요리 소개 </div>
                <div className="Recipe-Ingre"> 재료 </div>
                <div className="Recipe-detail"> 조리 순서 </div>
            </div>
        </div>
    </div>
  );
}
export default SingleRecipe;