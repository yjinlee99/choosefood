import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import Banner from './Banner';
import './Writing.css';
import DetailList from "./WritingCreated"

function Writing() {
    const [ countList, setCountList ] = useState([0])
    let num = 1
    
    const onAddDetailDiv = () => {
        let countArr = [ ...countList ]
        let counter = countArr.slice(-1)[0]
        counter += 1
        countArr.push(counter)
        setCountList(countArr)

        num += 1

    }
    
    return (
        <div>         
            <div className="Header"><Banner/></div>

            <div id="Conditions">
                <div className="Condition" id="Naming">
                    <div className="Con"> 레시피 제목 </div>
                    <textarea className="Naming-textarea" />
                </div>

                <div  className="Condition" id="Introducing">
                    <div className="Con"> 요리 소개 </div>
                    <textarea className="Introducing-textarea" />
                </div>

                <div className="Condition" id="Cataloging">
                    <div className="Con"> 카테고리 (옵션) </div>
                    <div id="Catal-options">
                        <div className="Catal-option"> 테마별 </div>
                        <div className="Catal-option"> 미각별 </div>
                        <div className="Catal-option"> 재료별 </div>
                        <div className="Catal-option"> 상황별 </div>
                    </div>
                </div>

                <div className="Condition" id="Need">
                    <div className="Con"> 재료 </div>
                    <textarea className="Need-textarea" />
                </div>
                <div className="Con" id="StepsCon"> 레시피 </div>
                <div>
                <DetailList countList={countList} num={num}/>
                <div id="Step-add" className="Step" onClick={onAddDetailDiv}> + </div>
                <div className="Step" id="stepNum"> </div> 
                </div>
                <Link to="/SingleRecipe">
                    <div id="Submit" onClick={()=>{alert("등록되었습니다")}}> 등록하기 </div>
                </Link>

            </div>
        </div>
    );
}

export default Writing;